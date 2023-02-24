package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DescargaDatosHuesca {
	public static void main(String[] args) throws IOException, InterruptedException {
		String server = "https://opendata.aemet.es/opendata";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZW8ubGFpcmxhQGllc3NpZXJyYWRlZ3VhcmEuY29tIiwianRpIjoiODVjNmIwY2MtMTZiNC00OGFhLWIzMzAtNTlhMWVmYWVmMDM1IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NDQxODkxNTQsInVzZXJJZCI6Ijg1YzZiMGNjLTE2YjQtNDhhYS1iMzMwLTU5YTFlZmFlZjAzNSIsInJvbGUiOiIifQ.SP46yMOxpf3Qvs8GadWzC5Qu7SOz238deb-PF8PK2hc";
		String endpoint = "/api/observacion/convencional/datos/estacion/9901X";
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
		ObjectMapper mapper = new ObjectMapper();
		String urlDatos = mapper.readTree(res.body()).at("/datos").asText();
		//hacer las peticiones correspondientes de esos dos JSON
		HttpRequest reqDatos = HttpRequest.newBuilder()
				.uri(URI.create(urlDatos))
				.GET()
				.build();
		
		HttpResponse<String> resDatos = cliente.send(reqDatos, HttpResponse.BodyHandlers.ofString());
		
		//Mapeamos los datos de Huesca en una lista.
		List<EstacionMeteo> observacionHuesca = 
				mapper.readValue(resDatos.body(), 
				new TypeReference<List<EstacionMeteo>>(){});
		
		for (EstacionMeteo estacionMeteo : observacionHuesca) {
			System.out.println(estacionMeteo.getFint()+" "+estacionMeteo.getTa());
			
		}
	}
}
