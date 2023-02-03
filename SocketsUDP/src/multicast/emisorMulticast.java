package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class emisorMulticast {

	public static void main(String[] args) throws IOException {

		// Socket UDP
		//Si lo ponemos sin datos, no sabemos porqué tarjeta de red saldrá.
		//DatagramSocket dSock = new DatagramSocket();
		//Si especificamos la IP de nuestra máquina, seleccionamos la tarjeta de red
		//por la que queremos conectar el socket d salida.
		DatagramSocket dSock = new DatagramSocket(3001, //puerto diferente del receptor porque 
										//el ejemplo es en la misma máquina
										InetAddress.getByName("192.168.126.100")); //host local

		String mensaje = "¡Aló mundo UDP!";

		System.out.println(mensaje);

		DatagramPacket info = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length,
				// ip remota
				InetAddress.getByName("224.0.0.1"),
				// puerto remoto
				3000);

		dSock.send(info);

		dSock.close();

	}
}
