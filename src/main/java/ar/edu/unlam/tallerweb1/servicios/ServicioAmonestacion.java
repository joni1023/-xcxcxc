package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioAmonestacion {
	
	public Double cantidadAmonestaciones(Long id);
	public Double promedioAmonestaciones(Jugador jugador);
	public Double valoracionPorAmonestaciones(Jugador jugador);

}