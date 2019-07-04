package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ValoracionesGenerales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer radioMedicion;
	
	public ValoracionesGenerales() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRadioMedicion() {
		return radioMedicion;
	}

	public void setRadioMedicion(Integer radioMedicion) {
		this.radioMedicion = radioMedicion;
	}
}