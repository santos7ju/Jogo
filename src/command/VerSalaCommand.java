package command;

import jogo.JogadorSingleton;

public class VerSalaCommand implements Command {

	@Override
	public void execute(Object[] obj) {
		JogadorSingleton jogador = (JogadorSingleton) obj[1];
		System.out.println(jogador.getSalaAtual().imprimir());
	}

}
