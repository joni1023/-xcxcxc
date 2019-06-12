package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioJugador {
	
	public List <Jugador> listarJugadores();
	
	public Double valoracionJugadorArquero(Long id);
	public Double valoracionJugadorDeCampo(Long id);
	
	public Double valoracionPorEdadJugadorArquero(Jugador jugador);
	public Double valoracionPorEdadJugadorDeCampo(Jugador jugador);

	public Double valoracionPorAltura(Jugador jugador);
	
	public Double valoracionPorAlturaYPesoArquero(Jugador jugador);
}