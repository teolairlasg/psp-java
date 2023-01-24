package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket dSock = new DatagramSocket(
				3000, //puerto
				InetAddress.getByName("localhost"));
		
		//creo un datagrama vacío en el que quepan 1000 bytes
		byte[] arrayDeBytes = new byte[1000];
		DatagramPacket info = new DatagramPacket(arrayDeBytes, arrayDeBytes.length);
		
		dSock.receive(info);
		
		System.out.println("Recibido de: "+info.getAddress());
		System.out.println("Por el puerto: "+info.getPort());
		System.out.println("Datos recibidos: "+new String(info.getData(),"UTF-8"));
	}
}
