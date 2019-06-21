package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ValoracionDao;
import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

@Service("ServicioValoracion")
@Transactional
public class ServicioValoracionImpl implements ServicioValoracion {
	
	@Inject
	private ValoracionDao valoracionDao;
// consulta a tabla
	@Override
	public ValoracionEdad verValoraciondeEdadTabla() {
		
		return valoracionDao.valoracionEdadTabla();
	}

	@Override
	public ValoracionAltura verValoracionAlturaTabla() {	
		return valoracionDao.valoracionAlturaTabla();
	}
	
	@Override
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturaA() {
		
		return valoracionDao.listaValoracionPesoAlturA();
	}
// termina consulta
	
	@Override
	public ValoracionPesoAlturaA verValoracionPesoAlturaArqTabla() {
		// id de altura 1->menos 150cm 2->entre150y160 3->entre160y170 4->entre170y180 5->entre180y190 6->mayor190 
		return null;
	}

	

}
