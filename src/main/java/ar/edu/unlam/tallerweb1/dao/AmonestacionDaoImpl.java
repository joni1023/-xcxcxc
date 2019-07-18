package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Repository("amonestacionDao")
public class AmonestacionDaoImpl implements AmonestacionDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void guardarAmonestacion(Amonestacion amonestacion) {
		sessionFactory.getCurrentSession().save(amonestacion);
	}

	@Override
	public List<Amonestacion> amonestacionesJugador(Jugador jugador) {
		List<Amonestacion> amonestaciones = sessionFactory.getCurrentSession().createCriteria(Amonestacion.class)
				.createAlias("jugador","jugador")
				.add(Restrictions.eq("jugador.id", jugador.getId()))
				.list();
				
		return amonestaciones;
	}
}