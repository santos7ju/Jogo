package jogo;

import java.util.ArrayList;
import java.util.List;

public class LabirintoSingleton {
	
private static LabirintoSingleton labirinto;
private static List <Sala> salas = new ArrayList<Sala>();
private JogadorSingleton jogador;

	
	private LabirintoSingleton() {
	}
	
	public synchronized static LabirintoSingleton instance() {
		if (labirinto == null) {
			labirinto = new LabirintoSingleton();

		}
		return labirinto;
	}
	public  void criarLabirinto() {
		
	}
	public void inserirJogador(JogadorSingleton jogador) {
		this.jogador=jogador;
		
	}

	public static List <Sala> getSalas() {
		return salas;
	}

	public static void setSalas(List <Sala> salas) {
		LabirintoSingleton.salas = salas;
	}

}
