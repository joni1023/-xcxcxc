package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Repository("JugadorDao")
public class JugadorDaoImpl implements JugadorDao {
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Jugador> listaDeJugadores() {
		List <Jugador> miLista = sessionFactory.getCurrentSession().createCriteria(Jugador.class)
				.add(Restrictions.isNotNull("nombre"))
				.list();
		
		return miLista;
	}

	@Override
	public Jugador buscarJugador(Long id) {
		Jugador miJugadorBuscado=(Jugador) sessionFactory.getCurrentSession().createCriteria(Jugador.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		
		return miJugadorBuscado;
	}



}
