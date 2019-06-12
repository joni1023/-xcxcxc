package ar.edu.unlam.tallerweb1.modelo;


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
	private Date fechaDeNacimiento;
	private Double altura;
	private Double peso;
	
	public Jugador () {
		
	}
	
	public Jugador(Long id, String nombre, Integer edad, Date fechaDeNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
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
	List <Gol> goles;
	@OneToMany
	List <Amonestacion> amonestaciones ;
	@OneToMany
	List <Expulsion> expulsiones;

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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	}
	
