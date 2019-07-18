package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Amonestacion;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Expulsion;
import ar.edu.unlam.tallerweb1.modelo.Gol;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmonestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioExpulsion;
import ar.edu.unlam.tallerweb1.servicios.ServicioGol;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

@Controller
public class ControladorPartido {
	
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioPartido servicioPartido;
	@Inject
	private ServicioEquipo servicioEquipo;
	@Inject
	private ServicioGol servicioGol;
	@Inject
	private ServicioAmonestacion servicioAmonestacion;
	@Inject
	private ServicioExpulsion servicioExpulsion;
	@Inject
	private ServicioJugador servicioJugador;
	
	@RequestMapping(path = "/armandoPartido", method = RequestMethod.POST)
	public ModelAndView armarPartido(Long local, Long visitante, HttpServletRequest request) {
		Equipo EquipoLocal = servicioEquipo.buscarEquipo(local);
		Equipo EquipoVisitante = servicioEquipo.buscarEquipo(visitante);
		Partido partido = new Partido();
		partido.setLocal(EquipoLocal);
		partido.setVisitante(EquipoVisitante);
		partido.setDatosCargados(false);
		servicioPartido.crearPartido(partido);
		return new ModelAndView("redirect:/misPartidos");
	}

	@RequestMapping("misPartidos")
	public ModelAndView misPartidos(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuario = servicioLogin.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		Equipo equipo1 = servicioEquipo.buscarEquipo(usuario.getEquipo().getId());
		modelo.put("local", equipo1);
		List <Partido> misPartidos = servicioPartido.listaDePartidosEquipoID(equipo1.getId());
		for (Partido partido : misPartidos) {
			partido.setGolesLocal(servicioPartido.golesLocal(partido.getId()));
			partido.setGolesVisitante(servicioPartido.golesVisitante(partido.getId()));
		}
		modelo.put("misPartidos", misPartidos);
		return new ModelAndView("misPartidos", modelo);
	}

	@RequestMapping(path = "/cargarPartidos", method = RequestMethod.GET)
	public ModelAndView mostrarPartidos() {
		ModelMap modelo = new ModelMap();
		List<Partido> partidosACargar = servicioPartido.listaDePartidosSinCargar();
		modelo.put("partidos", partidosACargar);

		return new ModelAndView("cargarPartidos", modelo);
	}

	@RequestMapping(path = "/datosPartido", method = RequestMethod.POST)
	public ModelAndView completarPartidos(Long idPartido, HttpServletRequest request) {
		Partido partidoBuscado = servicioPartido.buscarPartido(idPartido);
		List<Jugador> jugadoresLocal = servicioPartido.listaDeJugadoresLocal(partidoBuscado);
		ModelMap modelo = new ModelMap();
		modelo.put("partido", partidoBuscado);
		modelo.put("jugadores", jugadoresLocal);
		return new ModelAndView("datosPartido", modelo);
	}

	@RequestMapping(path = "/datosPartido2", method = RequestMethod.POST)
	public ModelAndView guardarDatos(Long partidoId, String datos, Long jugador1Id, Long jugador2Id, Long jugador3Id,
			Long jugador4Id, Long jugador5Id, Integer gol1Cantidad, Integer gol2Cantidad, Integer gol3Cantidad,
			Integer gol4Cantidad, Integer gol5Cantidad, Integer amonestacion1Cantidad, Integer amonestacion2Cantidad,
			Integer amonestacion3Cantidad, Integer amonestacion4Cantidad, Integer amonestacion5Cantidad,
			Integer expulsion1Cantidad, Integer expulsion2Cantidad, Integer expulsion3Cantidad,
			Integer expulsion4Cantidad, Integer expulsion5Cantidad, HttpServletRequest request) {

		Partido partidoBuscado = servicioPartido.buscarPartido(partidoId);
		Jugador jugador1 = servicioJugador.buscarJugadorID(jugador1Id);
		Jugador jugador2 = servicioJugador.buscarJugadorID(jugador2Id);
		Jugador jugador3 = servicioJugador.buscarJugadorID(jugador3Id);
		Jugador jugador4 = servicioJugador.buscarJugadorID(jugador4Id);
		Jugador jugador5 = servicioJugador.buscarJugadorID(jugador5Id);
		
		Gol gol1 = new Gol(gol1Cantidad, partidoBuscado, jugador1);
		Gol gol2 = new Gol(gol2Cantidad, partidoBuscado, jugador2);
		Gol gol3 = new Gol(gol3Cantidad, partidoBuscado, jugador3);
		Gol gol4 = new Gol(gol4Cantidad, partidoBuscado, jugador4);
		Gol gol5 = new Gol(gol5Cantidad, partidoBuscado, jugador5);

		servicioGol.guardarGol(gol1);
		servicioGol.guardarGol(gol2);
		servicioGol.guardarGol(gol3);
		servicioGol.guardarGol(gol4);
		servicioGol.guardarGol(gol5);

		if (amonestacion1Cantidad != 0) {
			Amonestacion amonestacion1 = new Amonestacion(amonestacion1Cantidad, jugador1, partidoBuscado);
			servicioAmonestacion.guardarAmonestacion(amonestacion1);
		}
		if (amonestacion2Cantidad != 0) {
			Amonestacion amonestacion2 = new Amonestacion(amonestacion2Cantidad, jugador2, partidoBuscado);
			servicioAmonestacion.guardarAmonestacion(amonestacion2);
		}
		if (amonestacion3Cantidad != 0) {
			Amonestacion amonestacion3 = new Amonestacion(amonestacion3Cantidad, jugador3, partidoBuscado);
			servicioAmonestacion.guardarAmonestacion(amonestacion3);
		}
		if (amonestacion4Cantidad != 0) {
			Amonestacion amonestacion4 = new Amonestacion(amonestacion4Cantidad, jugador4, partidoBuscado);
			servicioAmonestacion.guardarAmonestacion(amonestacion4);
		}
		if (amonestacion5Cantidad != 0) {
			Amonestacion amonestacion5 = new Amonestacion(amonestacion5Cantidad, jugador5, partidoBuscado);
			servicioAmonestacion.guardarAmonestacion(amonestacion5);
		}

		if (expulsion1Cantidad == 1) {
			Expulsion expulsion1 = new Expulsion(jugador1, partidoBuscado);
			servicioExpulsion.guardarExpulsion(expulsion1);
		}
		if (expulsion2Cantidad == 1) {
			Expulsion expulsion2 = new Expulsion(jugador2, partidoBuscado);
			servicioExpulsion.guardarExpulsion(expulsion2);
		}
		if (expulsion3Cantidad == 1) {
			Expulsion expulsion3 = new Expulsion(jugador3, partidoBuscado);
			servicioExpulsion.guardarExpulsion(expulsion3);
		}
		if (expulsion4Cantidad == 1) {
			Expulsion expulsion4 = new Expulsion(jugador4, partidoBuscado);
			servicioExpulsion.guardarExpulsion(expulsion4);
		}
		if (expulsion5Cantidad == 1) {
			Expulsion expulsion5 = new Expulsion(jugador5, partidoBuscado);
			servicioExpulsion.guardarExpulsion(expulsion5);
		}
		if (datos.equals("local")) {
			ModelMap modelo = new ModelMap();
			List<Jugador> listaJugadoresVisitante = servicioPartido.listaDeJugadoresVisitante(partidoBuscado);
			modelo.put("partido", partidoBuscado);
			modelo.put("jugadores", listaJugadoresVisitante);
			return new ModelAndView("datosPartidoVisitante", modelo);
		} else if (datos.equals("visitante")) {
			partidoBuscado.setDatosCargados(true);
			servicioPartido.modificarPartido(partidoBuscado);
			return new ModelAndView("redirect:/cargarPartidos");
		} else {
			return new ModelAndView("redirect:/homeAdmin");
		}
	}
}