package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

public interface ValoracionDao {
	
	public ValoracionEdad valoracionEdadTabla();
	
	public ValoracionAltura valoracionAlturaTabla();
	
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturA();
	
	public ValoracionPesoAlturaA valoracionesoAlturaArqTabla(Long id);

}
