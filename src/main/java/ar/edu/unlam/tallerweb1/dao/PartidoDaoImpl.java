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

	@Override
	public void crearPartido(Partido partido) {
		sessionFactory.getCurrentSession().save(partido);
		}

	@Override
	public void elmiminarPartido(Partido partido) {
		sessionFactory.getCurrentSession().delete(partido);
		
	}

	@Override
	public void modificarpertido(Partido partido) {
		sessionFactory.getCurrentSession().update(partido);
		
	}

	@Override
	public List<Partido> listaPartidoEquipoID(Long id) {
		List <Partido> miLista=sessionFactory.getCurrentSession().createCriteria(Partido.class)
				.createAlias("equipo1", "equipo1join")
				.add(Restrictions.eq("equipo1join.id", id))
				.list();
		return miLista;
	}
	
	
}