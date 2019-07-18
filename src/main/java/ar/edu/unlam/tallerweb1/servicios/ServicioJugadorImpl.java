package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Gol;
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
		} else {
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

	@Override
	public Integer goles(Jugador jugador) {
		List<Gol> goles = servicioGol.golesJugador(jugador);
		Integer cantidadGoles = 0;
		
		for (Gol gol : goles) {
			cantidadGoles += gol.getCantidad();
		}
		return cantidadGoles;
	}

	@Override
	public Integer amonestaciones(Jugador jugador) {
		List<Amonestacion> amonestaciones = servicioAmonestacion.amonestacionesJugador(jugador);
		Integer cantidadAmonestaciones = 0;
		for (Amonestacion amonestacion : amonestaciones) {
			cantidadAmonestaciones += amonestacion.getCantidad();
		}
		return cantidadAmonestaciones;
	}

	@Override
	public Integer expulsiones(Jugador jugador) {
		Integer expulsiones = servicioExpulsion.cantidadExpulsiones(jugador.getId());
		return expulsiones;
	}
	
	//TEST
	public ServicioGol getServicioGol() {
		return this.servicioGol;
	}
	
	public void setServicioGol(ServicioGol servicioGol) {
		this.servicioGol = servicioGol;
	}
}