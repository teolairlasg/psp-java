import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

public class Cliente {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		 //almacen del certificado de cliente
		System.setProperty("javax.net.ssl.keyStore",
				 "/home/alumno/SSL/almacenCliente.p12");
		 //contraseña del almacen del certificado del cliente
		 System.setProperty("javax.net.ssl.keyStorePassword", "test321");
		 //almacen de certificados en que confío (en este caso tengo el mismo almacen para
		 //el certificado propio y el certificado de los sitios en que confio)
		 System.setProperty("javax.net.ssl.trustStore", 
				 "/home/alumno/SSL/almacenConfianza.p12");
		 //contraseña del almacen de los certificados en que confío
		 System.setProperty("javax.net.ssl.trustStorePassword", "321test");
		 System.setProperty("javax.net.ssl.trustStoreType","pkcs12");
		 
		 SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		 
		Socket socket = sslFactory.createSocket("192.168.102.100",5252);
		DataOutputStream salida = 
				new DataOutputStream(socket.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		while (true) {
			salida.writeUTF(teclado.nextLine());
		}
	}

}
