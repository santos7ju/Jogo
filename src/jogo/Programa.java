package jogo;

public class Programa {
	static private long t_max;

	public static void main(String args[]) {
		Jogo jogo = new Jogo();
		Boolean emAndamento = true;
		PartidaSingleton partida = null;

		while (emAndamento == true) {
			System.out.println("\n------------------------------\nExecute uma acao:\n");
			System.out.println("-> iniciar\n-> sair\n");
			System.out.println("\n------------------------------\n");
			String opcao = Console.readLine();
			if (opcao.compareTo("sair") == 0) {
				break;
			}
			if (opcao.compareTo("iniciar") == 0) {
				partida = PartidaSingleton.instance();
				jogo.manipuladorClasses(opcao);
			}
		}

	}

}
