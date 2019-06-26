package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

public interface ValoracionDao {
	
	public List<ValoracionEdad> valoracionEdadTabla();
	
	public List<ValoracionAltura> valoracionAlturaTabla();
	
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturA();
	
	
	public ValoracionEdad valoracionEdadTablaTipo(Long id);
	public ValoracionAltura valoracionAlturaTablaTipo(Long id);
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturATipo(String tipo);

}
