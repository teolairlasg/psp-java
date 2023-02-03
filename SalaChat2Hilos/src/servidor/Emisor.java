package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Emisor extends Thread {
	private boolean finalEmisor;
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;

	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
		this.finalEmisor = false;
	}

	public void finalizar() {
		finalEmisor = true;
	}

	@Override
	public void run() {
		// Inicializar la salida. object output stream
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			System.err
					.println("[Servidor-Emisor]: Error abriendo el canal de salida con " + sock.getInetAddress() + ".");
			e.printStackTrace();
			finalizar();
		}

		while (!finalEmisor) {

			// esperar notificación (synchronizadamente)
			synchronized (listaMensajes) {
				try {
					listaMensajes.wait();
				} catch (InterruptedException e) {
					System.err
							.println("[Servidor-Emisor]: El proceso fue interrumpido mientras se esperaba un mensaje.");
					finalizar();
				}
			}
			synchronized (listaMensajes) {
				try {
					salida.writeObject(listaMensajes.get(listaMensajes.size() - 1));
				} catch (IOException e) {
					System.err.println("[Servidor-Emisor]: El mensaje no se pudo enviar a " + sock.getInetAddress());
					finalizar();
				}
			}

		}
		try {
			salida.close();
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
