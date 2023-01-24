package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class DateTextClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//sin timeout
		//Socket sock = new Socket("localhost",server.DateTextServer.PORT);
		
		//Preparo el socket
		Socket sock = new Socket();
		//Preparo la dirección del servidor. IP y Puerto
		SocketAddress sockAddr = new InetSocketAddress("localhost",server.DateTextServer.PORT);
		//Intento la conexión, estableciendo un timeout de 6 segundos.
		sock.connect(sockAddr, 6000);
		
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		String fecha = entrada.readUTF();
		
		System.out.println(fecha);
		entrada.close();
		sock.close();
	}
}
