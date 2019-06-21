package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("ServicioAmonestacion")
@Transactional
public class ServicioAmonestacionImpl implements ServicioAmonestacion {
	@Inject
	 private JugadorDao jugadorDao;
	
	@Override
	public Double cantidadAmonestaciones(Long id) {
		Jugador miJugador = jugadorDao.buscarJugador(id);
		List<Amonestacion> amonestaciones = miJugador.getAmonestaciones();
		Double cantidadAmonestaciones = 0.0;
		if(amonestaciones.isEmpty()) {
			return 0.0;
		}else {
			for (Amonestacion amonestacion : amonestaciones) {
				cantidadAmonestaciones += amonestacion.getCantidad();
			}
			
			return cantidadAmonestaciones;
		}
	}

	@Override
	public Double promedioAmonestaciones(Jugador jugador) {
		Double cantidadAmonestaciones = this.cantidadAmonestaciones(jugador.getId());
		Double partidosJugados = (double) jugador.getEquipo().getListaDePartidos().size();
		if(partidosJugados == 0 || partidosJugados == null) {
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
	
}
