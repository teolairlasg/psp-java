package chatsimple;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException {
		
		Socket sock = new Socket("192.168.126.8",Servidor.PUERTO);
		
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		HiloTeclado hilo = new HiloTeclado(sock);
		hilo.start();
		
		while(true) {
			System.out.println(entrada.readUTF());
		}
	}
}
