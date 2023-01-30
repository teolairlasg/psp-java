package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import modelo.Mensaje;

public class TecladoEnviar extends Thread {
	private Socket sock;
	private boolean finalTecladoEnviar;
	public TecladoEnviar(Socket sock) {
		this.sock = sock;
		this.finalTecladoEnviar = false;
	}

	@Override
	public void run() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu nombre y pulsa enter:");
		String nombre = teclado.nextLine();
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
			while(!finalTecladoEnviar) {
				salida.writeObject(new Mensaje(teclado.nextLine(),nombre));
			}
		} catch (IOException e) {
			finalizar();
			e.printStackTrace();
		}
	}

	private void finalizar() {
		// TODO Auto-generated method stub
		finalTecladoEnviar = true;
	}
	
}
