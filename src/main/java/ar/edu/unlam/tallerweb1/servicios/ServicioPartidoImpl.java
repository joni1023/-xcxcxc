package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;
@Service("ServicioPartido")
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {
	@Inject
	private PartidoDao partidoDao;
	@Inject
	private ServicioEquipo servicioEquipo;
	
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
	public List<Partido> listaDePartidosEquipoID(Long id) {
		
		List <Partido> miLista = this.listaDePartidos();
		List <Partido> miListanueva = new ArrayList <Partido> ();
		for (Partido e:miLista) {
			if(e.getLocal().getId()==id) {
				miListanueva.add(e);
			}else if(e.getVisitante().getId()==id) {
				miListanueva.add(e);
			}
		}
		return miListanueva;
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
	@Override
	public Integer golesLocal(Long id) {
		Partido partido = this.buscarPartido(id);
		List<Gol> golesLocal = this.listaGolesLocal(partido);
		Integer goles = 0;
		for (Gol gol : golesLocal) {
			goles = goles + gol.getCantidad();
		}
		
		return goles;
	}
	@Override
	public Integer golesVisitante(Long id) {
		Partido partido = this.buscarPartido(id);
		List<Gol> golesVisitante = this.listaGolesVisitante(partido);
		Integer goles = 0;
		for (Gol gol : golesVisitante) {
			goles = goles + gol.getCantidad();
		}
		
		return goles;
	}


	@Override
	public Integer partidosJugados(Long id) {
		Equipo equipo = servicioEquipo.buscarEquipo(id);
		List<Partido> partidosJugados = this.listaDePartidosEquipoID(equipo.getId());
		return partidosJugados.size();
	}
	@Override
	public Integer partidosGanados(Long id) {
		Equipo equipo = servicioEquipo.buscarEquipo(id);
		List<Partido> partidosJugados = this.listaDePartidosEquipoID(equipo.getId());
		Integer partidosGanados = 0;
		for (Partido partido : partidosJugados) {
			if(partido.getLocal().equals(equipo)) {
				if(this.golesLocal(partido.getId()) > this.golesVisitante(partido.getId())) {
					partidosGanados++;
				}
			}else if(partido.getVisitante().equals(equipo)) {
				if(this.golesVisitante(partido.getId()) > this.golesLocal(partido.getId())) {
					partidosGanados++;
				}
			}
		}
		return partidosGanados;
	}
	@Override
	public Integer partidosEmpatados(Long id) {
		Equipo equipo = servicioEquipo.buscarEquipo(id);
		List<Partido> partidosJugados = this.listaDePartidosEquipoID(equipo.getId());
		Integer partidosEmpatados = 0;
		for (Partido partido : partidosJugados) {
			if(this.golesLocal(partido.getId()) == this.golesVisitante(partido.getId())) {
				partidosEmpatados++;
			}
		}
		return partidosEmpatados;
	}

	@Override
	public Integer partidosPerdidos(Long id) {
		Equipo equipo = servicioEquipo.buscarEquipo(id);	
		List<Partido> partidosJugados = this.listaDePartidosEquipoID(equipo.getId());
		Integer partidosPerdidos = 0;
		
		for (Partido partido : partidosJugados) {
			if(partido.getLocal().equals(equipo)) {
				if(this.golesLocal(partido.getId()) < this.golesVisitante(partido.getId())) {
					partidosPerdidos++;
				}
			}else if(partido.getVisitante().equals(equipo)) {
				if(this.golesVisitante(partido.getId()) < this.golesLocal(partido.getId())) {
					partidosPerdidos++;
				}
			}
		}
		return partidosPerdidos;
	}


}
