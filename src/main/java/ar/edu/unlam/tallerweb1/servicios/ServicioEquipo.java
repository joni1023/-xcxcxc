package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

public interface ServicioEquipo {
	public Double valoracionEquipo(Long id);
	
	public Equipo dandoRival(Equipo equipo);

	public List<Equipo> listarEquipos();
	
    public Equipo buscarEquipo(Long id);
    public Equipo buscarEquipoNombre(String nombre);

    public void agregarEquipo(Equipo equipo);
   
    public void editarEquipo(Equipo equipo);
   
    public void eliminarEquipo(Long id);
    
}

