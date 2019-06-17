package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Expulsion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("ServicioExpulsion")
@Transactional
public class ServicioExpulsionImpl implements ServicioExpulsion {
	@Inject
	JugadorDao jugadorDao;
	
	@Override
	public Double cantidadExpulsiones(Long id) {
		Jugador miJugador = jugadorDao.buscarJugador(id);
		List<Expulsion> expulsiones = miJugador.getExpulsiones();
		Double cantidadExpulsiones = (double) expulsiones.size();
		
		return cantidadExpulsiones;
	}

	@Override
	public Double promedioExpulsiones(Jugador jugador) {
		Double cantidadExpulsiones = this.cantidadExpulsiones(jugador.getId());
		Double partidosJugados = (double) jugador.getEquipo().getListaDePartidos().size();
		
		return cantidadExpulsiones / partidosJugados;
	}


	@Override
	public Double valoracionPorExpulsiones(Jugador jugador) {
		Double promedioExpulsiones = this.promedioExpulsiones(jugador);
		Double valoracion = promedioExpulsiones * (-10);
		
		return valoracion;
	}

}
