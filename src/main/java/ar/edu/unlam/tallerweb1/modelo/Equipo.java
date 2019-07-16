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

	public Double getValoracion() {
		return valoracion;
	}
	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}
	
	@OneToMany
	List<Jugador> listaDeJugadores;
	
	@OneToMany(mappedBy = "local")
	List<Partido> listaDePartidosLocal;
	
	@OneToMany(mappedBy = "visitante")
	List<Partido> listaDePartidosVisitante;
	
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