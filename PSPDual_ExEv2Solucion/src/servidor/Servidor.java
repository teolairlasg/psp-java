package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import modelo.Pregunta;
import java.util.ArrayList;

public class Servidor {

	public static int PUERTO = 4321;
	
	
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(PUERTO);

		Socket sock = null;
		Thread t = null;
		ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
		new SubidaFTP(listaPreguntas).start();
		while(true) {
			sock = servSock.accept();
			t = new Thread(new HiloConexion(sock, listaPreguntas));
			t.start();
		}
		
		
	}
	
}
