package jogo;

import command.ServerSingleton;

public class Jogo {
	private static Object[] objects = new Object[5];
	private static ServerSingleton service = ServerSingleton.instance();
	private static PartidaSingleton partida = null;
	private static LabirintoSingleton labirinto=null;
	private static JogadorSingleton jogador=null;
	private static Sala sala=null;
	private static Item item=null;

	
	


	

	public void manipuladorClasses(String acao) {
		
		
		objects[0]=partida;
		objects[1]=jogador;
		objects[2]= labirinto;
		objects[3]= sala;
		objects[4]=item;
		
		service.comando(acao, objects);
		if("arremessarMachado"== acao) {}
		else if("bloquearPorta"== acao) {}
		else if("moverJogador"== acao) {}
		else if("moverTroll"== acao) {}
		else if("pegarItem"== acao) {}
		else if("largarItem"== acao) {}
		else if("removerItem"== acao) {}
		else if("finalizarPartida"== acao) {}
	}

}
