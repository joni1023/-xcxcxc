package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class JugadorArquero extends Jugador{
	
	public int valoracion;
	public int golesEnContra;
	public int rematesAtajados;
	
	
	public JugadorArquero(Long id, String nombre, int edad, Date fechaDeNacimiento,int valoracion, int altura, int peso, int golesEnContra, int rematesAtajados) {
		super(id,nombre,edad,fechaDeNacimiento);
		this.valoracion = valoracion;
		
		this.golesEnContra = golesEnContra;
		this.rematesAtajados = rematesAtajados;
	}
}
