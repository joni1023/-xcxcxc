package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioGol {
	
	public Double valoracionPorPromedioDeGol(Jugador jugador);
	public Double promedioDeGol(Jugador jugador);
	
	public Double valoracionPorPromedioDeGolesEnContra(Jugador jugador);
	public Double promedioDeGolesEnContra(Jugador jugador);
	
	public Double golesEnContra(Long id);
	
	public void guardarGol(Gol gol);
	
	public List<Gol> golesJugador(Jugador jugador);
	
}