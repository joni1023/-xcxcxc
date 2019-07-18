package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ServicioJugador {
	
	public List <Jugador> listarJugadores();
	
	public Double valoracionJugador(Long id);

	public List <Jugador> listarJugadoresPorEquipo(Long idEquipo);
	
	public void agregarJugador(Jugador jugador);
	
	public Jugador buscarJugadorID(Long id);

	public void editarJugador(Jugador jugador);
	
	public void eliminarJugador(Jugador jugador);
	
	public Integer goles(Jugador jugador);
	
	public Integer amonestaciones(Jugador jugador);
	
	public Integer expulsiones(Jugador jugador);
}