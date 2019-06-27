package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

public interface ServicioEquipo {
	public List<Equipo>listarEquipos();
	public Double valoracionEquipo(Long id);
}
