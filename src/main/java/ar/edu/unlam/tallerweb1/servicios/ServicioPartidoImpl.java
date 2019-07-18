package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Partido;
@Service("ServicioPartido")
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {
	@Inject
	private PartidoDao partidoDao;

	@Override
	public List<Partido> listaDePartidos() {		
		return partidoDao.listaDePartidos();
	}

	@Override
	public void crearPartido(Partido partido) {
		partidoDao.crearPartido(partido);

	}

	@Override
	public void elmiminarPartido(Partido partido) {
		partidoDao.elmiminarPartido(partido);

	}

	@Override
	public void modificarpertido(Partido partido) {
		partidoDao.modificarpertido(partido);

	}

	@Override
	public List<Partido> listaDePartidosEquipoID(long id) {
		
		List <Partido> miLista = this.listaDePartidos();
		List <Partido> miListanueva = new ArrayList <Partido> ();
		for (Partido e:miLista) {
			if(e.getLocal().getId()==id) {
				miListanueva.add(e);
			}else if(e.getVisitante().getId()==id) {
				miListanueva.add(e);
			}
		}
		return miListanueva;
	}
	
}
