import java.io.IOException;
import java.util.concurrent.Executors;

public class Comando {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("os.name"));
		
		Process proceso;
		proceso = Runtime.getRuntime().exec("cat /proc/timer_list");

		StreamGobbler streamGobbler = new StreamGobbler(proceso.getInputStream(), System.out::println);
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		int exitCode = proceso.waitFor();
		System.out.println("Código de finalización del proceso: "+exitCode);
	}

}
