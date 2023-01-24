package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServerMultiClientThread {
	
	public static final int PORT = 3001;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket servSock = new ServerSocket(PORT);
		
		Socket sock;
		while(true) {
			sock = servSock.accept();
			new HiloConexion(sock).start();
		}
	}
}
