package hashes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class ClientSocketAES {

	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		
		Socket sock = new Socket("localhost", 4321);

		Key key = new SecretKeySpec("Hola mundo123456".getBytes(), 0, 16, "AES");

		String texto = "Este es el texto que queremos encriptar.";

		Cipher aes = Cipher.getInstance("AES");

		aes.init(Cipher.ENCRYPT_MODE, key);
		byte[] encriptado = aes.doFinal(texto.getBytes());

		// Enviamos
		ObjectOutputStream salida = new ObjectOutputStream(sock.getOutputStream());
		salida.writeObject(encriptado);

		salida.close();
		sock.close();
	}

}
