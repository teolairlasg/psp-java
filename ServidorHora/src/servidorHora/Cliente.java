package servidorHora;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket sock = new Socket("localhost", 3001);
		System.out.println("Un servidor salvaje está conectado:" + sock.getInetAddress() + ":" + sock.getPort());
		System.out.println("Mi dirección: " + sock.getLocalAddress() + ":" + sock.getLocalPort());

		DataInputStream entrada = new DataInputStream(sock.getInputStream());

		System.out.println(entrada.readUTF());
		entrada.close();
		sock.close();

	}

}
