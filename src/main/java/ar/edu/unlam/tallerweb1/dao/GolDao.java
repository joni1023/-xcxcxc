package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface GolDao {
	
	public void guardarGol(Gol gol);
	
	public List<Gol> listaGolesJugador(Jugador jugador);
}