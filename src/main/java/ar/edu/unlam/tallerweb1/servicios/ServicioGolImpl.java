package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.JugadorArquero;
import ar.edu.unlam.tallerweb1.modelo.JugadorDeCampo;

@Service("ServicioGol")
@Transactional
public class ServicioGolImpl implements ServicioGol{
	
	@Override
	public Double promedioDeGol(Jugador jugador) {
		Double partidosJugados = (double)jugador.getEquipo().getListaDePartidos().size();
		Double golesConvertidos = (double)jugador.getGoles().size();
		
		return golesConvertidos/partidosJugados;
	}
	
	@Override
	public Double valoracionPorPromedioDeGol(Jugador jugador) {
		Double promedio = this.promedioDeGol(jugador);
		Double valoracion = promedio;
		if(jugador.getClass()==JugadorDeCampo.class) {
			
		
			if(promedio > 10.0) {
			valoracion = 10.0;
			}
		}else if(jugador.getClass()==JugadorArquero.class) {
			valoracion = valoracion*3;
			if(valoracion > 10.0) {
				valoracion = 10.0;
			}
		}
		return valoracion;
		
	}
}
