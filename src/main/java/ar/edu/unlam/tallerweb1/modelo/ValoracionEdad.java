package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ValoracionEdad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double menor20;
	private Double de20a25;
	private Double de26a30;
	private Double de31a35;
	private Double mayor35;
	
	public ValoracionEdad() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMenor20() {
		return menor20;
	}

	public void setMenor20(Double menor20) {
		this.menor20 = menor20;
	}

	public Double getDe20a25() {
		return de20a25;
	}

	public void setDe20a25(Double de20a25) {
		this.de20a25 = de20a25;
	}

	public Double getDe26a30() {
		return de26a30;
	}

	public void setDe26a30(Double de26a30) {
		this.de26a30 = de26a30;
	}

	public Double getDe31a35() {
		return de31a35;
	}

	public void setDe31a35(Double de31a35) {
		this.de31a35 = de31a35;
	}

	public Double getMayor35() {
		return mayor35;
	}

	public void setMayor35(Double mayor35) {
		this.mayor35 = mayor35;
	}
}