package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("ServicioEquipo")
@Transactional
public class ServicioEquipoImpl implements ServicioEquipo{
	
	@Inject
	private EquipoDao equipoDao;
	
	@Inject
	private ServicioJugador servicioJugador;
	
	@Override
	public Double valoracionEquipo(Long id) {
		Double valoracion = 0.0;
		Equipo miEquipo = equipoDao.buscarEquipo(id);
		List<Jugador> misJugadores = miEquipo.getListaDeJugadores();
		for(Jugador jugador : misJugadores) {
			valoracion += servicioJugador.valoracionJugador(jugador.getId());
		}
		
		return valoracion/5;
	}
	
	@Override
	public List<Equipo> listarEquipos() {
		return equipoDao.listarEquipos();
	}
	
	@Override
    public Equipo buscarEquipo(Long id) {
        return equipoDao.buscarEquipo(id);
    }
	
	@Override
    public void agregarEquipo(Equipo equipo) {
		equipoDao.agregarEquipo(equipo);
    }
	
	@Override
    public void editarEquipo(Equipo equipo) {
		equipoDao.editarEquipo(equipo);
    }
	
	@Override
	public void eliminarEquipo(Long id) {
		equipoDao.eliminarEquipo(id);
	}
}