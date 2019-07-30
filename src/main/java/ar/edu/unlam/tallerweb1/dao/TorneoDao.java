package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface TorneoDao {
	public void agregarEquipo (Equipo equipo);
	public List<Torneo>listarTorneos();
	public Torneo listarTorneoId(Long id);
	public void agregarTorneo(Torneo torneo);
}
