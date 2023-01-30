package servidorHora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(3001);

		Socket sock = null;

		while (true) {

			sock = servSock.accept();
			System.out.println("Un cliente salvaje apareció:" + sock.getInetAddress() + ":" + sock.getPort());
			System.out.println("Mi dirección: " + sock.getLocalAddress() + ":" + sock.getLocalPort());

			DataOutputStream salida = new DataOutputStream(
					sock.getOutputStream());
			Date fechaHora = new Date();
			
			salida.writeUTF(fechaHora.toString());
			
			salida.close();
			sock.close();
		}
	}

}
