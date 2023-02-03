package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Receptor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;
	private boolean finalReceptor;
	public Receptor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
		this.finalReceptor = false;
	}
	private void finalizar() {
		finalReceptor = true;
	}
	@Override
	public void run() {
		ObjectInputStream entrada=null;
		try {
			entrada = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			System.err.println("[Servidor-Receptor]: No se pudo abrir el canal de entrada con "+sock.getInetAddress()+".");
			e.printStackTrace();
		}
		while(!finalReceptor) {
			Mensaje m = null;
			try {
				m = (Mensaje) entrada.readObject();
			} catch (ClassNotFoundException e) {
				System.err.println("[Servidor-Receptor]: El objeto que se recibió no era de la clase apropiada.");
				finalizar();
			} catch (IOException e) {
				System.err.println("[Servidor-Receptor]: Error leyendo el objeto de la entrada.");
				finalizar();
			}
			synchronized (listaMensajes) {
				m.setIdMsj(listaMensajes.size());
				listaMensajes.add(m);
				listaMensajes.notifyAll();
			}
		}
		try {
			entrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
