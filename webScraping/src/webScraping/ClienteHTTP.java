package webScraping;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClienteHTTP {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://www.meteoclimatic.net/perfil/ESARA2200000022002A"))
				.GET()
				.build();
		//Recibo la respuesta como string
		HttpResponse<String> res = cliente.send(req, 
				HttpResponse.BodyHandlers.ofString());
		
		//Recibo la respuesta como Fichero descargado
		//HttpResponse<Path> resPath = cliente.send(req,
		//		HttpResponse.BodyHandlers.ofFile(Paths.get("descargado.html")));
		
		//Recibir la respuesta mediante un stream
		//HttpResponse<InputStream> resInputStream = cliente.send(req,
		//		HttpResponse.BodyHandlers.ofInputStream());
		//hacer directamente la conexión
		//
		Document doc = Jsoup.parse(res.body());
		
		Elements elementos = doc.select(".titolseccio");
		
		for (Element e:elementos) {
			System.out.println(e.text());
		}
		
		
		System.out.println(res);
		//System.out.println(res.body());
	}
}