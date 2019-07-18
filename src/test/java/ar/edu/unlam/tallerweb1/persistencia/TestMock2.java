package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.edu.unlam.tallerweb1.controladores.ControladorEquipo;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioGol;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugadorImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class TestMock2 {

	@Test
	public void testQueCreaUnEquipo() {
		ServicioEquipo servicioEquipoMock = mock(ServicioEquipo.class);
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		Equipo equipoMock = mock(Equipo.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		Usuario usuarioMock = mock(Usuario.class);
		ControladorEquipo controlador = new ControladorEquipo();
		controlador.setServicioEquipo(servicioEquipoMock);
		controlador.setServicioLogin(servicioLoginMock);
		
		when(servicioEquipoMock.buscarEquipoNombre(anyString())).thenReturn(null);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLoginMock.consultarUsuarioId((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(usuarioMock);
		
		ModelAndView modelAndView = controlador.crearEquipo2(equipoMock, requestMock);
		assertThat(modelAndView.getViewName()).isEqualTo("crearEquipo2");
		assertThat(modelAndView.getModel()).isEmpty();
	}
	@Test
	public void testQueNoCreaUnEquipo() {
		ServicioEquipo servicioEquipoMock = mock(ServicioEquipo.class);
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		Equipo equipoMock = mock(Equipo.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		Usuario usuarioMock = mock(Usuario.class);
		ControladorEquipo controlador = new ControladorEquipo();
		controlador.setServicioEquipo(servicioEquipoMock);
		controlador.setServicioLogin(servicioLoginMock);
		
		when(servicioEquipoMock.buscarEquipoNombre(anyString())).thenReturn(equipoMock);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLoginMock.consultarUsuarioId((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(usuarioMock);
		
		ModelAndView modelAndView = controlador.crearEquipo2(equipoMock, requestMock);
		assertThat(modelAndView.getViewName()).isEqualTo("crearEquipo");
		assertThat(modelAndView.getModelMap().get("error")).isEqualTo("El nombre del equipo ya esta en uso");
	}
	
	@Test
	public void testQueCaluclaGolesDeUnJugador() {
		/*ServicioGol servicioGolMock = mock(ServicioGol.class);
		List <Gol> listaGolesMock = mock (List.class);
		Gol golMocl = mock(Gol.class);
		listaGolesMock.add(golMock);
		Jugador jugadorMock = mock(Jugador.class);		
		
		ServicioJugadorImpl servicioJugador = new ServicioJugadorImpl();		
		servicioJugador.setServicioGol(servicioGolMock);
		
		when(servicioGolMock.golesJugador(jugadorMock)).thenReturn(listaGolesMock);
		when(golMock.getCantidad()).thenReturn(1);
		Integer goles = servicioJugador.goles(jugadorMock);
		
		assertThat(goles).isEqualTo(1);*/
	}

}
