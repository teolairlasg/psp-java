import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUPMeteoclimatic {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.meteoclimatic.net/perfil/ESARA2200000022194A").get();
		System.out.println(doc.title());
		// Selector de Chrome
		Element temperatura = doc.select(
				"#content > table:nth-child(3) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1)").first();
		// Selector de Firefox
		Element temperaturaFF = doc.select("td.dadesactuals:nth-child(1)").first();
		System.out.println(temperatura.text());
		System.out.println(temperaturaFF.text());
		
	}
}
