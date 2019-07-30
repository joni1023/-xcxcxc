package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("ServicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo{
	@Inject
	TorneoDao torneoDao;
	
	@Inject
	EquipoDao equipoDao;
	
	@Override
	public void agregarEquipo(Equipo equipo) {
		torneoDao.agregarEquipo(equipo);
	}

	@Override
	public void crearTorneo(List<Equipo> listaDeEquipos) {
		
	}
	@Override
	public void agregarTorneo(Torneo torneo) {
		torneoDao.agregarTorneo(torneo);
	}
	
	@Override
	public List<Torneo> listarTorneos() {
		return torneoDao.listarTorneos();
	}
	@Override
	public Torneo listarTorneoId(Long id) {
		return torneoDao.listarTorneoId(id);
	}
	
}
