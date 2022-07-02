package jogo;

import command.ComandoInvalido;
import command.ServerSingleton;

public class Jogo {
	ServerSingleton server = new ServerSingleton();
	private static Object[] data = new Object[10];

	public void manipuladorClasses(String acao) {

		while (PartidaSingleton.getPartidaEmAndamento() == true) {
			try {
				server.service(acao, data);
				if (PartidaSingleton.getPartidaEmAndamento() == false)
					break;
			} catch (ComandoInvalido e) {
				System.out.println("\nErro: Comando Inválido.");
			}

			System.out.println("\n------------------------------\nExecute uma acao:\n");
			System.out.println("-> mapa\n-> sala\n-> abrir(porta)\n-> pegar(item)" + "\n-> inventario\n-> fim");
			System.out.println("\n------------------------------\n");
			System.out.println(
					"OBS.:\n   porta = A ou B ou C \n   item = Machado ou Pocao ou Ouro ou Diamante ou Chave\n ");

			acao = Console.readLine();

		}
	}

}
