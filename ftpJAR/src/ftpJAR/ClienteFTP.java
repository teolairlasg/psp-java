package ftpJAR;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP {
	public static void main(String[] args) throws SocketException, IOException {
		// este programa se trata de ver los archivos del servidor

		FTPClient cliente = new FTPClient();
		cliente.connect("localhost");
		if (cliente.isConnected()) {
			System.out.println("Conectado!");
		}
		boolean logged = cliente.login("ftp", "password"); // esta línea es insegura? Sí, mucho.
		if (logged) {
			FTPFile[] ficherosRemotos = cliente.listFiles();
			for (FTPFile ftpFile : ficherosRemotos) {
				if (!ftpFile.isDirectory()) {
					System.out.println("fichero: " + ftpFile.getName());
				}
			}

			FTPFile[] dirRemotos = cliente.listDirectories();
			for (FTPFile ftpDir : dirRemotos) {
				System.out.println("directorio: " + ftpDir.getName());
			}
			//descargar sólo el primer archivo de la carpeta img
			cliente.cwd("img");
			ficherosRemotos = cliente.listFiles();
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			boolean encontrado = false;
			int i = 0;
			while(!encontrado) {
				if(ficherosRemotos[i].isFile()) {
					File archivo = new File("descargado");
					FileOutputStream fos = new FileOutputStream(archivo);
					cliente.retrieveFile(ficherosRemotos[i].getName(), fos);
					encontrado = true;
				}
				i++;
			}
		} else {
			System.out.println("Login incorrecto!");
		}
	}
}
