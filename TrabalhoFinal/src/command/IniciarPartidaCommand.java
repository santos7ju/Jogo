package command;

import jogo.JogadorSingleton;
import jogo.LabirintoSingleton;
import jogo.PartidaSingleton;

public class IniciarPartidaCommand implements Command {

	public void execute(Object[] data) {
		
		data[0]= PartidaSingleton.instance();
		data[1]= JogadorSingleton.instance();
		data[2] = LabirintoSingleton.instance();
		((LabirintoSingleton) data[2]).criarLabirinto();
		((LabirintoSingleton) data[2]).inserirJogador((JogadorSingleton)data[1]);
	}

}
