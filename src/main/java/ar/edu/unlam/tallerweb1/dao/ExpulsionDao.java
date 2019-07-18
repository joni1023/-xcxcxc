package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Expulsion;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface ExpulsionDao {
	
	public void guardarExpulsion(Expulsion expulsion);
	
	public List<Expulsion> expulsionesJugador(Jugador jugador);
}
