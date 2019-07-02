package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ValoracionPesoAltura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String altura;
	private Double menos60;
	private Double entre60y70;
	private Double entre70y80;
	private Double entre80y90;
	private Double entre90y100;
	private Double mas100;
	
	public ValoracionPesoAltura() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Double getMenos60() {
		return menos60;
	}

	public void setMenos60(Double menos60) {
		this.menos60 = menos60;
	}

	public Double getEntre60y70() {
		return entre60y70;
	}

	public void setEntre60y70(Double entre60y70) {
		this.entre60y70 = entre60y70;
	}

	public Double getEntre70y80() {
		return entre70y80;
	}

	public void setEntre70y80(Double entre70y80) {
		this.entre70y80 = entre70y80;
	}

	public Double getEntre80y90() {
		return entre80y90;
	}

	public void setEntre80y90(Double entre80y90) {
		this.entre80y90 = entre80y90;
	}

	public Double getEntre90y100() {
		return entre90y100;
	}

	public void setEntre90y100(Double entre90y100) {
		this.entre90y100 = entre90y100;
	}

	public Double getMas100() {
		return mas100;
	}

	public void setMas100(Double mas100) {
		this.mas100 = mas100;
	}
	
	

}
