package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

public interface PartidoDao {
	
	List<Partido> listaDePartidos();
	
	public void crearPartido (Partido partido);
	public void elmiminarPartido(Partido partido);
	public void modificarPartido(Partido partido);
	public List<Partido> listaPartidoEquipoID(Long id);
	public List<Partido> listaDePartidosSinCargar();
	public Partido buscarPartido(Long id);
	public List<Jugador> listaDeJugadoresLocal(Partido partido);
	public List<Jugador> listaDeJugadoresVisitante(Partido partido);
	public List<Gol> listaGolesLocal(Partido partido);
	public List<Gol> listaGolesVisitante(Partido partido);
}