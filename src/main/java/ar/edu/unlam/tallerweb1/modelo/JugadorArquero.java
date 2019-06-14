package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class JugadorArquero extends Jugador{
	
	private Integer golesRecibidos;
	
	public JugadorArquero() {
		
	}
	
	public JugadorArquero(Long id, String nombre, Integer edad, Date fechaDeNacimiento, Double peso, Double altura, Double valoracion, Integer golesRecibidos, Integer rematesAtajados) {
		super(id, nombre, edad, fechaDeNacimiento, peso, altura, valoracion);
		
		this.golesRecibidos = golesRecibidos;
	}

	public Integer getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(Integer golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
}