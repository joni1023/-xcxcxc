package ar.edu.unlam.tallerweb1.modelo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	Equipo equipo1;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Equipo equipo2;
	
	@OneToMany(cascade=CascadeType.ALL)
	List <Gol> golesEquipo1;
	
	@OneToMany(cascade=CascadeType.ALL)
	List <Gol> golesEquipo2;

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public List<Gol> getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(List<Gol> golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public List<Gol> getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(List<Gol> golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
}