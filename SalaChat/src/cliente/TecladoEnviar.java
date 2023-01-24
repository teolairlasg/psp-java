package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import modelo.Mensaje;

public class TecladoEnviar extends Thread {
	Socket sock;

	public TecladoEnviar(Socket sock) {
		super();
		this.sock = sock;
	}

	@Override
	public void run() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu nombre y pulsa enter:");
		String nombre = teclado.nextLine();
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
			while(true) {
				salida.writeObject(new Mensaje(teclado.nextLine(), nombre));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
