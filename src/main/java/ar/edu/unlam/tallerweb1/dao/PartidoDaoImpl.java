package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
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
	public void modificarPartido(Partido partido) {
		sessionFactory.getCurrentSession().saveOrUpdate(partido);
		
	}

	@Override
	public List<Partido> listaPartidoEquipoID(Long id) {
		List <Partido> miLista=sessionFactory.getCurrentSession().createCriteria(Partido.class)
				.createAlias("equipo1", "equipo1join")
				.add(Restrictions.eq("equipo1join.id", id))
				.list();
		return miLista;
	}

	@Override
	public List<Partido> listaDePartidosSinCargar() {
		List<Partido> miLista=sessionFactory.getCurrentSession().createCriteria(Partido.class)
				.add(Restrictions.isNotNull("id"))
				.add(Restrictions.eq("datosCargados",false))
				.list();
				return miLista;
	}

	@Override
	public Partido buscarPartido(Long id) {
		return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}

	@Override
	public List<Jugador> listaDeJugadoresLocal(Partido partido) {
		List <Jugador> miListaDeJugadores = sessionFactory.getCurrentSession().createCriteria(Jugador.class)
                .createAlias("equipo", "equipo")
				.add(Restrictions.eq("equipo.id",partido.getLocal().getId()))
                .list();

			return miListaDeJugadores;
	}

	@Override
	public List<Jugador> listaDeJugadoresVisitante(Partido partido) {
		List <Jugador> miListaDeJugadores = sessionFactory.getCurrentSession().createCriteria(Jugador.class)
                .createAlias("equipo", "equipo")
				.add(Restrictions.eq("equipo.id",partido.getVisitante().getId()))
                .list();

			return miListaDeJugadores;
	}

	@Override
	public List<Gol> listaGolesLocal(Partido partido) {
		List<Gol> listaGolesLocal = sessionFactory.getCurrentSession().createCriteria(Gol.class)
				.createAlias("partido","partido")
				.add(Restrictions.eq("partido.id",partido.getId()))
				.createAlias("partido.local","local")
				.add(Restrictions.eq("local.id",partido.getLocal().getId()))
				.list();
		
		return listaGolesLocal;
	}

	@Override
	public List<Gol> listaGolesVisitante(Partido partido) {
		List<Gol> listaGolesVisitante = sessionFactory.getCurrentSession().createCriteria(Gol.class)
				.createAlias("partido","partido")
				.add(Restrictions.eq("partido.id",partido.getId()))
				.createAlias("partido.visitante","visitante")
				.add(Restrictions.eq("visitante.id",partido.getVisitante().getId()))
				.list();
		
		return listaGolesVisitante;
	}
	
	
}