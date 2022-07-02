package command;

import java.util.ArrayList;
import java.util.List;

import jogo.Chave;
import jogo.Item;
import jogo.JogadorSingleton;
import jogo.Porta;

public class AbrirPortaCommand implements Command {
	String tipo;

	public AbrirPortaCommand(String s) {
		tipo = s;
	}

	public void execute(Object[] obj) {
		Boolean abriu = false;
		for (Porta p : (List<Porta>) JogadorSingleton.getSalaAtual().getPortas()) {
			if (p.getTipo().compareTo(tipo) == 0) {
				if (p.getTrancada() == false) {
					System.out.println("Sala já está aberta");
					abriu = true;
					break;
				} else {
					for (Item i : JogadorSingleton.getItens()) {
						if (i.getTipo().compareTo(tipo) == 0) {
							p.detrancar();
							System.out.println("Porta destrancada com sucesso " + p.getTipo());
							abriu = true;
							break;
						}
					}
				}
			}
		}
		if (abriu == false)
			System.out.println("Não foi possivel abrir a porta");
	}
}
