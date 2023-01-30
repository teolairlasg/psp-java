package chatsimple;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static final int PUERTO = 3000;
	public static void main(String[] args) throws IOException {
		
		ServerSocket servSock = new ServerSocket(PUERTO);
		
		Socket sock = servSock.accept();
		
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		HiloTeclado hilo = new HiloTeclado(sock);
		hilo.start();
		
		while(true) {
			System.out.println(entrada.readUTF());
		}
	}

}
