package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;
import ar.edu.unlam.tallerweb1.servicios.ServicioValoracion;

@Controller
public class ControladorValoraciones {
	
	@Inject
	private ServicioValoracion servicioValoracion;
	
	@RequestMapping("/valoraciones")
	public ModelAndView mostrarValoraciones() {
		ModelMap modelo =new ModelMap();
		ValoracionEdad valorEdad= new ValoracionEdad();
		ValoracionAltura valorAltura=new ValoracionAltura();
		ValoracionPesoAlturaA valorPeso = new ValoracionPesoAlturaA();
		modelo.put("valoracionEdad", valorEdad);
		modelo.put("valoracionAltura", valorAltura);
		modelo.put("valoracionPesoAlturaA", valorPeso);
		modelo.put("listvalorEdad", servicioValoracion.verValoraciondeEdadTabla());
		modelo.put("listvalorAltura", servicioValoracion.verValoracionAlturaTabla());
		modelo.put("listaValor", servicioValoracion.listaValoracionPesoAlturaA());
		
		return new ModelAndView ("valoraciones",modelo);
	}
	
	
	

}
