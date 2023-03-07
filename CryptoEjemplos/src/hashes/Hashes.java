package hashes;
import java.security.MessageDigest;

public class Hashes {

	public static void main(String[] args) throws Exception {

		MessageDigest md = 
				MessageDigest.getInstance("SHA-1");
		md.update("P4$$w0rd.".getBytes());
		byte[] digest = md.digest();

		// Se escribe byte a byte en hexadecimal
		for (byte b : digest) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();

		// Se escribe codificado base 64. Se necesita la librería
		// commons-codec-x.x.x.jar de Apache
		//byte[] encoded = Base64.encodeBase64(digest);
		//System.out.println(new String(encoded));
	}
}
