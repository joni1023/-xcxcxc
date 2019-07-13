package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

@Controller
public class ControladorPartido {
	@Inject
	private ServicioPartido servicioPartido;
	@Inject
	private ServicioEquipo servicioEquipo;
	
	
	
	
	@RequestMapping(path ="/armandoPartido", method = RequestMethod.POST)
	public ModelAndView armarPartido(Long equipo1ID,Long equipo2ID) {
		ModelMap modelo= new ModelMap();
//		Equipo equipo1=servicioEquipo.buscarEquipo(equipo1ID);
//		Equipo equipo2=servicioEquipo.buscarEquipo(equipo2ID);
//		modelo.put("equipo1", equipo1);
//		modelo.put("equipo2", equipo2);
		modelo.put("equipo1ID", equipo1ID);
		modelo.put("equipo2ID", equipo2ID);
		Partido partido=new Partido();
		modelo.put("partido", partido);
		return new ModelAndView("armandoPartido",modelo);
	}
	
	@RequestMapping(path="/crearPartido",method=RequestMethod.POST)
	public ModelAndView partidoCreado(Long equipo1ID,Long equipo2ID,Date fecha) {
		Partido partido=new Partido();
		Equipo equipo1=servicioEquipo.buscarEquipo(equipo1ID);
		Equipo equipo2=servicioEquipo.buscarEquipo(equipo2ID);
		partido.setLocal(equipo1);
		partido.setVisitante(equipo2);

		servicioPartido.crearPartido(partido);
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("misPartidos")
	public ModelAndView misPartidos() {
		ModelMap modelo=new ModelMap();
		Equipo equipo1 = servicioEquipo.buscarEquipo(1L);
		modelo.put("local",equipo1);
		return new ModelAndView("misPartidos",modelo);
	}

}
