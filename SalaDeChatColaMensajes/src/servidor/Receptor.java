package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import modelo.Mensaje;

public class Receptor extends Thread {
	Object notificacion;
	Socket sock;
	LinkedBlockingQueue<Mensaje> messageQueue;

	public Receptor(Socket sock, 
					Object notificacion,
					LinkedBlockingQueue<Mensaje> messageQueue) {
		this.notificacion = notificacion;
		this.sock = sock;
		this.messageQueue = messageQueue;
	}

	@Override
	public void run() {
		Mensaje m = null;
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream( sock.getInputStream() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				m = (Mensaje) entrada.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				m.setId(Servidor.getId());
				Servidor.incrementarId();
				messageQueue.put(m);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	

}
