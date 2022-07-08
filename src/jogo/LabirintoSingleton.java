package jogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LabirintoSingleton {

	private static LabirintoSingleton labirinto;
	private static List<Sala> conjuntoSalas = new ArrayList<Sala>();

	private LabirintoSingleton() {
	}

	public synchronized static LabirintoSingleton instance() {
		if (labirinto == null) {
			labirinto = new LabirintoSingleton();

		}
		return labirinto;
	}

	public static void criarLabirinto(JSONObject data) {
		System.out.println("Criando Labirinto");
		lerArquivo(data);
		ChaveA a = new ChaveA();
		getConjuntoSalas().get(0).incluirChave(a);
		ChaveB b = new ChaveB();
		getConjuntoSalas().get(5).incluirChave(b);
		ChaveC c = new ChaveC();
		getConjuntoSalas().get(11).incluirChave(c);
		System.out.println("Labirinto Criado com sucesso");

	}

	public static void inserirJogador(JogadorSingleton jogador) {
		Sala sala = (LabirintoSingleton.getConjuntoSalas()).get(0);
		sala.setPresencaJogador(true);
		JogadorSingleton.setSalaAtual(sala);

	}

	public static List<Sala> getConjuntoSalas() {
		return conjuntoSalas;
	}

	public void setSalas(List<Sala> salas) {
		conjuntoSalas = salas;
	}

	public static void lerArquivo(JSONObject data) {
		JSONArray salas = (JSONArray) data.get("salas");
		for (int i = 0; i < 20; i++) {
			List<Porta> portas = new ArrayList<Porta>();
			JSONObject salaArquivo = (JSONObject) salas.get(i);
			JSONObject porta = (JSONObject) salaArquivo.get("A");
			Boolean existePortaA = (Boolean) porta.get("porta");
			PortaA pA = new PortaA();
			verifcaExistenciaPorta(existePortaA, porta, pA, portas);
			porta = (JSONObject) salaArquivo.get("B");
			Boolean existePortaB = (Boolean) porta.get("porta");
			PortaB pB = new PortaB();
			verifcaExistenciaPorta(existePortaB, porta, pB, portas);
			porta = (JSONObject) salaArquivo.get("C");
			Boolean existePortaC = (Boolean) porta.get("porta");
			PortaC pC = new PortaC();
			verifcaExistenciaPorta(existePortaC, porta, pC, portas);
			Long indiceSala = (Long) salaArquivo.get("indice");
			Boolean entrada = (Boolean) salaArquivo.get("entrada");
			Boolean saida = (Boolean) salaArquivo.get("saida");
			Sala novaSala = new Sala();
			novaSala.construirSala(indiceSala, entrada, saida, portas);
			conjuntoSalas.add(novaSala);

		}
	}

	public static List<Porta> verifcaExistenciaPorta(Boolean existencia, JSONObject p, Porta porta, List<Porta> portas) {
		if (existencia == true) {
			Long salaVizinha = null;
			String portaVizinha = null;
			if (Programa.tipoArquivo.compareTo("xml") == 0) {
				if (p.get("salaVizinha").toString().compareTo("") != 0)
					salaVizinha = (Long) p.get("salaVizinha");
				if (p.get("portaVizinha").toString().compareTo("") != 0)
					portaVizinha = (String) p.get("portaVizinha");
			} else {
				salaVizinha = (Long) p.get("salaVizinha");
				portaVizinha = (String) p.get("portaVizinha");

			}
			porta.setPortaVizinha(portaVizinha);
			porta.setSalaVizinha(salaVizinha);
			portas.add(porta);
		}
		return portas;

	}

	public static String imprimir() {
		String s = "";
		for (Sala sl : getConjuntoSalas()) {
			s += sl.imprimir();
		}
		return s;
	}

	public static void delete() {
		LabirintoSingleton.getConjuntoSalas().clear();
		labirinto = null;
	}

}
