package jogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Programa {

	static Instant t_inicio;

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		Boolean emAndamento = true;
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser
				.parse(new FileReader("C:\\Users\\santo\\eclipse-workspace\\Adventure\\src\\jogo\\mapa.json"));
		JSONObject ob = new JSONObject(json);
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
