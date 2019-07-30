package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTorneo {
	public void crearTorneo(List<Equipo> listaDeEquipos);
	public void agregarTorneo(Torneo torneo);
	public void agregarEquipo(Equipo equipo);
	public List<Torneo> listarTorneos();
	public Torneo listarTorneoId(Long id);
}
