package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;

@Controller
public class ControladorEquipo {
	@Inject
	private ServicioEquipo servicioEquipo;
	
//	@RequestMapping("/valoracionEquipo")
//	public ModelAndView mostrarEquiposYValoracion() {
//		List<Equipo>listaEquipos = 
//	}
}
