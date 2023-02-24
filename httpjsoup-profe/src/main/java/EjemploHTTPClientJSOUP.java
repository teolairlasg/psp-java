import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EjemploHTTPClientJSOUP {

	public static void main(String[] args) throws IOException, InterruptedException {
		//el cliente
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
							.uri(URI.create("https://www.marca.com/futbol/primera-division/calendario.html"))
							.GET()
							.build();
		
		HttpResponse<String> res = client.send(
									  req,
								      HttpResponse.BodyHandlers.ofString());
		
		
		
		System.out.println(res.statusCode());
		System.out.println(res);
		
		//System.out.println(res.body());
		
		Document doc = Jsoup.parse(res.body());
		
		Scanner teclado = new Scanner(System.in);
		Integer jornada = 0;
		while(jornada < 1 || jornada > 38){
			System.out.println("Selecciona la jornada:");
			jornada = Integer.valueOf(teclado.nextLine());
		}
		Elements resultadosJugados = doc.select("table#jornada"+jornada+" tbody tr");
		for (Element element : resultadosJugados) {
			System.out.println(element.text());
		}
		
		
		
		
		
		
		
		
	}
	
	
	
}
