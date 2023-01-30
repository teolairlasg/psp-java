package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class receptorMulticast {
	
	public static void main(String[] args) throws IOException {
		MulticastSocket mCastSock = 
				new MulticastSocket(new InetSocketAddress("192.168.126.100",3000));
		
		//Ip del grupo multicast (clase D)
		InetAddress ipGrupo = InetAddress.getByName("224.0.0.1");
		//Especificamos el grupo con la IP, el puerto y 
		//decimos que la interfaz tiene que ser la que tiene esa IP,
		//si no no sabremos cuál se pone.
		mCastSock.joinGroup(new InetSocketAddress(ipGrupo, 3000), //dirección multicast
							NetworkInterface.getByInetAddress(InetAddress.getByName("192.168.126.100"))); //tarjeta de red!	
		while(true) {
			byte[] bytesRecibidos = new byte[1000];
			DatagramPacket infoRecibida = new DatagramPacket(bytesRecibidos, 
												bytesRecibidos.length);
			mCastSock.receive(infoRecibida);
			System.out.println("Emisor: "+infoRecibida.getAddress());
			System.out.println("Puerto: "+infoRecibida.getPort());
			System.out.println("Bytes: " +infoRecibida.getLength());
			System.out.println("Mensaje: "+new String(infoRecibida.getData()));
		}
	}
	
}
