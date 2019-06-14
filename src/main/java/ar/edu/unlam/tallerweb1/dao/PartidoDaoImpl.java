package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Partido;

@Repository("PartidoDao")
public class PartidoDaoImpl implements PartidoDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<Partido> listaDePartidos() {
		List<Partido> miLista=sessionFactory.getCurrentSession().createCriteria(Partido.class)
				.add(Restrictions.isNotNull("id"))
				.list();
				return miLista;
	}

}
