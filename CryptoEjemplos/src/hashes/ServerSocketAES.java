package hashes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class ServerSocketAES {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		ServerSocket servSock = new ServerSocket(4321);

		Socket sock = servSock.accept();

		ObjectInputStream entrada = new ObjectInputStream(sock.getInputStream());

		byte[] recibido = (byte[]) entrada.readObject();

		Key key = new SecretKeySpec("Hola mundo123456".getBytes(), 0, 16, "AES");

		Cipher aes = Cipher.getInstance("AES");
		aes.init(Cipher.DECRYPT_MODE, key);
		byte[] desencriptado = aes.doFinal(recibido);

		System.out.println(new String(desencriptado));

	}

}
