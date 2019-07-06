package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ValoracionDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionesGenerales;

@Service("ServicioValoracion")
@Transactional
public class ServicioValoracionImpl implements ServicioValoracion {
	
	@Inject
	private ValoracionDao valoracionDao;
	private ValoracionPesoAltura valorPeso;
	
	// Consulta a lista tabla
	@Override
	public List<ValoracionEdad> verValoraciondeEdadTabla() {
		
		return valoracionDao.valoracionEdadTabla();
	}

	@Override
	public List<ValoracionAltura> verValoracionAlturaTabla() {	
		return valoracionDao.valoracionAlturaTabla();
	}
	
	@Override
	public List<ValoracionPesoAltura> listaValoracionPesoAltura() {
		
		return valoracionDao.listaValoracionPesoAltura();
	}

	// Consulta enviando jugador
	@Override
	public ValoracionPesoAltura verValoracionPesoAlturaArqTabla() {
		// id de altura 1->menos 150cm 2->entre150y160 3->entre160y170 4->entre170y180 5->entre180y190 6->mayor190 
		return null;
	}
	
	// Calcular valoraciones para jugadores

	@Override
	public Double valoracionPorEdad(Jugador jugador) {
		ValoracionEdad valorEdad=new ValoracionEdad();
		String Arquero = "Arquero";
		String posicion = jugador.getPosicion();
		if( posicion.equals(Arquero)) {
			long id = 1l;
			valorEdad = valoracionDao.valoracionEdadTablaTipo(id);
		} else {
			long id = 2l;
			valorEdad = valoracionDao.valoracionEdadTablaTipo(id);
		}
		
		if(jugador.getEdad()< 20) {
			return valorEdad.getMenor20();
		} else if(jugador.getEdad() >= 20 && jugador.getEdad() <= 25) {
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
		ValoracionAltura valorAltura=new ValoracionAltura();
		String Arquero="Arquero";
		String posicion=jugador.getPosicion();
		if(posicion.equals(Arquero)) {
			valorAltura = valoracionDao.valoracionAlturaTablaTipo(1l);
		} else {
			valorAltura=valoracionDao.valoracionAlturaTablaTipo(2l);
		}
		
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
		List<ValoracionPesoAltura> listaValoresPeso = new ArrayList<ValoracionPesoAltura> ();
		String Arquero = "Arquero";
		String posicion = jugador.getPosicion();
		if( posicion.equals(Arquero)) {
			listaValoresPeso = valoracionDao.listaValoracionPesoAlturaTipo(jugador.getPosicion());
		} else {
			listaValoresPeso = valoracionDao.listaValoracionPesoAlturaTipo(jugador.getPosicion());
		}
		
		valorPeso = new ValoracionPesoAltura();
			if(jugador.getAltura() < 1.50) {
				valorPeso = listaValoresPeso.get(0);
					
			} else if(jugador.getAltura() >= 1.50 && jugador.getAltura() < 1.60) {
				valorPeso = listaValoresPeso.get(1);
							
			} else if(jugador.getAltura() >= 1.60 && jugador.getAltura() < 1.70) {
				valorPeso = listaValoresPeso.get(2);
							
			} else if(jugador.getAltura() >= 1.70 && jugador.getAltura() < 1.80) {
				valorPeso = listaValoresPeso.get(3);
								
			} else if(jugador.getAltura() >= 1.80 && jugador.getAltura() < 1.90) {
				valorPeso = listaValoresPeso.get(4);
							
			} else {
				//Mayor o igual a 190cm
				valorPeso = listaValoresPeso.get(5);
			}
		
		if(jugador.getPeso() < 60.0) {
			return valorPeso.getMenos60();
		} else if(jugador.getPeso() >= 60.0 && jugador.getPeso() < 70.0) {
			return valorPeso.getEntre60y70();
		} else if(jugador.getPeso() >= 70.0 && jugador.getPeso() < 80.0) {
			return valorPeso.getEntre70y80();
		} else if(jugador.getPeso() >= 80.0 && jugador.getPeso() < 90.0) {
			return valorPeso.getEntre80y90();
		} else if(jugador.getPeso() >= 90.0 && jugador.getPeso() < 100.0) {
			return valorPeso.getEntre90y100();
		}
		
		// Mas de 100kg
		return valorPeso.getMas100();
	}

	@Override
	public List<ValoracionPesoAltura> listaValoracionPesoAlturaTipo(String tipo) {
		
		return valoracionDao.listaValoracionPesoAlturaTipo(tipo);
	}

	@Override
	public Integer valoracionGeneralRadio() {
		
		return valoracionDao.valoracionGeneral().getRadioMedicion();
	}

	@Override
	public ValoracionEdad trearValoracionEdadPorId(Long id) {
		return valoracionDao.valoracionEdadTablaTipo(id);
	}

	@Override
	public void modificarTablaEdad(ValoracionEdad nuevaValoracion) {
		valoracionDao.modificarTablaValoracionEdad(nuevaValoracion);
		
	}

	@Override
	public ValoracionAltura traerValoracionAlturaPorID(Long id) {
		return valoracionDao.valoracionAlturaTablaTipo(id);
	}

	@Override
	public void modificarTablaAltura(ValoracionAltura nuevaValoracion) {
		valoracionDao.modificarTablaValoracionAltura(nuevaValoracion);
		
	}

	@Override
	public ValoracionPesoAltura traerValoracionPesoAlturaPorID(Long id) {
		return valoracionDao.valoracionPesoAlturaPorId(id);
	}

	@Override
	public void modificarTablaEdad(ValoracionPesoAltura nuevaValoracion) {
		valoracionDao.modificarTablaValoracionPesoAltura(nuevaValoracion);
		
	}	
}