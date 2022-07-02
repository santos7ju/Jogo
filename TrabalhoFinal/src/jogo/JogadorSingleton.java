package jogo;

import java.util.ArrayList;
import java.util.List;

public class JogadorSingleton {

	private static JogadorSingleton jogador;
	private static Sala salaAtual;
	private static Integer quantItens;
	private static List<Item> itens = new ArrayList<Item>();
	private static List<Diamante> diamantes = new ArrayList<Diamante>();
	private static List<Ouro> ouros = new ArrayList<Ouro>();

	private JogadorSingleton() {
		quantItens = 0;
	}

	public synchronized static JogadorSingleton instance() {
		if (jogador == null) {
			jogador = new JogadorSingleton();
		}
		return jogador;
	}

	public static Integer getQuantItens() {
		return quantItens;
	}

	public static void adiconarItem(Item item, String tipo) {
		JogadorSingleton.itens.add(item);
		quantItens++;
		if (tipo.compareTo("Ouro") == 0) {
			quantItens--;
			adicionarOuro((Ouro) item);
		} else if (tipo.compareTo("Diamante") == 0) {
			quantItens--;
			adicionarDiamante((Diamante) item);
		}
	}

	public void removerItem(Item item) {

	}

	public static void adicionarOuro(Ouro ouro) {
		ouros.add(ouro);

	}

	public void removerOuro(Ouro ouro) {

	}

	public static void adicionarDiamante(Diamante diamante) {
		diamantes.add(diamante);
	}

	public void removerDiamante(Diamante diamante) {

	}

	public static Sala getSalaAtual() {
		return salaAtual;
	}

	public void setSalaAtual(Sala salaAtual) {
		JogadorSingleton.salaAtual = salaAtual;
	}

	public static List<Diamante> getDiamantes() {
		return diamantes;
	}

	public void setDiamantes(List<Diamante> diamantes) {
		JogadorSingleton.diamantes = diamantes;
	}

	public static List<Ouro> getOuros() {
		return ouros;
	}

	public void setOuros(List<Ouro> ouros) {
		JogadorSingleton.ouros = ouros;
	}

	public static List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public static void delete() {
		jogador = null;
	}

}
