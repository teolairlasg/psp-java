package ServidorCliente;

import java.io.IOException;
import java.net.Socket;

public class MultiCliente {
	public static void main(String[] args) {
		for (int i = 4; i < 100; i++) {
			Socket sock=null;
			try {
				sock = new Socket("192.168.101."+i,3000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			System.out.println("[Cliente]: Conectado con "+sock.getInetAddress());
			try {
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}finally {
				System.out.println("Finally!");
			}
		}
	}
}
