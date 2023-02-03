package puntoapunto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceptorUDP {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket dSock = new DatagramSocket(3000, 
													InetAddress.getByName("192.168.126.100"));
		
		byte[] bytesRecibidos = new byte[1000];
		DatagramPacket infoRecibida = new DatagramPacket(bytesRecibidos, 
														bytesRecibidos.length);
		
		dSock.receive(infoRecibida);
		
		System.out.println("Emisor: "+infoRecibida.getAddress());
		System.out.println("Puerto: "+infoRecibida.getPort());
		System.out.println("Bytes: " +infoRecibida.getLength());
		System.out.println("Mensaje: "+new String(infoRecibida.getData()));
		
		dSock.close();
	}
	
}
