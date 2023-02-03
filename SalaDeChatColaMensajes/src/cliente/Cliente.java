package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import modelo.Mensaje;

public class Cliente {
	public static void main(String[] args) throws IOException {
		
		Socket sock = new Socket("192.168.126.8",servidor.Servidor.PUERTO);
		
		ObjectInputStream entrada = new ObjectInputStream(sock.getInputStream());
		
		HiloTeclado hilo = new HiloTeclado(sock);
		hilo.start();
		
		while(true) {
			try {
				System.out.println( (Mensaje)  entrada.readObject());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
