package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import modelo.Mensaje;

public class Emisor implements Runnable {
	Object notificacion; 
	ArrayList<ObjectOutputStream> outputList;
	LinkedBlockingQueue<Mensaje> messageQueue;
	public Emisor(Object notificacion, 
				  ArrayList<ObjectOutputStream> outputList,
				  LinkedBlockingQueue<Mensaje> messageQueue) {
		this.notificacion = notificacion;
		this.outputList = outputList;
		this.messageQueue = messageQueue;
		
	}

	@Override
	public void run() {
		Mensaje m=null;
		while(true) {
			try {
				m = messageQueue.take();
				System.out.println(m);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (outputList) {
				for ( ObjectOutputStream salida : outputList ) {
					try {
						salida.writeObject(m);
					} catch (IOException e) {
						System.out.println("Un cliente se ha desconectado");
						outputList.remove(salida);
					}
				}
			}
		}
	}

}
