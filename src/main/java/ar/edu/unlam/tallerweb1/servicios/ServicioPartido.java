package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface ServicioPartido {
	
	public List<Partido> listaDePartidos();
	
	public void crearPartido (Partido partido);
	public void elmiminarPartido(Partido partido);
	public void modificarPartido(Partido partido);

	public List<Partido> listaDePartidosEquipoID (Long id);
	
	public List<Partido>listaDePartidosSinCargar();
	
	public Partido buscarPartido(Long id);
	
	public List<Jugador> listaDeJugadoresLocal(Partido partido);
	public List<Jugador> listaDeJugadoresVisitante(Partido partido);
	
	public List<Gol> listaGolesLocal(Partido partido);
	public List<Gol> listaGolesVisitante(Partido partido);
	
	public Integer partidosJugados(Long id);
	public Integer partidosGanados(Long id);
	public Integer partidosEmpatados(Long id);
	public Integer partidosPerdidos(Long id);
	
	public Integer golesLocal(Long id);
	public Integer golesVisitante(Long id);
}
