package ar.edu.unlam.tallerweb1.controladores;

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

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;

@Controller
public class ControladorJugador {
	
	@Inject 
	private ServicioJugador servicioJugador;

	@RequestMapping("/jugadores")
	public ModelAndView mostrarJugadores() {
		ModelMap modelo = new ModelMap();

		List <Jugador> miLista = servicioJugador.listarJugadores();
		for(Jugador e : miLista) {
			e.setValoracion(servicioJugador.valoracionJugador(e.getId()));
			
		}
		
		modelo.put("lista", miLista);
		return new ModelAndView("jugadores", modelo);
	}
	
	@RequestMapping("/valoracion/{id}")
	public ModelAndView mostrarvaloracion (@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("valoracion", modelo);
	}
	
	@RequestMapping(path = "/modificarJugador", method = RequestMethod.POST)
	public ModelAndView editarJugador(@ModelAttribute("jugador") Jugador jugador, HttpServletRequest request) {
		Jugador jugadorBuscado = servicioJugador.buscarJugadorID(jugador.getId());
		ModelMap modelo = new ModelMap();
		modelo.put("jugador", jugadorBuscado);
		
		return new ModelAndView("editarJugador", modelo);
	}
	
	@RequestMapping(path = "/editarJugador", method = RequestMethod.POST)
	public ModelAndView jugadorEditado(@ModelAttribute("jugador")Jugador jugador, HttpServletRequest request) {
		Jugador jugadorBuscado = servicioJugador.buscarJugadorID(jugador.getId());
		jugadorBuscado.setNombre(jugador.getNombre());
		jugadorBuscado.setEdad(jugador.getEdad());
		jugadorBuscado.setPeso(jugador.getPeso());
		jugadorBuscado.setAltura(jugador.getAltura());
		servicioJugador.editarJugador(jugadorBuscado);
		return new ModelAndView("redirect:/miEquipo");
	}
	@RequestMapping(path = "/eliminarJugador", method = RequestMethod.POST)
	public ModelAndView borrarJugador(@ModelAttribute("jugador") Jugador jugador, HttpServletRequest request) {
		Jugador jugadorBuscado = servicioJugador.buscarJugadorID(jugador.getId());
		servicioJugador.eliminarJugador(jugadorBuscado);
		return new ModelAndView("redirect:/miEquipo");
	}
}