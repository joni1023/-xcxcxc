package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String direccion;
	private String localidad;
	
	public Sede(Long id, String direccion, String localidad) {
		this.id = id;
		this.direccion = direccion;
		this.localidad = localidad;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@OneToMany
	private List<Cancha> listaDeCanchas;
	
	public List<Cancha> getListaDeCanchas() {
		return listaDeCanchas;
	}

	public void setListaDeCanchas(List<Cancha> listaDeCanchas) {
		this.listaDeCanchas = listaDeCanchas;
	}
}