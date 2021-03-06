package cripto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DescifradoAsimetrico {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//cargamos clave ya creada en el otro programa CifradoAsimetrico.java
		FileInputStream fichero = new FileInputStream("./Publica.dat");
		// obtengo el número de bytes del fichero
		int nBytes = fichero.available();
		//creo un array en que quepa justa la clave leída.
		byte[] claveBytes = new byte[nBytes];
		//meto el contenido del fichero en la clave
		fichero.read(claveBytes);
		fichero.close();
		
		//leemos el fichero encriptado (reutilizamos objetos)
		fichero = new FileInputStream("./TextoCifrado.dat");
		nBytes = fichero.available();
		byte[] textoCifrado = new byte[nBytes];
		fichero.read(textoCifrado);
		fichero.close();
		
		
		KeyFactory fabricaClaves = KeyFactory.getInstance("RSA");
		KeySpec tipoClave = new X509EncodedKeySpec(claveBytes);
		PublicKey clavePublica = fabricaClaves.generatePublic(tipoClave);
		
		Cipher rsa = Cipher.getInstance("RSA/GCB/PKCS1Padding");
		rsa.init(Cipher.DECRYPT_MODE, clavePublica);
		
		byte[] textoEnBytes = rsa.doFinal(textoCifrado);
		String textoDescifrado = new String(textoEnBytes);
		System.out.println(textoDescifrado);
		
	}
}
