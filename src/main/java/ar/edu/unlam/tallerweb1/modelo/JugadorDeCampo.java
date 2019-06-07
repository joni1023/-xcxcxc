package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JugadorDeCampo extends Jugador{

	private int valoracion;
	private int altura;
	private int peso;
	
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public JugadorDeCampo(Long id, String nombre, int edad, Date fechaDeNacimiento,int valoracion, int altura, int peso) {
		super(id,nombre,edad,fechaDeNacimiento);
		this.valoracion = valoracion;
		this.altura = altura;
		this.peso = peso;
	}
	
	
	
}
