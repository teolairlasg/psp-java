package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DescargaDatos {
	public static void main(String[] args) throws IOException, InterruptedException {
		String server = "https://opendata.aemet.es/opendata";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZW8ubGFpcmxhQGllc3NpZXJyYWRlZ3VhcmEuY29tIiwianRpIjoiODVjNmIwY2MtMTZiNC00OGFhLWIzMzAtNTlhMWVmYWVmMDM1IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NDQxODkxNTQsInVzZXJJZCI6Ijg1YzZiMGNjLTE2YjQtNDhhYS1iMzMwLTU5YTFlZmFlZjAzNSIsInJvbGUiOiIifQ.SP46yMOxpf3Qvs8GadWzC5Qu7SOz238deb-PF8PK2hc";
		String endpoint = "/api/observacion/convencional/todas";
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create(server+endpoint+"?api_key="+apikey))
				.GET()
				.build();
		
		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
		System.out.println(res);
		
		//https://opendata.aemet.es/opendata/api/observacion/convencional/todas?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZW8ubGFpcmxhQGllc3NpZXJyYWRlZ3VhcmEuY29tIiwianRpIjoiODVjNmIwY2MtMTZiNC00OGFhLWIzMzAtNTlhMWVmYWVmMDM1IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NDQxODkxNTQsInVzZXJJZCI6Ijg1YzZiMGNjLTE2YjQtNDhhYS1iMzMwLTU5YTFlZmFlZjAzNSIsInJvbGUiOiIifQ.SP46yMOxpf3Qvs8GadWzC5Qu7SOz238deb-PF8PK2hc
		
		
		//usar jackson para obtener la cadena de datos y de metadatos
		
		//hacer las peticiones correspondientes de esos dos JSON
		
		//coger el valor deseado filtrando por el idema de Huesca (9901X)
		
		
		
		
		
	}
}
