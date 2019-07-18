package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AmonestacionDao;
import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;

@Service("ServicioAmonestacion")
@Transactional
public class ServicioAmonestacionImpl implements ServicioAmonestacion {
	@Inject
	private JugadorDao jugadorDao;
	@Inject
	private PartidoDao partidoDao;
	@Inject
	private AmonestacionDao amonestacionDao;
	
	@Override
	public Double cantidadAmonestaciones(Long id) {
		Jugador miJugador = jugadorDao.buscarJugador(id);
		List<Amonestacion> amonestaciones = amonestacionDao.amonestacionesJugador(miJugador);
		Double cantidadAmonestaciones = 0.0;
		if (amonestaciones.isEmpty()) {
			return 0.0;
		} else {
			for (Amonestacion amonestacion : amonestaciones) {
				cantidadAmonestaciones += amonestacion.getCantidad();
			}

			return cantidadAmonestaciones;
		}
	}

	@Override
	public Double promedioAmonestaciones(Jugador jugador) {
		List<Partido> listaDePartidos = partidoDao.listaDePartidos();	
		Double cantidadAmonestaciones = this.cantidadAmonestaciones(jugador.getId());
		Double partidosJugados = 0.0;
	
		for (Partido partido : listaDePartidos) {
			if (partido.getLocal().equals(jugador.getEquipo())
					|| partido.getVisitante().equals(jugador.getEquipo())) {
				partidosJugados++;
			}
		}
		if(partidosJugados == 0.0) {
			return 0.0;
		}else {
			return cantidadAmonestaciones / partidosJugados;
		}
	}

	@Override
	public Double valoracionPorAmonestaciones(Jugador jugador) {
		Double promedioAmonestaciones = this.promedioAmonestaciones(jugador);
		Double valoracion = promedioAmonestaciones * (-5);

		return valoracion;
	}

	@Override
	public void guardarAmonestacion(Amonestacion amonestacion) {
		amonestacionDao.guardarAmonestacion(amonestacion);
		
	}

	@Override
	public List<Amonestacion> amonestacionesJugador(Jugador jugador) {
		return amonestacionDao.amonestacionesJugador(jugador);
	}

}
