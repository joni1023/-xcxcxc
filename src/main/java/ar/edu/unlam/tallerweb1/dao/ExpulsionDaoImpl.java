package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Expulsion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Repository("expulsionDao")
public class ExpulsionDaoImpl implements ExpulsionDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void guardarExpulsion(Expulsion expulsion) {
		sessionFactory.getCurrentSession().save(expulsion);
	}

	@Override
	public List<Expulsion> expulsionesJugador(Jugador jugador) {
		List<Expulsion> expulsiones = sessionFactory.getCurrentSession().createCriteria(Expulsion.class)
				.createAlias("jugador","jugador")
				.add(Restrictions.eq("jugador.id", jugador.getId()))
				.list();
		
		return expulsiones;
	}
}