package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket dSock = new DatagramSocket(
											3001, //puerto
											InetAddress.getByName("localhost"));
		
		//El servidor envía información
		//Clase datagram packet rellena con la info del cliente.
		
		String mensaje = "Hola Mundóñö";
		System.out.println(mensaje);
		//los datos de la conexión son referidos al receptor
		//en este caso coinciden, menos el puerto, que tiene que ser diferente
		//si estamos trabajando en localhost, ya que estaría ocupado.
		DatagramPacket info = new DatagramPacket(mensaje.getBytes("UTF-8"), 
												 mensaje.getBytes().length, 
												 InetAddress.getByName("localhost"),
												 3000);
		dSock.send(info);
		
		
		
		
		
	}
	
	
}
