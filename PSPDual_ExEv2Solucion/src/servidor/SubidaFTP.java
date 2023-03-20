package servidor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;

import modelo.Pregunta;

public class SubidaFTP extends Thread{

	private ArrayList<Pregunta> listaPreguntas;
	
	public SubidaFTP(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	@Override
	public void run() {
		
		
		while(true) {
			//dormir 2 minutos
			try {
				this.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File fichero = new File("./preguntas.txt");
			try {
				BufferedWriter buffer = 
						new BufferedWriter(new FileWriter(fichero));
				synchronized (listaPreguntas) {
					for (Pregunta pregunta : listaPreguntas) {
						buffer.write(pregunta.toString());
						buffer.newLine();
					}
				}				
				buffer.close();
				
				FTPClient ftp = new FTPClient();
				ftp.connect("192.168.126.100");
				if (ftp.isConnected()) {
					if(ftp.login("ftp", "password")){
						ftp.storeFile("pregs.txt", 
								new FileInputStream(fichero));
						
					}else {
						System.err.println("error en el login");
					}
					
				}else {
					System.err.println("No se pudo conectar con el FTP");
				}
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
		
		
	}
}
