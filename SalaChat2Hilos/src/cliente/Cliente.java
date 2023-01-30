package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modelo.Mensaje;

public class Cliente {
	private static boolean finalCliente = false;
	private static void finalizar() {
		finalCliente=true;
	}
	public static void main(String[] args){
	
		Socket sock = null;
		ObjectInputStream entrada = null;
		try {
			sock = new Socket("localhost", servidor.Servidor.PUERTO);
			new TecladoEnviar(sock).start();
		} catch (UnknownHostException e1) {
			System.err.println("[Cliente]: Host desconocido!");
		} catch (IOException e1) {
			System.err.println("[Cliente]: No se pudo realizar la conexión inicial");
		}
		try {
			entrada = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e1) {
			System.err.println("[Cliente]: No se pudo abrir el canal de entrada.");
			finalizar();
		}
		while(!finalCliente) {
			try {
				System.out.println( (Mensaje) entrada.readObject() );
			} catch (ClassNotFoundException e) {
				System.err.println("[Cliente]: Error leyendo el objeto, no se pudo hacer el cast a Mensaje");
				finalizar();
			} catch (IOException e) {
				System.err.println("[Cliente]: Error leyendo el objeto, error de entrada/salida");
				finalizar();
			}	
		}
		
	}
}
