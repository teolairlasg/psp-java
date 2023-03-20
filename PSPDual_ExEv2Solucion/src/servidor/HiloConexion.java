package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import modelo.Pregunta;

public class HiloConexion implements Runnable {
	
	Socket sock;
	ArrayList<Pregunta> listaPreguntas;
	
	public HiloConexion(Socket sock, ArrayList<Pregunta> listaPreguntas) {
		this.sock = sock;
		this.listaPreguntas = listaPreguntas;
	}

	@Override
	public void run() {
		DataInputStream entrada = null;
		Pregunta p = null;
		try {
			entrada = new DataInputStream(sock.getInputStream());
		} catch (IOException e) {
			System.err.println("Error obteniendo el canal de entrada");
			e.printStackTrace();
		}
		
		try {
			String pregunta = entrada.readUTF();
			String respuesta = entrada.readUTF();
			p = new Pregunta(pregunta, 
							 respuesta,
							 new Date(),
							 sock.getInetAddress());
			System.out.println(p);
			//entrada.close();
		} catch (IOException e) {
			System.err.println("Error leyendo pregunta o respuesta");
			e.printStackTrace();
		}
		
		synchronized (listaPreguntas) {
			listaPreguntas.add(p);			
		}
		
		
		try {
			ObjectOutputStream salida = 
					new ObjectOutputStream(sock.getOutputStream());
			salida.writeObject(listaPreguntas);
			//salida.close();
		} catch (IOException e) {
			System.err.println(
"Error abriendo el flujo de salida o enviando la lista de preguntas");
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
