package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class JugadorDeCampo extends Jugador{

	private Integer golesConvertidos;
	
	public JugadorDeCampo() {
		
	}

	public JugadorDeCampo(Long id, String nombre, Integer edad, Date fechaDeNacimiento, Double peso, Double altura, Double valoracion, Integer golesConvertidos) {
		super(id, nombre, edad, fechaDeNacimiento, peso, altura, valoracion);
		
		this.golesConvertidos = golesConvertidos;
	}
	
	public Integer getGolesConvertidos() {
		return golesConvertidos;
	}
	
	public void setGolesConvertidos(Integer golesConvertidos) {
		this.golesConvertidos = golesConvertidos;
	}
}