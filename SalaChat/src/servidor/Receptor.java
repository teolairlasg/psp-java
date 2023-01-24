package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Receptor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;
	private boolean receptorFinalizado;
	public void finalizar() {
		this.receptorFinalizado = true;
	}
	public Receptor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
		this.receptorFinalizado = false;
	}
	
	@Override
	public void run() {
		ObjectInputStream entrada=null;
		try {
			entrada = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!receptorFinalizado) {
			Mensaje m = null;
			try {
				m = (Mensaje) entrada.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("[Receptor]: El cliente "+ 
							sock.getInetAddress() +" no está disponible");
				finalizar();
				//e.printStackTrace();
			}
			synchronized (listaMensajes) {
				m.setId(listaMensajes.size());
				//imprimo el mensaje en la consola del servidor
				System.out.println(m);
				listaMensajes.add(m);
				listaMensajes.notifyAll();
			}
		}
		try {
			entrada.close();
			sock.close();
		} catch (IOException e) {
			System.err.println("[Receptor]: Error cerrando socket o salida");
		} 
	}
	
}
