package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class JugadorArquero extends Jugador{
	
	private Integer golesRecibidos;
	private Integer rematesAtajados;
	
	
	public JugadorArquero(Long id, String nombre, Integer edad, Date fechaDeNacimiento, Double peso, Double altura, Integer valoracion, Integer golesRecibidos, Integer rematesAtajados) {
		super(id, nombre, edad, fechaDeNacimiento, peso, altura, valoracion);
		
		this.golesRecibidos = golesRecibidos;
		this.rematesAtajados = rematesAtajados;
	}

	public Integer getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(Integer golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	public Integer getRematesAtajados() {
		return rematesAtajados;
	}

	public void setRematesAtajados(Integer rematesAtajados) {
		this.rematesAtajados = rematesAtajados;
	}
}