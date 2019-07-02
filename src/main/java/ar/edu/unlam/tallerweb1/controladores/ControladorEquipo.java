package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;

@Controller
public class ControladorEquipo {
	@Inject
	private ServicioEquipo servicioEquipo;
	
//	@RequestMapping("/valoracionEquipo")
//	public ModelAndView mostrarEquiposYValoracion() {
//		List<Equipo>listaEquipos = 
//	}
	@RequestMapping("/valoracionEquipo")
	public ModelAndView mostrarEquiposYValoracion() {
		ModelMap modelo=new ModelMap();
		List<Equipo>listaEquipos = servicioEquipo.listarEquipos();
		Double valoracion;
		for(Equipo e: listaEquipos) {
			valoracion=servicioEquipo.valoracionEquipo(e.getId());
			e.setValoracion(valoracion);
		}
		
		modelo.put("equipos", listaEquipos);
		return new ModelAndView("valoracionEquipo",modelo);
	}
	
	@RequestMapping("/buscandoRival")
	public ModelAndView mostrarEquipoRival() {
		ModelMap modelo=new ModelMap();
		Equipo miEquipo=new Equipo();
		miEquipo.setId(1l);
		miEquipo.setValoracion(servicioEquipo.valoracionEquipo(miEquipo.getId()));
		Equipo rival=servicioEquipo.dandoRival(miEquipo);
		modelo.put("rival", rival);
		modelo.put("miEquipo", miEquipo);
		
		return new ModelAndView("buscandoRival",modelo);
	}
	
}
