package command;

import jogo.Item;
import jogo.JogadorSingleton;
import jogo.Sala;

public class PegarItemCommand implements Command {
	String tipo;

	public PegarItemCommand(String s) {
		this.tipo = s;
	}

	public void execute(Object[] obj) {

		Sala sala = JogadorSingleton.getSalaAtual();
		Boolean achouItem = false;
		if ((JogadorSingleton.getQuantItens() < 5) || this.tipo.compareTo("Diamante") == 0
				|| this.tipo.compareTo("Ouro") == 0) {
			for (Item i : sala.getItens()) {
				if (i.getTipoItem().compareTo(this.tipo) == 0) {
					achouItem = true;
					JogadorSingleton.adiconarItem(i, this.tipo);
					sala.removerItem(i, i.getTipoItem());
					break;
				}
			}
		} else {
			achouItem = true;
			System.out.println("O inventário está cheio");
		}
		if (achouItem == false)
			System.out.println("O Item nao está presente na sala");

	}

}
