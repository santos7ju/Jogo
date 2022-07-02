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
	private List<Sala> conjuntoSalas = new ArrayList<Sala>();

	private LabirintoSingleton() {
	}

	public synchronized static LabirintoSingleton instance() {
		if (labirinto == null) {
			labirinto = new LabirintoSingleton();

		}
		return labirinto;
	}

	public void criarLabirinto() {
		System.out.println("Criando Labirinto");
		try {
			lerArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChaveA a = new ChaveA();
		getConjuntoSalas().get(0).incluirChave(a);
		ChaveB b = new ChaveB();
		getConjuntoSalas().get(6).incluirChave(b);
		ChaveC c = new ChaveC();
		getConjuntoSalas().get(9).incluirChave(c);
		System.out.println("Labirinto Criado com sucesso");

	}

	public void inserirJogador(JogadorSingleton jogador) {
		Sala sala = (labirinto.getConjuntoSalas()).get(0);
		sala.setPresencaJogador(true);
		jogador.setSalaAtual(sala);

	}

	public List<Sala> getConjuntoSalas() {
		return conjuntoSalas;
	}

	public void setSalas(List<Sala> salas) {
		this.conjuntoSalas = salas;
	}

	public void lerArquivo() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser
				.parse(new FileReader("\\Users\\santo\\eclipse-workspace\\TrabalhoFinal\\src\\jogo\\mapa.json"));
		JSONObject ob = new JSONObject(json);
		JSONArray salas = (JSONArray) ob.get("salas");
		for (int i = 0; i < 10; i++) {
			List<Porta> portas = new ArrayList<Porta>();
			JSONObject salaArquivo = (JSONObject) salas.get(i);
			JSONObject porta = (JSONObject) salaArquivo.get("A");
			Boolean existePortaA = (Boolean) porta.get("porta");
			PortaA pA = new PortaA();
			this.verifcaExistenciaPorta(existePortaA, porta, pA, portas);
			porta = (JSONObject) salaArquivo.get("B");
			Boolean existePortaB = (Boolean) porta.get("porta");
			PortaB pB = new PortaB();
			this.verifcaExistenciaPorta(existePortaB, porta, pB, portas);
			porta = (JSONObject) salaArquivo.get("C");
			Boolean existePortaC = (Boolean) porta.get("porta");
			PortaC pC = new PortaC();
			this.verifcaExistenciaPorta(existePortaC, porta, pC, portas);
			Long indiceSala = (Long) salaArquivo.get("indice");
			Boolean entrada = (Boolean) salaArquivo.get("entrada");
			Boolean saida = (Boolean) salaArquivo.get("saida");
			Sala novaSala = new Sala();
			novaSala.construirSala(indiceSala, entrada, saida, portas);
			conjuntoSalas.add(novaSala);

		}
	}

	public List<Porta> verifcaExistenciaPorta(Boolean existencia, JSONObject p, Porta porta, List<Porta> portas) {
		if (existencia == true) {
			Long salaVizinha = (Long) p.get("salaVizinha");
			String portaVizinha = (String) p.get("portaVizinha");
			porta.setPortaVizinha(portaVizinha);
			porta.setSalaVizinha(salaVizinha);
			portas.add(porta);
		}
		return portas;

	}

	public String imprimir() {
		String s = "";
		for (Sala sl : this.getConjuntoSalas()) {
			s += sl.imprimir();
		}
		return s;
	}

	public static void delete() {
		labirinto = null;
	}

}
