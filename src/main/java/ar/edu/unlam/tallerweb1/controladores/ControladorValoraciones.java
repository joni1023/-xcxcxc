package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioValoracion;

@Controller
public class ControladorValoraciones {
	
	@Inject
	private ServicioValoracion servicioValoracion;
	
	@RequestMapping("/valoraciones")
	public ModelAndView mostrarValoraciones() {
		ModelMap modelo =new ModelMap();
		modelo.put("valorEdad", servicioValoracion.verValoraciondeEdadTabla());
		modelo.put("valorAltura", servicioValoracion.verValoracionAlturaTabla());
		modelo.put("listaValor", servicioValoracion.listaValoracionPesoAlturaA());
		
		return new ModelAndView ("valoraciones",modelo);
	}
	
	
	

}
