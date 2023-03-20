package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pregunta;
import servidor.Servidor;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket sock = new Socket("localhost", Servidor.PUERTO);
		
		DataOutputStream salida = 
				new DataOutputStream(sock.getOutputStream());
		
		Scanner teclado = new Scanner(System.in);
		
		String pregunta = teclado.nextLine();
		salida.writeUTF(pregunta);
		
		String respuesta = teclado.nextLine();
		salida.writeUTF(respuesta);
				
		ObjectInputStream entrada = 
				new ObjectInputStream(sock.getInputStream());
		
		ArrayList<Pregunta> listaPreguntas = 
				(ArrayList<Pregunta>) entrada.readObject();
		
		for (Pregunta pregunta2 : listaPreguntas) {
			System.out.println(pregunta2);
		}
		
		salida.close();
		entrada.close();
		sock.close();
	}
}
