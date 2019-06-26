package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer edad;
	private Date fechaDeNacimiento;
	private Double peso;
	private Double altura;
	private Double valoracion;
	private String posicion;
	
	private Integer golesConvertidos;
	
	private Integer golesRecibidos;
	
	

	public Jugador () {
		
	}
	
	public Jugador(Long id, String nombre, Integer edad, Date fechaDeNacimiento, Double peso, Double altura, Double valoracion) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.valoracion = valoracion;
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
	
	public Double getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	@OneToMany(cascade=CascadeType.ALL)
	List <Gol> goles;
	
	@OneToMany(cascade=CascadeType.ALL)
	List <Amonestacion> amonestaciones;
	
	@OneToMany(cascade=CascadeType.ALL)
	List <Expulsion> expulsiones;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Equipo equipo;
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

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
	public Integer getGolesConvertidos() {
		return golesConvertidos;
	}

	public void setGolesConvertidos(Integer golesConvertidos) {
		this.golesConvertidos = golesConvertidos;
	}

	public Integer getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(Integer golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}