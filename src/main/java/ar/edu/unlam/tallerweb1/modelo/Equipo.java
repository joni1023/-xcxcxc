package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer golesAFavor;
	private Integer golesEnContra;
	private Integer partidosGanados;
	private Integer partidosPerdidos;
	private Integer partidosEmpatados;
	private Double promedioDeEdad;
	private String categoria;
	private String localidad;
	private Double valoracion;
	
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
	
	public Integer getGolesAFavor() {
		return golesAFavor;
	}
	
	public void setGolesAFavor(Integer golesAFavor) {
		this.golesAFavor = golesAFavor;
	}
	
	public Integer getGolesEnContra() {
		return golesEnContra;
	}
	
	public void setGolesEnContra(Integer golesEnContra) {
		this.golesEnContra = golesEnContra;
	}
	
	public Integer getPartidosGanados() {
		return partidosGanados;
	}
	
	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	
	public Integer getPartidosPerdidos() {
		return partidosPerdidos;
	}
	
	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	
	public Integer getPartidosEmpatados() {
		return partidosEmpatados;
	}
	
	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	
	public Double getPromedioDeEdad() {
		return promedioDeEdad;
	}
	
	public void setPromedioDeEdad(Double promedioDeEdad) {
		this.promedioDeEdad = promedioDeEdad;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Double getValoracion() {
		return valoracion;
	}
	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	List <Jugador> listaDeJugadores;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "local")
	List <Partido> listaDePartidosLocal;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "visitante")
	List <Partido> listaDePartidosVisitante;
	
	@OneToOne
	Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public List<Partido> getListaDePartidosLocal() {
		return listaDePartidosLocal;
	}

	public void setListaDePartidosLocal(List<Partido> listaDePartidosLocal) {
		this.listaDePartidosLocal = listaDePartidosLocal;
	}

	public List<Partido> getListaDePartidosVisitante() {
		return listaDePartidosVisitante;
	}

	public void setListaDePartidosVisitante(List<Partido> listaDePartidosVisitante) {
		this.listaDePartidosVisitante = listaDePartidosVisitante;
	}

	public List<Jugador> getListaDeJugadores() {
		return listaDeJugadores;
	}
	
	public void setListaDeJugadores(List<Jugador> listaDeJugadores) {
		this.listaDeJugadores = listaDeJugadores;
	}
}