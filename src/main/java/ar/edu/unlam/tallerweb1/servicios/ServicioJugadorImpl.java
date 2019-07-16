package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("ServicioJugador")
@Transactional
public class ServicioJugadorImpl implements ServicioJugador {

	@Inject
	private JugadorDao servicioJugadorDao;
	
	@Inject
	private ServicioGol servicioGol;
	
	@Inject
	private ServicioAmonestacion servicioAmonestacion;
	
	@Inject
	private ServicioExpulsion servicioExpulsion;
	
	@Inject
	private ServicioValoracion servicioValoracion;
	
	@Override
	public List<Jugador> listarJugadores() {
		
		return servicioJugadorDao.listaDeJugadores();
	}

	@Override
	public Double valoracionJugador(Long id) {
		Jugador miJugador = servicioJugadorDao.buscarJugador(id);
		Double valoracion = 0.0;
		
		/*if(miJugador.getClass() == JugadorArquero.class) {
		Double valorPromedioDeGol = servicioGol.valoracionPorPromedioDeGol(miJugador);
		Double valorGolesRecibidos = servicioGol.valoracionPorPromedioDeGolesEnContra(miJugador);
		Double valorPorPorteriaImbatible = servicioGol.valoracionPorteriaImbatible(miJugador);
		Double valorPorAmonestaciones = servicioAmonestacion.valoracionPorAmonestaciones(miJugador);
		Double valorPorExpulsiones = servicioExpulsion.valoracionPorExpulsiones(miJugador);
		
		valoracion = valorEdad + valorAltura + valorPesoAltura + valorGolesRecibidos + valorPorPorteriaImbatible + valorPromedioDeGol
				+ valorPorAmonestaciones + valorPorExpulsiones;
		
		}else if(miJugador.getClass() == JugadorDeCampo.class) {
			
			Double valorEdad = this.valoracionPorEdad(miJugador);
			Double valorPromedioDeGol = servicioGol.valoracionPorPromedioDeGol(miJugador);
			Double valorAltura = this.valoracionPorAltura(miJugador);
			Double valorAlturaPeso = this.valoracionPorAlturaYPeso(miJugador);
			Double valorPorAmonestaciones = servicioAmonestacion.valoracionPorAmonestaciones(miJugador);
			Double valorPorExpulsiones = servicioExpulsion.valoracionPorExpulsiones(miJugador);
			
			valoracion= valorEdad + valorPromedioDeGol + valorAltura + valorAlturaPeso + valorPorAmonestaciones + valorPorExpulsiones;
		}*/

		
		/* Valoracion desde el servico valoracion tabla */
		Double valorEdad = servicioValoracion.valoracionPorEdad(miJugador);
		Double valorAltura = servicioValoracion.valoracionPorAltura(miJugador);
		Double valorPesoAltura = servicioValoracion.valoracionPorAlturaYPeso(miJugador);
		Double valorPromedioGol = servicioGol.valoracionPorPromedioDeGol(miJugador);
		Double valorPorAmonestaciones = servicioAmonestacion.valoracionPorAmonestaciones(miJugador);
		Double valorPorExpulsiones = servicioExpulsion.valoracionPorExpulsiones(miJugador);
		if(miJugador.getPosicion().equals("Arquero")){
			Double valorPorGolesEnContra = servicioGol.valoracionPorPromedioDeGolesEnContra(miJugador);
			valoracion = valorPesoAltura + valorAltura + valorEdad + valorPromedioGol + valorPorAmonestaciones + valorPorExpulsiones + valorPorGolesEnContra;
		}else {
			valoracion = valorPesoAltura + valorAltura + valorEdad + valorPromedioGol + valorPorAmonestaciones + valorPorExpulsiones;
		}
		return valoracion;
	}

	@Override
	public List<Jugador> listarJugadoresPorEquipo(Long idEquipo) {
		return servicioJugadorDao.listaDeJugadoresPorEquipo(idEquipo);
	}

	@Override
	public void agregarJugador(Jugador jugador) {
		servicioJugadorDao.agregarJugador(jugador);
		
	}

	@Override
	public Jugador buscarJugadorID(Long id) {
		return servicioJugadorDao.buscarJugador(id);
	}

	@Override
	public void editarJugador(Jugador jugador) {
		servicioJugadorDao.editarJugador(jugador);
		
	}

	@Override
	public void eliminarJugador(Jugador jugador) {
		servicioJugadorDao.eliminarJugador(jugador);
		
	}
	
}