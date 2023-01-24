package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Servidor {

	public static final int PUERTO = 3000;

	public static void main(String[] args) throws IOException {
		ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		ServerSocket servSock = new ServerSocket(PUERTO);
		Socket sock = null;
		while (true) {
			sock = servSock.accept();
			new Emisor(sock, listaMensajes).start();
			new Receptor(sock, listaMensajes).start();
			System.out.println("[Servidor]: El cliente "+ sock.getInetAddress() +" se conectó.");
		}
	}
}
