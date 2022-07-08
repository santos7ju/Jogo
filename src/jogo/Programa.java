package jogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.commons.io.FilenameUtils;
import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Programa {
	public static String tipoArquivo = null;

	static Instant t_inicio;

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException,
			ParserConfigurationException, SAXException, TransformerException {
		JSONParser parser = new JSONParser();
		String endereco = "C:\\Users\\santo\\eclipse-workspace\\Adventure\\src\\jogo\\mapa.json";
		String extensaoDoArquivo = FilenameUtils.getExtension(endereco);
		JSONObject json = null;
		JSONObject ob = null;
		if (extensaoDoArquivo.compareTo("xml") == 0) {
			FileReader fr = new FileReader(endereco);
			int i;
			String xmlString = "";
			while ((i = fr.read()) != -1) {
				xmlString += (char) i;
			}
			fr.close();
			org.json.JSONObject j = XML.toJSONObject(xmlString);
			String k = "";
			k += j;
			json = (JSONObject) parser.parse(k);
			ob = new JSONObject(json);
			ob = (JSONObject) ob.get("root");
			tipoArquivo = "xml";
		} else {
			json = (JSONObject) parser.parse(new FileReader(endereco));
			ob = new JSONObject(json);
			tipoArquivo = "json";
		}
		Boolean emAndamento = true;
		while (emAndamento == true) {
			System.out.println("\n------------------------------\nExecute uma acao:\n");
			System.out.println("-> iniciar\n-> sair\n");
			System.out.println("\n------------------------------\n");
			String opcao = Console.readLine();
			if (opcao.compareTo("sair") == 0) {
				break;
			}
			if (opcao.compareTo("iniciar") == 0) {
				PartidaSingleton.instance();
				Jogo.instance("iniciar", ob);
			}
		}
	}
}
