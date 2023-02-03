package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import modelo.Mensaje;

public class HiloTeclado extends Thread{

	Socket sock;
	public HiloTeclado(Socket sock) {
		this.sock = sock;
	}
	@Override
	public void run() {
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu nombre: ");
		String nombre = teclado.nextLine();
		while(true) {
			try {
				salida.writeObject(new Mensaje(nombre, teclado.nextLine()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
