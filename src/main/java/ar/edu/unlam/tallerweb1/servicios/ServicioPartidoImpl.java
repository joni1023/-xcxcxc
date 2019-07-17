package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;
@Service("ServicioPartido")
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {
	@Inject
	private PartidoDao partidoDao;

	@Override
	public List<Partido> listaDePartidos() {		
		return partidoDao.listaDePartidos();
	}

	@Override
	public void crearPartido(Partido partido) {
		partidoDao.crearPartido(partido);

	}

	@Override
	public void elmiminarPartido(Partido partido) {
		partidoDao.elmiminarPartido(partido);

	}

	@Override
	public void modificarPartido(Partido partido) {
		partidoDao.modificarPartido(partido);

	}

	@Override
	public List<Partido> listaDePartidosEquipoID(long id) {
		
		return partidoDao.listaPartidoEquipoID(id);
	}

	@Override
	public List<Partido> listaDePartidosSinCargar() {
		return partidoDao.listaDePartidosSinCargar();
	}

	@Override
	public Partido buscarPartido(Long id) {
		return partidoDao.buscarPartido(id);
	}

	@Override
	public List<Jugador> listaDeJugadoresLocal(Partido partido) {

		return partidoDao.listaDeJugadoresLocal(partido);
	}

	@Override
	public List<Jugador> listaDeJugadoresVisitante(Partido partido) {
		return partidoDao.listaDeJugadoresVisitante(partido);
	}

	@Override
	public List<Gol> listaGolesLocal(Partido partido) {
		return partidoDao.listaGolesLocal(partido);
	}

	@Override
	public List<Gol> listaGolesVisitante(Partido partido) {
		return partidoDao.listaGolesVisitante(partido);
	}

}
