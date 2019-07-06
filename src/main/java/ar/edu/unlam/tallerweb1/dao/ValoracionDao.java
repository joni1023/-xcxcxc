package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionesGenerales;

public interface ValoracionDao {
	
	public List<ValoracionEdad> valoracionEdadTabla();
	public List<ValoracionAltura> valoracionAlturaTabla();
	public List<ValoracionPesoAltura> listaValoracionPesoAltura();
	
	public ValoracionEdad valoracionEdadTablaTipo(Long id);
	public ValoracionAltura valoracionAlturaTablaTipo(Long id);
	public List<ValoracionPesoAltura> listaValoracionPesoAlturaTipo(String tipo);
	
	public ValoracionesGenerales valoracionGeneral();
	public void modificarTablaValoracionEdad (ValoracionEdad nuevaValoracionEdad);
	public void modificarTablaValoracionAltura (ValoracionAltura nuevaValoracionAltura);
	public void modificarTablaValoracionPesoAltura (ValoracionPesoAltura nuevaValoracionPesoAltura);
	public void modificarTablaValoracionGeneral (ValoracionEdad nuevaValoracionGeneral);
	public ValoracionPesoAltura valoracionPesoAlturaPorId(Long id);

}