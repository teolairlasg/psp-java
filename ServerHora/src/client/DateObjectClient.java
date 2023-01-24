package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class DateObjectClient {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket sock = new Socket("localhost",3001);
		
		ObjectInputStream entradaObject = 
				new ObjectInputStream(sock.getInputStream());
		
		Date fecha = (Date) entradaObject.readObject();
		Date fechaActual = new Date();
		System.out.println("He recibido "+ fecha);
		System.out.println("Son las " + fechaActual);
		System.out.println("Diferencia:");
		System.out.println( (fechaActual.getTime() - fecha.getTime()) + "ms." );
		
	}
}
