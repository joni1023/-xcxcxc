package ar.edu.unlam.tallerweb1.controladores;

import java.util.Collections;
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
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioJugador;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTorneo {
	@Inject
	ServicioLogin servicioLogin;
	
	@Inject
	ServicioEquipo servicioEquipo;
	
	@Inject
	ServicioPartido servicioPartido;
	
	@Inject
	ServicioJugador servicioJugador;
	
	@Inject
	ServicioTorneo servicioTorneo;
	
	@RequestMapping(path = "/crearTorneo", method = RequestMethod.GET)
	public ModelAndView crearTorneo() {
		ModelMap modelo = new ModelMap();
		Torneo torneo = new Torneo();
		modelo.put("torneo", torneo);
		modelo.put("torneoID",torneo.getId());
		return new ModelAndView("crearTorneo", modelo);
	}
	
	@RequestMapping(path = "/registrarTorneo", method = RequestMethod.POST)
	public ModelAndView registrarTorneo(@ModelAttribute("torneo") Torneo torneo, HttpServletRequest request) {
		servicioTorneo.agregarTorneo(torneo);
		ModelMap modelo = new ModelMap();
		modelo.put("torneoID", torneo.getId());
		return new ModelAndView("redirect:/crearTorneo2");
	}
	
	@RequestMapping(path = "/torneos")
	public ModelAndView irATorneos() {
		ModelMap modelo = new ModelMap();
		List<Torneo> listaTorneos = servicioTorneo.listarTorneos();
		modelo.put("listaTorneos",listaTorneos);
		return new ModelAndView("torneos",modelo);
	}
	
	
	
	@RequestMapping(path = "/crearTorneo2", method = RequestMethod.GET)
	public ModelAndView estadisticasEquipo(HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.consultarUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
		
		
		List<Equipo> equipos = servicioEquipo.listarEquipos();
		for (Equipo equipo : equipos) {
			equipo.setPartidosJugados(servicioPartido.partidosJugados(equipo.getId()));
			equipo.setPartidosGanados(servicioPartido.partidosGanados(equipo.getId()));
			equipo.setPartidosEmpatados(servicioPartido.partidosEmpatados(equipo.getId()));
			equipo.setPartidosPerdidos(servicioPartido.partidosPerdidos(equipo.getId()));
			equipo.setValoracion(servicioEquipo.valoracionEquipo(equipo.getId()));
		}
		Collections.sort(equipos);
		ModelMap modelo = new ModelMap();
		modelo.put("esAdmin", usuarioBuscado.getEsAdmin());
		modelo.put("equipos", equipos);
		
		return new ModelAndView("crearTorneo2", modelo);
	}
	
	@RequestMapping(path = "/crearTorneo2", method = RequestMethod.POST)
	public ModelAndView buscarEquipoRivalPost(Long id1,Long id2,Long torneoID) {
		ModelMap modelo = new ModelMap();
		Equipo miEquipo = servicioEquipo.buscarEquipo(id1);
		miEquipo.setValoracion(servicioEquipo.valoracionEquipo(miEquipo.getId()));
		Equipo rival = servicioEquipo.dandoRival(miEquipo,id2);
		modelo.put("torneoID",torneoID);
		modelo.put("rival", rival);
		modelo.put("miEquipo", miEquipo);
		
		return new ModelAndView("/crearTorneo2", modelo);
	}
	
	@RequestMapping(path="/registrarTorneo2",method=RequestMethod.POST)
	public ModelAndView registrarTorneo2(Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4,
			Equipo equipo5, Equipo equipo6, Equipo equipo7, Equipo equipo8,Long torneoID) {
		
		ModelMap modelo = new ModelMap();

		Partido partido1 = new Partido();
		partido1.setLocal(equipo1);
		partido1.setVisitante(equipo8);
		servicioPartido.crearPartido(partido1);
		
		Partido partido2 = new Partido();
		partido1.setLocal(equipo2);
		partido1.setVisitante(equipo7);
		servicioPartido.crearPartido(partido2);

		Partido partido3 = new Partido();
		partido1.setLocal(equipo3);
		partido1.setVisitante(equipo6);
		servicioPartido.crearPartido(partido3);

		Partido partido4 = new Partido();
		partido1.setLocal(equipo4);
		partido1.setVisitante(equipo5);
		servicioPartido.crearPartido(partido4);		

		Torneo torneo = servicioTorneo.listarTorneoId(torneoID);
		servicioTorneo.agregarEquipo(equipo1);
		servicioTorneo.agregarEquipo(equipo2);
		servicioTorneo.agregarEquipo(equipo3);
		servicioTorneo.agregarEquipo(equipo4);
		servicioTorneo.agregarEquipo(equipo5);
		servicioTorneo.agregarEquipo(equipo6);
		servicioTorneo.agregarEquipo(equipo7);
		servicioTorneo.agregarEquipo(equipo8);
		
		modelo.put("torneo", torneo);
		modelo.put("partido1",partido1);
		modelo.put("partido2",partido2);
		modelo.put("partido3",partido3);
		modelo.put("partido4",partido4);
		
		return new ModelAndView("redirect:/torneos",modelo);
	}
	
	@RequestMapping(path = "/torneoDescripcion", method = RequestMethod.POST)
	public ModelAndView verTorneo(Long idTorneo) {
		ModelMap modelo = new ModelMap();
		Torneo torneo = servicioTorneo.listarTorneoId(idTorneo);
		List<Equipo> listaDeEquipos = servicioEquipo.listarEquiposPorTorneo(idTorneo);

		modelo.put("torneo", torneo);
		modelo.put("equipos",listaDeEquipos);
		return new ModelAndView("/torneoDescripcion",modelo);
	}
}
