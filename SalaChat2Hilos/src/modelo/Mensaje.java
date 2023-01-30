package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date fechaHora;
	private String texto;
	private String emisor;
	private int idMsj;
	public Mensaje(String texto, String emisor) {
		super();
		this.fechaHora = new Date();
		this.texto = texto;
		this.emisor = emisor;
	}
	@Override
	public String toString() {
		// (fechahora) juanito: Hola mundo.
		String sdfPattern = "HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(sdfPattern);
		return String.format("[#%04d] - %s - %s: %s", idMsj, sdf.format(fechaHora), emisor, texto );
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public int getIdMsj() {
		return idMsj;
	}
	public void setIdMsj(int idMsj) {
		this.idMsj = idMsj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
