package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorEquipo;
import ar.edu.unlam.tallerweb1.dao.AmonestacionDao;
import ar.edu.unlam.tallerweb1.dao.AmonestacionDaoImpl;
import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmonestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmonestacionImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;

import static org.mockito.Mockito.*;

import java.util.List;

import javax.management.modelmbean.ModelMBeanOperationInfo;

public class TestMock {

	@Test
	@Transactional
	@Rollback (true)
	public void TestQueNoRepiteRival() {
		ServicioEquipo servicioEquipoMock = mock(ServicioEquipo.class);
		ServicioJugador servicioJugadorMock = mock(ServicioJugador.class);
		Long id1 = null;
		Long id2 = 1L;
		Equipo miEquipoMock = mock(Equipo.class);
		Equipo miEquipoRivalMock = mock(Equipo.class);
		Double valoracion = null;
		List <Jugador> listaJugadorMock = mock (List.class);
		
		ControladorEquipo controladorEquipo = new ControladorEquipo();
		controladorEquipo.setServicioEquipo(servicioEquipoMock);
		controladorEquipo.setServicioJugador(servicioJugadorMock);
		
		when(servicioEquipoMock.buscarEquipo(id1)).thenReturn(miEquipoMock);
		
		when(servicioEquipoMock.valoracionEquipo(miEquipoMock.getId())).thenReturn(valoracion);
		
		when(servicioEquipoMock.dandoRival(miEquipoMock, miEquipoRivalMock.getId())).thenReturn(null);
		
		when(servicioJugadorMock.listarJugadoresPorEquipo(miEquipoMock.getId())).thenReturn(listaJugadorMock);
		
		ModelAndView modelo=controladorEquipo.buscarEquipoRivalPost(id1,id2);
		
		assertThat(modelo.getModelMap().get("miEquipo")).isEqualTo(miEquipoMock);
		
		assertThat(modelo.getViewName()).isEqualTo("buscandoRival");
		
		assertThat(modelo.getModelMap().get("jugadores1")).isEqualTo(listaJugadorMock);
		
		assertThat(modelo.getModelMap().get("miRival")).isEqualTo(null);
		
		assertThat(modelo.getModelMap().get("jugadores2")).isEqualTo(null);
	}
	
	@Test
	@Transactional
	@Rollback (true)
	public void TestCantidadAmonestaciones() {
		
		/*Long id=null;
		
		Jugador miJugadorMock = mock(Jugador.class);
		
		AmonestacionDao amonestacionDao = new AmonestacionDaoImpl();
		
		List <Amonestacion> listaAmonestacionMock= mock (List.class);
		
		ServicioAmonestacionImpl amonestacionmock=new ServicioAmonestacionImpl();
		amon.setAmonestacionDao(amonestacionDao);
		
		when(amonestacionDao.amonestacionesJugador(miJugadorMock)).thenReturn(listaAmonestacionMock);
			
		assertThat(amonestacionmock.cantidadAmonestaciones(miJugadorMock.getId()).isEqualTo("0.0");
		Assert.assertEquals(amonestacionmock.cantidadAmonestaciones(miJugadorMock.getId()));*/
	}
}