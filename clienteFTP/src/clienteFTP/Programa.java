package clienteFTP;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Programa {

	public static void mostrarDirectorio(FTPClient cliente, String carpeta, String prefijo) throws IOException {
		cliente.cwd(carpeta);
		FTPFile[] archivos = cliente.listFiles();
		for (FTPFile ftpFile : archivos) {
			if (ftpFile.isFile()) {
				System.out.println(prefijo+ftpFile.getName());
			}else {
				System.out.println(prefijo+ftpFile.getName()+"/");
				mostrarDirectorio(cliente, ftpFile.getName(), prefijo+"  ");
				cliente.changeToParentDirectory();
			}
		}
		
	}
	
	
	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");

		boolean conectado = cliente.login("user", "password");

		if (conectado) {
			System.out.println("¡Login correcto!");
			mostrarDirectorio(cliente, "/", "");
		} else {
			System.err.println("Error en el login.");
		}
		cliente.disconnect();
	}

}
