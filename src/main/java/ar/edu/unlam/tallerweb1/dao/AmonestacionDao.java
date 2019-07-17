package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface AmonestacionDao {
	
	public void guardarAmonestacion(Amonestacion amonestacion);
	
	public List<Amonestacion> amonestacionesJugador(Jugador jugador);
}
