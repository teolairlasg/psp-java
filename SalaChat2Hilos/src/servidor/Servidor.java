package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Servidor {

	public static final int PUERTO = 3000; 

	public static void main(String[] args){
		ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		ServerSocket servSock = null;
		try {
			servSock = new ServerSocket(PUERTO);
		} catch (IOException e) {
			System.err.println("[Servidor-Main]: Error abriendo el socket de servidor ¿puerto ocupado?");
			e.printStackTrace();
		}
		Socket sock = null;
		while (true) {
			try {
				sock = servSock.accept();
			} catch (IOException e) {
				System.err.println("[Servidor-Main]: Error al aceptar la conexión del cliente");
				e.printStackTrace();
			}
			new Emisor(sock, listaMensajes).start();
			new Receptor(sock, listaMensajes).start();
		}
	}
}
