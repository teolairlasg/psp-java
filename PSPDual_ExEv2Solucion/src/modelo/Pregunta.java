package modelo;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;

public class Pregunta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pregunta;
	String respuesta;
	Date fechaHora;
	InetAddress ipCliente;
		
	@Override
	public String toString() {
		return "Pregunta [pregunta=" + pregunta + ", respuesta=" + respuesta + ", fechaHora=" + fechaHora
				+ ", ipCliente=" + ipCliente + "]";
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public InetAddress getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(InetAddress ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Pregunta(String pregunta, String respuesta, Date fechaHora, InetAddress ipCliente) {
		super();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.fechaHora = fechaHora;
		this.ipCliente = ipCliente;
	}

}
