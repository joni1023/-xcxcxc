package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("servicioJugador")
@Transactional
public class ServicioJugadorImpl implements ServicioJugador {

	@Inject
	private JugadorDao servicioJugadorDao;
	
	@Override
	public List<Jugador> listarJugadores() {
		
		return servicioJugadorDao.listaDeJugadores();
	}

	@Override
	public Double valoracionJugadorArquero (Long id) {
		Jugador miJugador=servicioJugadorDao.buscarJugador(id);
		Double valorEdad= this.valoracioPorEdad(miJugador);
		Double valorAltura=this.valoracionPorAltura(miJugador);
		Double valorPesoAltura=this.valoracionPorAlturaYPesoArquero(miJugador);
		// llamar al servicio gol para saber cuantos goles se comio e arquero
		Double valorGoles=0.0;
		// llamar a servicio partido para saber la racha de partidos sin hacerle gol
		Double valorPorPorteriaInvatible=0.0;
		
		
		return valorEdad+valorAltura+valorPesoAltura+valorGoles+valorPorPorteriaInvatible;
	}

	@Override
	public Double valoracioPorEdad(Jugador jugador) {
		if(jugador.getEdad()<20) {
			return 9.5;
		}else if(jugador.getEdad()>=20 && jugador.getEdad()<=25) {
			return 9.5;
		}else if (jugador.getEdad()>25 && jugador.getEdad()<=30) {
			return 10.0;
		}else if(jugador.getEdad()>30 && jugador.getEdad()<=35) {
			return 7.5;
		}
		//deberia tomar mayor  a 35
		return 5.0;
	}

	@Override
	public Double valoracionPorAltura(Jugador jugador) {
		if(jugador.getAltura()< 1.50) {
			return 6.5;
		}else if(jugador.getAltura()>=1.50 && jugador.getAltura()<=1.70) {
			return 7.5;
		}else if(jugador.getAltura()>1.70 && jugador.getAltura()<=1.90) {
			return 10.0;
		} 
		//deberia ser mas de 1.90 metros	
		return 12.0;
	}

	@Override
	public Double valoracionPorAlturaYPesoArquero(Jugador jugador) {
		Double valor = 0.0;
		if(jugador.getAltura()<1.50) {
			if(jugador.getPeso()< 60.0) {
				valor= 10.0;
			}else if(jugador.getPeso()>=60.0 && jugador.getPeso()<=70.0) {
				valor= 9.0;
			}else if(jugador.getPeso()<70.0) {
				valor= 7.0;
			}
			//
		}else if(jugador.getAltura()>=1.50 && jugador.getAltura()<=1.70){
			if(jugador.getPeso()<60.0) {
				valor= 9.0;
			}else if(jugador.getPeso()>=60.0 && jugador.getPeso()<=70.0) {
				valor= 10.0;
			}else if(jugador.getPeso()>=70.0 && jugador.getPeso()<=80.0) {
				valor= 11.0;
			}else if(jugador.getPeso()>80) {
				valor= 7.0;
			}
			////
		}else if (jugador.getAltura()>1.70 && jugador.getAltura()<=1.90) {
			if(jugador.getPeso()<70.0) {
				valor= 9.5;
			}else if(jugador.getPeso()>=70.0 && jugador.getPeso()<=90.0) {
				valor= 10.0;
			}else if(jugador.getPeso()>=90.0 && jugador.getPeso()<=100.0) {
				valor= 11.0;
			}else if(jugador.getPeso()>100) {
				valor= 8.0;
			}
			//
		}else //if(jugador.getAltura()>1.90) 
		{
			if(jugador.getPeso()<80.0) {
				valor= 8.0;
			}else if(jugador.getPeso()>=80.0 && jugador.getPeso()<=90.0) {
				valor= 9.0;
			}else if(jugador.getPeso()>=90.0 && jugador.getPeso()<=105.0) {
				valor= 10.0;
			}else if(jugador.getPeso()>105) {
				valor= 8.0;
			}
		}
		 return valor;	
	}
	

}
