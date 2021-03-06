package cripto;
import java.security.MessageDigest;
import java.util.Base64;



public class CalcularHashes {

	/**
	 * Ejemplo para extraer MD5 de una cadena de texto. Como los bytes obtenidos no
	 * son legibles, los escribimos en hexadecimal y codificado base 64
	 * con ayuda de la librería apache commons-codec.
	 * 
	 * @author Chuidiang
	 * 
	 */
	  public static void main(String[] args) throws Exception {

	      MessageDigest md = MessageDigest.getInstance("SHA-256");
	      String mensaje = "Hola mundp";
	      md.update(mensaje.getBytes());
	      byte[] hash = md.digest();

	      // Se escribe byte a byte en hexadecimal
	      for (byte b : hash) {
	         System.out.print(Integer.toHexString(0xFF & b));
	      }
	      System.out.println();

	      // Se escribe codificado base 64.
	      // byte[] encoded = Base64.encodeBase64(digest);
	      //System.out.println(new String(encoded));
	   }
	}

