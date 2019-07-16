package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorEquipo {

	@Inject
	private ServicioEquipo servicioEquipo;

	@Inject
	private ServicioJugador servicioJugador;

	@Inject
	private ServicioLogin servicioLogin;

	// @RequestMapping("/valoracionEquipo")
	// public ModelAndView mostrarEquiposYValoracion() {
	// List<Equipo>listaEquipos =
	// }

	@RequestMapping("/valoracionEquipo")
	public ModelAndView mostrarEquiposYValoracion() {
		ModelMap modelo = new ModelMap();
		List<Equipo> listaEquipos = servicioEquipo.listarEquipos();
		Double valoracion;
		for (Equipo e : listaEquipos) {
			valoracion = servicioEquipo.valoracionEquipo(e.getId());
			e.setValoracion(valoracion);
		}

		modelo.put("equipos", listaEquipos);
		return new ModelAndView("valoracionEquipo", modelo);
	}

	@RequestMapping(path = "/crearEquipo", method = RequestMethod.GET)
	public ModelAndView crearEquipo() {
		ModelMap modelo = new ModelMap();
		Equipo equipo = new Equipo();
		modelo.put("equipo", equipo);
		return new ModelAndView("crearEquipo", modelo);
	}

	@RequestMapping(path = "/registrarEquipo", method = RequestMethod.POST)
	public ModelAndView crearEquipo2(@ModelAttribute("equipo") Equipo equipo, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if (servicioEquipo.buscarEquipoNombre(equipo.getNombre()) == null) {
			List<Jugador> listaDeJugadores = new ArrayList<>();
			equipo.setListaDeJugadores(listaDeJugadores);
			Usuario usuarioBuscado = servicioLogin
					.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
			equipo.setUsuario(usuarioBuscado);
			servicioEquipo.agregarEquipo(equipo);
			usuarioBuscado.setEquipo(equipo);
			servicioLogin.editarUsuario(usuarioBuscado);
			return new ModelAndView("crearEquipo2");
		} else {
			modelo.put("error", "El nombre del equipo ya esta en uso");
			return new ModelAndView("crearEquipo", modelo);
		}
	}

	@RequestMapping(path = "/crearEquipo2", method = RequestMethod.GET)
	public ModelAndView registrarJugadores() {
		Jugador jugador = new Jugador();
		ModelMap modelo = new ModelMap();
		modelo.put("jugador", jugador);
		return new ModelAndView("crearEquipo2", modelo);
	}

	@RequestMapping(path = "/registrarJugadores", method = RequestMethod.POST)
	public ModelAndView agregarJugadores(@ModelAttribute("jugador") Jugador jugador, HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin
				.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		Equipo equipo = usuarioBuscado.getEquipo();
		List<Jugador>listaDeJugadores = servicioJugador.listarJugadoresPorEquipo(equipo.getId());
		
		if(listaDeJugadores.size()<5 && listaDeJugadores.size() !=4) {
			jugador.setEquipo(equipo);
			servicioJugador.agregarJugador(jugador);
			return new ModelAndView("crearEquipo2");
		}else if(listaDeJugadores.size() == 4) {
			jugador.setEquipo(equipo);
			servicioJugador.agregarJugador(jugador);
			return new ModelAndView("redirect:/home");
		}else {
			return new ModelAndView("redirect:/home");
		}
	}

	@RequestMapping("/buscandoRival")
	public ModelAndView mostrarEquipoRival() {

		ModelMap modelo = new ModelMap();
		Equipo miEquipo = servicioEquipo.buscarEquipo(1l);
		Equipo equipo = new Equipo();
		modelo.put("equipo", equipo);
		modelo.put("miEquipo", miEquipo);

		return new ModelAndView("buscandoRival", modelo);
	}

	@RequestMapping(path = "/buscandoRival", method = RequestMethod.POST)
	public ModelAndView buscarEquipoRivalPost(@ModelAttribute("equipo") Equipo eequipo) {
		ModelMap modelo = new ModelMap();
		Equipo miEquipo = servicioEquipo.buscarEquipo(eequipo.getId());
		miEquipo.setValoracion(servicioEquipo.valoracionEquipo(miEquipo.getId()));
		Equipo rival = servicioEquipo.dandoRival(miEquipo);
		Equipo equipo = new Equipo();
		modelo.put("equipo", equipo);
		modelo.put("rival", rival);
		modelo.put("miEquipo", miEquipo);
		modelo.put("jugadores1", servicioJugador.listarJugadoresPorEquipo(eequipo.getId()));
		if (rival != null) {
			modelo.put("jugadores2", servicioJugador.listarJugadoresPorEquipo(rival.getId()));
		}

		return new ModelAndView("buscandoRival", modelo);
	}

	@RequestMapping(value = "/equipos", method = RequestMethod.GET)
	public String listarEquipos() {
		ModelMap modelo = new ModelMap();
		modelo.addAttribute("equipo", new Equipo());
		modelo.addAttribute("listaDeEquipos", servicioEquipo.listarEquipos());
		return "equipo";
	}

	@RequestMapping(value = "/agregarEquipo", method = RequestMethod.POST)
	public String agregarEquipo(@ModelAttribute("Equipo") Equipo equipo) {

		if (equipo.getId() == null || equipo.getId() == 0) {
			servicioEquipo.agregarEquipo(equipo);
		} else {
			servicioEquipo.editarEquipo(equipo);
		}

		return "equipos";
	}
	@RequestMapping(path = "/miEquipo" , method = RequestMethod.GET)
	public ModelAndView mostrarMiEquipo(HttpServletRequest request){
		Usuario usuarioBuscado = servicioLogin.consultarUsuarioId((Long)request.getSession().getAttribute("idUsuario"));
		Equipo miEquipo = usuarioBuscado.getEquipo();
		List<Jugador> listaDeJugadores = servicioJugador.listarJugadoresPorEquipo(miEquipo.getId());
		ModelMap modelo = new ModelMap();
		modelo.put("miEquipo", miEquipo);
		modelo.put("jugadores", listaDeJugadores);
		modelo.put("cantidadJugadores", listaDeJugadores.size());
		return new ModelAndView("miEquipo" , modelo);
		}
	
	@RequestMapping("/editarEquipo/{id}")
	public String editarEquipo(@PathVariable("id") Long id) {
		ModelMap modelo = new ModelMap();
		modelo.addAttribute("equipo", servicioEquipo.buscarEquipo(id));
		modelo.addAttribute("listaDeEquipos", servicioEquipo.listarEquipos());
		return "equipo";
	}

	@RequestMapping("/eliminarEquipo/{id}")
	public String eliminarEquipo(@PathVariable("id") Long id) {

		servicioEquipo.eliminarEquipo(id);
		return "equipo";
	}
}