package puntoapunto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EmisorUDP {
	public static void main(String[] args) throws IOException {
		
		//Socket UDP
		
		
		
		DatagramSocket dSock = new DatagramSocket();
//				new DatagramSocket(3001, //puerto diferente del receptor porque 
//										 //el ejemplo es en la misma máquina
//									InetAddress.getByName("192.168.126.100")); //host local
		
		
		String mensaje = "¡Aló mundo UDP!";
		
		System.out.println(mensaje);
		
		
		
		DatagramPacket info = new DatagramPacket( mensaje.getBytes() , 
												  mensaje.getBytes().length,
												  //ip remota
												  InetAddress.getByName("192.168.126.100"),
												  //puerto remoto
												  3000);
		
		dSock.send(info);
		
		dSock.close();
		
	}
}
