package modelo;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String remitente;
	private Date fechaHora;
	private String texto;
	private int id;

	public Mensaje(String remitente, String texto) {
		super();
		this.remitente = remitente;
		this.texto = texto;
		this.fechaHora = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("[#%04d]",id)+" (" + fechaHora + ") " + remitente + ": " + texto;
	}

}
