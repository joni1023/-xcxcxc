package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionesGenerales;

public interface ServicioValoracion {
	
	public List<ValoracionEdad> verValoraciondeEdadTabla();
	
	public List<ValoracionAltura> verValoracionAlturaTabla();
	
	public List<ValoracionPesoAltura> listaValoracionPesoAltura();
	
	public ValoracionPesoAltura verValoracionPesoAlturaArqTabla();
	
	// Valores de jugadores
	public Double valoracionPorEdad(Jugador jugador);

	public Double valoracionPorAltura(Jugador jugador);
	
	public Double valoracionPorAlturaYPeso(Jugador jugador);
	
	// Prueba
	public List<ValoracionPesoAltura> listaValoracionPesoAlturaTipo(String tipo);
	
	public Integer valoracionGeneral();
}