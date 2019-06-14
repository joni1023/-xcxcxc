package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.JugadorArquero;
import ar.edu.unlam.tallerweb1.modelo.JugadorDeCampo;

@Service("ServicioJugador")
@Transactional
public class ServicioJugadorImpl implements ServicioJugador {

	@Inject
	private JugadorDao servicioJugadorDao;
	@Inject
	private ServicioGol servicioGol;
	
	@Override
	public List<Jugador> listarJugadores() {
		
		return servicioJugadorDao.listaDeJugadores();
	}

	// VALORACION DE UN ARQUERO.
	@Override
	public Double valoracionJugadorArquero(Long id) {
		Jugador miJugador = servicioJugadorDao.buscarJugador(id);
		Double valorEdad = this.valoracionPorEdadJugadorArquero(miJugador);
		Double valorAltura = this.valoracionPorAltura(miJugador);
		Double valorPesoAltura = this.valoracionPorAlturaYPeso(miJugador);
		Double valorPromedioDeGol = servicioGol.valoracionPorPromedioDeGol(miJugador);
		// Llamar al servicio gol para saber cuantos goles se comio el arquero.
		Double valorGolesRecibidos = 0.0;
		// Llamar al servicio partido para saber la racha de partidos sin hacerle gol.
		Double valorPorPorteriaImbatible = 0.0;
		
		return valorEdad + valorAltura + valorPesoAltura + valorGolesRecibidos + valorPorPorteriaImbatible + valorPromedioDeGol;
	}

	@Override
	public Double valoracionPorEdadJugadorArquero(Jugador jugador) {
		
		if(jugador.getEdad() < 20) {
			return 8.0;
			
		} else if(jugador.getEdad() >= 20 && jugador.getEdad() <= 25) {
			return 9.0;
			
		} else if (jugador.getEdad() > 25 && jugador.getEdad() <= 30) {
			return 10.0;
			
		} else if(jugador.getEdad() > 30 && jugador.getEdad() <= 35) {
			return 8.0;
		}
		
		// Deberia tomar mayor a 35 años.
		return 5.0;
	}

	@Override
	public Double valoracionPorAltura(Jugador jugador) {
		Double valoracion = 0.0;
		if(jugador.getClass() == JugadorArquero.class) {
		if(jugador.getAltura() < 1.70) {
			valoracion = 5.0;
			
		} else if(jugador.getAltura() >= 1.70 && jugador.getAltura() <= 1.85) {
			valoracion = 7.5;
			
		} else{
			valoracion =  10.0;
		}

		}else if (jugador.getClass() == JugadorDeCampo.class) {
			if(jugador.getAltura() <= 1.60) {
				valoracion = 5.0;
			}else if(jugador.getAltura() > 1.60 && jugador.getAltura() <= 1.75) {
				valoracion = 7.5;
			}else {
				valoracion  = 10.0;
			}
		}
		return valoracion;
	}

	@Override
	public Double valoracionPorAlturaYPeso(Jugador jugador) {
		
		Double valor = 0.0;
		if(jugador.getClass() == JugadorArquero.class) {
		if(jugador.getAltura() <= 1.70) {
			if(jugador.getPeso() < 60.0) {
				valor = 4.0;
				
			} else if(jugador.getPeso() >= 60.0 && jugador.getPeso() <= 75.0) {
				valor = 6.0;
				
			} else if(jugador.getPeso() > 75.0) {
				valor = 4.0;
			}
			/*========================================*/
		} else if(jugador.getAltura() > 1.70 && jugador.getAltura() <= 1.85){
			if(jugador.getPeso() < 60.0) {
				valor = 7.0;
				
			} else if(jugador.getPeso() >= 60.0 && jugador.getPeso() <= 70.0) {
				valor = 9.0;
				
			} else if(jugador.getPeso() >= 70.0 && jugador.getPeso() <= 80.0) {
				valor = 8.0;
				
			} else if(jugador.getPeso() > 80) {
				valor = 7.0;
			}
			/*========================================*/
		} else if (jugador.getAltura() > 1.85 && jugador.getAltura() <= 1.90) {
			if(jugador.getPeso() < 70.0) {
				valor = 8.5;
				
			} else if(jugador.getPeso() >= 70.0 && jugador.getPeso() <= 90.0) {
				valor = 10.0;
				
			} else if(jugador.getPeso() >= 90.0 && jugador.getPeso() <= 100.0) {
				valor = 8.0;
				
			} else if(jugador.getPeso() > 100) {
				valor = 6.0;
			}else {
				if(jugador.getPeso()<70.0) {
					valor = 4.0;
				}else if(jugador.getPeso() >=70 && jugador.getPeso() <= 90.0) {
					valor = 6.0;
				}else if (jugador.getPeso() > 90 && jugador.getPeso() <= 100) {
					valor = 8.0;
				}else if(jugador.getPeso() > 100){
					valor = 4.0;
				}
			}
		}
	}else if(jugador.getClass() == JugadorDeCampo.class) {
		if(jugador.getAltura() <= 1.60) {
			if(jugador.getPeso() < 60.0) {
				valor = 4.0;
				
			} else if(jugador.getPeso() >= 60.0 && jugador.getPeso() <= 75.0) {
				valor = 6.0;
				
			} else if(jugador.getPeso() > 75.0) {
				valor = 4.0;
			}
			/*========================================*/
		} else if(jugador.getAltura() > 1.60 && jugador.getAltura() <= 1.75){
			if(jugador.getPeso() < 60.0) {
				valor = 7.0;
				
			} else if(jugador.getPeso() >= 60.0 && jugador.getPeso() <= 70.0) {
				valor = 9.0;
				
			} else if(jugador.getPeso() >= 70.0 && jugador.getPeso() <= 80.0) {
				valor = 8.0;
				
			} else if(jugador.getPeso() > 80) {
				valor = 7.0;
			}
			/*========================================*/
		} else{
			if(jugador.getPeso() < 70.0) {
				valor = 8.5;
				
			} else if(jugador.getPeso() >= 70.0 && jugador.getPeso() <= 90.0) {
				valor = 10.0;
				
			} else if(jugador.getPeso() >= 90.0 && jugador.getPeso() <= 100.0) {
				valor = 8.0;
				
			} else if(jugador.getPeso() > 100) {
				valor = 6.0;
			
			}
		}
	}
			/*========================================*/
		
		
		 return valor;	
	}
	
	// VALORACION DE UN JUGADOR DE CAMPO.
	@Override
	public Double valoracionJugadorDeCampo(Long id) {
		Jugador miJugador = servicioJugadorDao.buscarJugador(id);
		Double valorEdad = this.valoracionPorEdadJugadorDeCampo(miJugador);
		Double valorPromedioDeGol = servicioGol.valoracionPorPromedioDeGol(miJugador);
		Double valorAltura = this.valoracionPorAltura(miJugador);
		Double valorAlturaPeso = this.valoracionPorAlturaYPeso(miJugador);
		
		return valorEdad + valorPromedioDeGol + valorAltura + valorAlturaPeso;
	}

	@Override
	public Double valoracionPorEdadJugadorDeCampo(Jugador jugador) {
		
		if(jugador.getEdad() < 20) {
			return 8.0;
			
		} else if(jugador.getEdad() >= 20 && jugador.getEdad() <= 25) {
			return 9.0;
			
		} else if (jugador.getEdad() > 25 && jugador.getEdad() <= 30) {
			return 10.0;
			
		} else if(jugador.getEdad() > 30 && jugador.getEdad() <= 35) {
			return 8.0;
		}
		
		// Deberia tomar mayor a 35 años.
		return 5.0;
	}
	
	
	
}