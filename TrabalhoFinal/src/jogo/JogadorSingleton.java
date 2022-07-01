package jogo;

import java.util.ArrayList;
import java.util.List;

public class JogadorSingleton {

	private static JogadorSingleton jogador;
	private Sala salaAtual;
	private List<Item> itens = new ArrayList<Item>();
	private List<Diamante> diamantes = new ArrayList<Diamante>();
	private List<Ouro> ouros = new ArrayList<Ouro>();

	private JogadorSingleton() {

	}

	public synchronized static JogadorSingleton instance() {
		if (jogador == null) {
			jogador = new JogadorSingleton();
		}
		return jogador;
	}

	public void adiconarItem(Item item) {

	}

	public void removerItem(Item item) {

	}

	public void adiconarOuro(Ouro ouro) {

	}

	public void removerOuro(Ouro ouro) {

	}

	public void adiconarDiamante(Item diamante) {

	}

	public void removerDiamante(Diamante diamante) {

	}

	public Sala getSalaAtual() {
		return salaAtual;
	}

	public void setSalaAtual(Sala salaAtual) {
		this.salaAtual = salaAtual;
	}

		public List<Diamante> getDiamantes() {
		return diamantes;
	}

	public void setDiamantes(List<Diamante> diamantes) {
		this.diamantes = diamantes;
	}

	public List<Ouro> getOuros() {
		return ouros;
	}

	public void setOuros(List<Ouro> ouros) {
		this.ouros = ouros;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
