package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Repository("golDao")
public class GolDaoImpl implements GolDao {
	@Inject
    private SessionFactory sessionFactory;
	
	
	@Override
	public void guardarGol(Gol gol) {
		sessionFactory.getCurrentSession().save(gol);
	}

	@Override
	public List<Gol> listaGolesJugador(Jugador jugador) {
		List<Gol> goles = sessionFactory.getCurrentSession().createCriteria(Gol.class)
				.createAlias("jugador","jugador")
				.add(Restrictions.eq("jugador.id", jugador.getId()))
				.list();
		
		return goles;
	}
}