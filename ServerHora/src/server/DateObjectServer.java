package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Persona;

public class DateObjectServer {
	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(3001);
		Socket sock = servSock.accept();
		
		ObjectOutputStream salidaObjeto =
				new ObjectOutputStream(sock.getOutputStream());
		
		salidaObjeto.writeObject(new Persona("Juan", 45, 33));
		salidaObjeto.close();
		sock.close();
		servSock.close();
	}
}
