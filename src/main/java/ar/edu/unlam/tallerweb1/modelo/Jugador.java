package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer edad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@OneToMany
	List<Gol>goles = new ArrayList();
	@OneToMany
	List<Amonestacion>amonestaciones = new ArrayList();
	@OneToMany
	List<Expulsion>expulsiones = new ArrayList();

	public List<Gol> getGoles() {
		return goles;
	}
	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}
	public List<Amonestacion> getAmonestaciones() {
		return amonestaciones;
	}
	public void setAmonestaciones(List<Amonestacion> amonestaciones) {
		this.amonestaciones = amonestaciones;
	}
	public List<Expulsion> getExpulsiones() {
		return expulsiones;
	}
	public void setExpulsiones(List<Expulsion> expulsiones) {
		this.expulsiones = expulsiones;
	}
	
	}
	
