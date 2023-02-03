package chatsimple;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloTeclado extends Thread{

	Socket sock;
	public HiloTeclado(Socket sock) {
		this.sock = sock;
	}
	@Override
	public void run() {
		DataOutputStream salida = null;
		try {
			salida = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner teclado = new Scanner(System.in);
		while(true) {
			try {
				salida.writeUTF(teclado.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
