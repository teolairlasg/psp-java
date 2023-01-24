package ServidorCliente;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws IOException {
		//Creo un socket especificando la dirección con la que quiero conectar IP:Puerto
		Socket sock = new Socket("localhost",3000);
		
		//Cuando el constructor vuelve es que ya he conectado
		System.out.println("[Cliente]: Conectado con "+sock.getInetAddress());
		
		//Creo y lanzo un hilo de teclado, que se encargará de leer del teclado
		//y enviar por el socket sock.
		HiloTeclado ht = new HiloTeclado(sock);
		ht.start();
		
		//Cojo la entrada del socket para empezar a leer.
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		//Leo el primer mensaje
		String mensaje = entrada.readUTF();
		
		//Bucle principal, mientras el mensaje no sea Q sigo leyendo e imprimiendo por pantalla
		while(!mensaje.equals("Q")) {
			System.out.println("[Server]: "+ mensaje);
			mensaje = entrada.readUTF();
		}
		
		//en cuanto el mensaje es Q, salgo del bucle y cierro el socket y entrada.
		entrada.close();
		sock.close();
	}
}
