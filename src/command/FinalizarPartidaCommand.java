package command;

import java.util.List;

import jogo.JogadorSingleton;
import jogo.LabirintoSingleton;
import jogo.PartidaSingleton;

public class FinalizarPartidaCommand implements Command {

	@Override
	public void execute(Object[] data) {
		PartidaSingleton.fimPartida();
		;
		JogadorSingleton.delete();
		LabirintoSingleton.delete();

	}

}
