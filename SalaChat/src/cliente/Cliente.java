package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modelo.Mensaje;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
	
		Socket sock = new Socket("192.168.101.4", servidor.Servidor.PUERTO);
		new TecladoEnviar(sock).start();;
		ObjectInputStream entrada = new ObjectInputStream(sock.getInputStream());
		while(true) {
			try {
				System.out.println( (Mensaje) entrada.readObject() );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
