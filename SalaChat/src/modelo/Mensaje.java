package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date fechaHora;
	private String texto;
	private String emisor;
	private int id;
	public Mensaje(String texto, String emisor) {
		super();
		this.fechaHora = new Date();
		this.texto = texto;
		this.emisor = emisor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// (fechahora) juanito: Hola mundo.
		SimpleDateFormat sdf = new SimpleDateFormat("(HH:mm:ss)");
		String fechaBonita = sdf.format(fechaHora);
		String numBonito = String.format("#%04d ", id);
		return numBonito +fechaBonita + " " + emisor + ":" + texto;
	}
}
