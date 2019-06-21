package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

public interface ServicioValoracion {
	
	public ValoracionEdad verValoraciondeEdadTabla();
	
	public ValoracionAltura verValoracionAlturaTabla();
	
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturaA();
	
	public ValoracionPesoAlturaA verValoracionPesoAlturaArqTabla();
	

}
