package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

@Controller
public class ControladorEstadisticas {
	@Inject
	ServicioLogin servicioLogin;
	@Inject
	ServicioEquipo servicioEquipo;
	@Inject
	ServicioPartido servicioPartido;
	@Inject
	ServicioJugador servicioJugador;
	
	@RequestMapping(path="/estadisticas")
	public ModelAndView estadisticasEquipo(HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		Boolean tieneEquipo = false;
		if(usuarioBuscado.getEquipo() != null) {
			tieneEquipo = true;
		}
		
		List<Equipo> equipos = servicioEquipo.listarEquipos();
		for (Equipo equipo : equipos) {
			equipo.setPartidosJugados(servicioPartido.partidosJugados(equipo.getId()));
			equipo.setPartidosGanados(servicioPartido.partidosGanados(equipo.getId()));
			equipo.setPartidosEmpatados(servicioPartido.partidosEmpatados(equipo.getId()));
			equipo.setPartidosPerdidos(servicioPartido.partidosPerdidos(equipo.getId()));
			equipo.setValoracion(servicioEquipo.valoracionEquipo(equipo.getId()));
		}
		ModelMap modelo = new ModelMap();
		modelo.put("esAdmin",usuarioBuscado.getEsAdmin());
		modelo.put("tieneEquipo", tieneEquipo);
		modelo.put("equipos",equipos);
		
		return new ModelAndView("estadisticas" , modelo);
	}
	
	@RequestMapping(path = "/estadisticasJugadores")
	public ModelAndView estadisticasJugadores(Long idEquipo, HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		Boolean tieneEquipo = false;
		if(usuarioBuscado.getEquipo() != null) {
			tieneEquipo = true;
		}
		Equipo equipoBuscado = servicioEquipo.buscarEquipo(idEquipo);
		List<Jugador> jugadores = servicioJugador.listarJugadoresPorEquipo(idEquipo);
		for (Jugador jugador : jugadores) {
			jugador.setCantidadGoles(servicioJugador.goles(jugador));
			jugador.setCantidadAmonestaciones(servicioJugador.amonestaciones(jugador));
			jugador.setCantidadExpulsiones(servicioJugador.expulsiones(jugador));
			jugador.setValoracion(servicioJugador.valoracionJugador(jugador.getId()));
		}
		ModelMap modelo = new ModelMap();
		modelo.put("esAdmin",usuarioBuscado.getEsAdmin());
		modelo.put("tieneEquipo", tieneEquipo);
		modelo.put("jugadores",jugadores);
		modelo.put("equipo", equipoBuscado);
		
		return new ModelAndView("estadisticasJugadores" , modelo);
	}
}
