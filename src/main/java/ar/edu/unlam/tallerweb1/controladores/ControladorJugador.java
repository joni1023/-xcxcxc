package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		for(Jugador e:miLista) {
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
}