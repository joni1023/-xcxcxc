package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioAmonestacion {
	
	public Double cantidadAmonestaciones(Long id);
	
	public Double promedioAmonestaciones(Jugador jugador);
	
	public Double valoracionPorAmonestaciones(Jugador jugador);
	
	public void guardarAmonestacion(Amonestacion amonestacion);
	
	public List<Amonestacion> amonestacionesJugador(Jugador jugador);
}