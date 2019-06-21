package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ValoracionAltura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double menor150cm;
	private Double entre150y160cm;
	private Double entre160y170cm;
	private Double entre170y180cm;
	private Double entre180y190cm;
	private Double mayor190cm;
	
	public ValoracionAltura() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMenor150cm() {
		return menor150cm;
	}

	public void setMenor150cm(Double menor150cm) {
		this.menor150cm = menor150cm;
	}

	public Double getEntre150y160cm() {
		return entre150y160cm;
	}

	public void setEntre150y160cm(Double entre150y160cm) {
		this.entre150y160cm = entre150y160cm;
	}

	public Double getEntre160y170cm() {
		return entre160y170cm;
	}

	public void setEntre160y170cm(Double entre160y170cm) {
		this.entre160y170cm = entre160y170cm;
	}

	public Double getEntre170y180cm() {
		return entre170y180cm;
	}

	public void setEntre170y180cm(Double entre170y180cm) {
		this.entre170y180cm = entre170y180cm;
	}

	public Double getEntre180y190cm() {
		return entre180y190cm;
	}

	public void setEntre180y190cm(Double entre180y190cm) {
		this.entre180y190cm = entre180y190cm;
	}

	public Double getMayor190cm() {
		return mayor190cm;
	}

	public void setMayor190cm(Double mayor190cm) {
		this.mayor190cm = mayor190cm;
	}
	

}
