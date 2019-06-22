package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ValoracionDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

@Service("ServicioValoracion")
@Transactional
public class ServicioValoracionImpl implements ServicioValoracion {
	
	@Inject
	private ValoracionDao valoracionDao;
	private ValoracionPesoAlturaA valorPeso;
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
// calcular valoracione para jugadores

	@Override
	public Double valoracionPorEdad(Jugador jugador) {
		ValoracionEdad valorEdad=this.verValoraciondeEdadTabla();
		if(jugador.getEdad()< 20) {
			return valorEdad.getMenor20();
		}else if(jugador.getEdad() >= 20 && jugador.getEdad() <= 25) {
			return valorEdad.getDe20a25();
			
		} else if (jugador.getEdad() > 25 && jugador.getEdad() <= 30) {
			return valorEdad.getDe26a30();
			
		} else if(jugador.getEdad() > 30 && jugador.getEdad() <= 35) {
			return valorEdad.getDe31a35();
		}
		// Deberia tomar mayor a 35 años.
		return valorEdad.getMayor35();
	}

	@Override
	public Double valoracionPorAltura(Jugador jugador) {
		ValoracionAltura valorAltura=this.verValoracionAlturaTabla();
		if(jugador.getAltura() < 1.50) {
			return valorAltura.getMenor150cm();
			
		} else if(jugador.getAltura() >= 1.50 && jugador.getAltura() < 1.60) {
			return valorAltura.getEntre150y160cm();
			
		} else if(jugador.getAltura() >= 1.60 && jugador.getAltura() < 1.70) {
			return valorAltura.getEntre150y160cm();
			
		} else if(jugador.getAltura() >= 1.70 && jugador.getAltura() < 1.80) {
			return valorAltura.getEntre150y160cm();
			
		} else if(jugador.getAltura() >= 1.80 && jugador.getAltura() < 1.90) {
			return valorAltura.getEntre150y160cm();
		}
		//Mayor o igual a 190cm
		return valorAltura.getMayor190cm();
	}

	@Override
	public Double valoracionPorAlturaYPeso(Jugador jugador) {
		List<ValoracionPesoAlturaA> listaValoresPeso=valoracionDao.listaValoracionPesoAlturA();
		for(ValoracionPesoAlturaA lista: listaValoresPeso) {
			 valorPeso = new ValoracionPesoAlturaA();
			if(jugador.getAltura() < 1.50) {
				valorPeso=lista;
				break;			
			} else if(jugador.getAltura() >= 1.50 && jugador.getAltura() < 1.60) {
				valorPeso=lista;
				break;				
			} else if(jugador.getAltura() >= 1.60 && jugador.getAltura() < 1.70) {
				valorPeso=lista;
				break;				
			} else if(jugador.getAltura() >= 1.70 && jugador.getAltura() < 1.80) {
				valorPeso=lista;
				break;				
			} else if(jugador.getAltura() >= 1.80 && jugador.getAltura() < 1.90) {
				valorPeso=lista;
				break;			
				}
			//Mayor o igual a 190cm
			valorPeso=lista;
			break;
		}
		
		if(jugador.getPeso()> 60.0) {
			return valorPeso.getMenos60();
		}else if(jugador.getPeso()<= 60.0 && jugador.getPeso() < 70.0) {
			return valorPeso.getMenos60();
		}else if(jugador.getPeso()<= 70.0 && jugador.getPeso() < 80.0) {
			return valorPeso.getMenos60();
		}else if(jugador.getPeso()<= 80.0 && jugador.getPeso() < 90.0) {
			return valorPeso.getMenos60();
		}else if(jugador.getPeso()<= 90.0 && jugador.getPeso() < 100.0) {
			return valorPeso.getMenos60();
		}
		//// mas 100kg
		return valorPeso.getMas100();
	}
	
	
	

}
