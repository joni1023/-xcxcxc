package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

public interface EquipoDao {
	public Equipo buscarEquipo(Long id);	
	public List<Equipo>listaDeEquipos();
}
