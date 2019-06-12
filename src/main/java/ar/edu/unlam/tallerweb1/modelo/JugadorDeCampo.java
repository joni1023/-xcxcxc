package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JugadorDeCampo extends Jugador{

	private int valoracion;
	
	
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	
	public JugadorDeCampo(Long id, String nombre, int edad, Date fechaDeNacimiento,int valoracion, Double altura, Double peso) {
		super(id,nombre,edad,fechaDeNacimiento);
		this.valoracion = valoracion;
		
	}
	
	
	
}
