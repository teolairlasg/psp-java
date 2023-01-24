package ServidorCliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloTeclado extends Thread{
	
	Socket sock;
	
	public HiloTeclado(Socket sock) {
		super();
		this.sock = sock;
	}

	@Override
	public void run() {
		//Creo el teclado
		Scanner teclado = new Scanner(System.in);
		DataOutputStream salida = null;
		try {
			//configuro la salida del socket
			salida = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			System.err.println("Error capturando la salida del socket");
			e.printStackTrace();
		}
		//leo el primer mensaje desde el teclado
		String mensaje = teclado.nextLine();
		//bucle principal: Envío por el socket y me quedo leyendo de teclado
		while(!mensaje.equals("Q")) {
			try {
				salida.writeUTF(mensaje);
			} catch (IOException e) {
				System.err.println("Error enviando la información");
				e.printStackTrace();
			}
			mensaje = teclado.nextLine();			
		}
		System.out.println("Recibido mensaje de salida");
		try {
			salida.close();
		} catch (IOException e) {
			System.err.println("Error cerrando el canal de salida.");
			e.printStackTrace();
		}
		try {
			sock.close();
		} catch (IOException e) {
			System.err.println("Error cerrando el socket.");
			e.printStackTrace();
		}

	}
	
	

}
