package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Emisor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;
	private boolean emisorFinalizado;
	public void finalizar() {
		emisorFinalizado = true;
	}
	
	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
		this.emisorFinalizado = false;
	}
	@Override
	public void run() {
		//Inicializar la salida. object output stream
		ObjectOutputStream salida = null;
		try {
			 salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!emisorFinalizado) {
			Mensaje m = null;
			//Esperamos sobre la lista de mensajes synchronizadamente una notificación
			synchronized (listaMensajes) {
				try {
					listaMensajes.wait();
				} catch (InterruptedException e) {
					System.err.println("[Emisor]: Me han interrumpido mientras esperaba");
				}
				//obtenemos el último mensaje
				m = listaMensajes.get( listaMensajes.size() - 1 );
			}
			// enviarlo por la salida.
			try {
				salida.writeObject(m);
			} catch (IOException e) {
				System.err.println("[Emisor]: Error al enviar el mensaje al cliente");
				finalizar();
			}
		}
		try {
			salida.close();
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
