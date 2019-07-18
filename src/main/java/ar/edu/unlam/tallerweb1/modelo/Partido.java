package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	Equipo local;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Equipo visitante;
	
	@OneToMany
	List <Gol> golesLocal;
	
	@OneToMany
	List <Gol> golesVisitante;

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public List<Gol> getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(List<Gol> golesLocal) {
		this.golesLocal = golesLocal;
	}

	public List<Gol> getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(List<Gol> golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
}