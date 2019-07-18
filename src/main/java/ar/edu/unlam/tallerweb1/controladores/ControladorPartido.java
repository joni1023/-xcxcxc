package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPartido {
	@Inject
	private ServicioPartido servicioPartido;
	@Inject
	private ServicioEquipo servicioEquipo;
	@Inject
	private ServicioLogin servicioLogin;
	
	
	
	
	@RequestMapping(path ="/armandoPartido", method = RequestMethod.POST)
	public ModelAndView armarPartido(Long equipo1ID,Long equipo2ID) {
		ModelMap modelo= new ModelMap();
		modelo.put("equipo1", servicioEquipo.buscarEquipo(equipo1ID));
		modelo.put("equipo2", servicioEquipo.buscarEquipo(equipo2ID));
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
		return new ModelAndView("redirect:/misPartidos");
	}
	@RequestMapping("misPartidos")
	public ModelAndView misPartidos(HttpServletRequest request) {
		ModelMap modelo=new ModelMap();
		Usuario usuario=servicioLogin.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		Equipo equipo1 = servicioEquipo.buscarEquipo(usuario.getEquipo().getId());
		modelo.put("local",equipo1);
		List <Partido> misPartidos = servicioPartido.listaDePartidosEquipoID(equipo1.getId());
		modelo.put("misPartidos", misPartidos);
		return new ModelAndView("misPartidos",modelo);
	}

}
