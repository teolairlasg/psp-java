package model;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	int eda;
	int edad;
	public Persona(String nombre, int eda, int edad) {
		super();
		this.nombre = nombre;
		this.eda = eda;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ",  edad=" + edad + "]";
	}
}
