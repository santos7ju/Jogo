package command;

import jogo.LabirintoSingleton;

public class VerMapaCommand implements Command {

	public void execute(Object[] obj) {

		LabirintoSingleton labirinto;
		labirinto = (LabirintoSingleton) obj[2];
		String mapa = labirinto.imprimir();
		System.out.println(mapa);
	}

}
