package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAltura;
import ar.edu.unlam.tallerweb1.servicios.ServicioValoracion;

@Controller
public class ControladorValoraciones {
	
	@Inject
	private ServicioValoracion servicioValoracion;
	
	@RequestMapping("/valoraciones")
	public ModelAndView mostrarValoraciones() {
		ModelMap modelo = new ModelMap();
		ValoracionEdad valorEdad = new ValoracionEdad();
		ValoracionAltura valorAltura = new ValoracionAltura();
		ValoracionPesoAltura valorPeso = new ValoracionPesoAltura();
		modelo.put("valoracionEdad", valorEdad);
		modelo.put("valoracionAltura", valorAltura);
		modelo.put("valoracionPesoAlturaA", valorPeso);
		modelo.put("listaValorEdad", servicioValoracion.verValoraciondeEdadTabla());
		modelo.put("listaValorAltura", servicioValoracion.verValoracionAlturaTabla());
		modelo.put("listaValor", servicioValoracion.listaValoracionPesoAltura());
		
		return new ModelAndView ("valoraciones", modelo);
	}

	
	@RequestMapping(path="/modificarTablaEdad", method=RequestMethod.POST)
	public ModelAndView modificarValoracionEdad(@ModelAttribute ("valoracionEdad") ValoracionEdad valoracionEdad) {
		ModelMap modelo = new ModelMap();
		
		return new ModelAndView();
	}
}