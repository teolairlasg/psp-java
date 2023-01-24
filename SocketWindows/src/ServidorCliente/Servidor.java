package ServidorCliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serv = new ServerSocket(3000);
		Socket sock = serv.accept();
		System.out.println("[Server]: Conectado con "+sock.getInetAddress());
		HiloTeclado ht = new HiloTeclado(sock);
		ht.start();
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		String mensaje = entrada.readUTF();
		while(!mensaje.equals("Q")) {
			System.out.println(mensaje);
			mensaje = entrada.readUTF();
		}
		entrada.close();
		sock.close();
		serv.close();
		ht.join();
	}

}
