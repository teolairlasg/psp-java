package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import modelo.Mensaje;

public class Servidor {

	public static final int PUERTO = 3000;
	
	private static int idMsj = 0;
	
	public synchronized static void incrementarId() {
		idMsj++;
	}
	
	public synchronized static int getId() {
		return idMsj;
	}

	public static void main(String[] args) throws IOException {

		ServerSocket servSock = new ServerSocket(PUERTO);

		Socket sock = null;
		Object notificacion = new Object();
		ArrayList<ObjectOutputStream> outputList = new ArrayList<ObjectOutputStream>();
		LinkedBlockingQueue<Mensaje> messageQueue = new LinkedBlockingQueue<Mensaje>(100);

		Thread emisor = new Thread(new Emisor(notificacion, outputList, messageQueue));
		emisor.start();

		while (true) {
			sock = servSock.accept();
			synchronized (outputList) {
				outputList.add(new ObjectOutputStream(sock.getOutputStream()));
			}
			new Receptor(sock, notificacion, messageQueue).start();
			System.out.println("Cliente conectado: " + sock.getInetAddress());
		}

	}

}
