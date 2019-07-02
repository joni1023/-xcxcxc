package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioExpulsion {
	
	public Double cantidadExpulsiones(Long id);
	public Double promedioExpulsiones(Jugador jugador);
	public Double valoracionPorExpulsiones(Jugador jugador);
	
}