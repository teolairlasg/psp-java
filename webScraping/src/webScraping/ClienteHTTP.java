package webScraping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHTTP {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://www.meteoclimatic.net/perfil/ESARA2200000022002A"))
				.GET()
				.build();
		
		HttpResponse res = cliente.send(req, 
				HttpResponse.BodyHandlers.ofString());
		
		System.out.println(res);
		System.out.println(res.body());
	}
}
