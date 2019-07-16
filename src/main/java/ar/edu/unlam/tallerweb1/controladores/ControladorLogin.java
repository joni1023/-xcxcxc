package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml.
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioEquipo servicioEquipo;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET.
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'.
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo.
		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView irARegister() {
		return new ModelAndView("register");
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST.
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form.
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// Invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a esta.
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if(usuarioBuscado != null) {
			if(usuarioBuscado.getEsAdmin() == true) {
				return new ModelAndView("redirect:/homeAdmin");
			}
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			return new ModelAndView("redirect:/home");
		} else {
			// Si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Los datos ingresados son incorrectos. Por favor, intente nuevamente.");
		}
		
		return new ModelAndView("login", model);
	}
	
	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		usuario.setEsAdmin(false);
		servicioLogin.agregarUsuario(usuario);		
		return new ModelAndView("redirect:/login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.consultarUsuarioId((Long)request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		Boolean tieneEquipo = false;
		if(usuarioBuscado.getEquipo() != null) {
			tieneEquipo = true;
		}
		modelo.put("usuario",usuarioBuscado);
		modelo.put("tieneEquipo", tieneEquipo);
		return new ModelAndView("home" , modelo);
	}
	
	@RequestMapping(path = "/homeAdmin", method = RequestMethod.GET)
	public ModelAndView irAHomeAministrador() {
		return new ModelAndView("homeAdmin");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}