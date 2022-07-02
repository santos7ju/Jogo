package command;

import java.util.ArrayList;
import java.util.List;

import jogo.JogadorSingleton;
import jogo.LabirintoSingleton;
import jogo.Sala;

public class MoverJogadorCommand implements Command {
	private List<Sala> labirinto = new ArrayList<Sala>();

	public void execute(Object[] data) {
		JogadorSingleton jogador = (JogadorSingleton) data[1];
		Sala salaAtual = jogador.getSalaAtual();
		Sala novaSala = (Sala) data[3];
		labirinto = LabirintoSingleton.getSalas();
		salaAtual.setPresencaJogador(false);
		jogador.setSalaAtual(novaSala);
		labirinto.get(novaSala.getCodSala()).setPresencaJogador(true);

	}

	@Override
	public void execute(List<Object> obj) {
		// TODO Auto-generated method stub

	}

}
