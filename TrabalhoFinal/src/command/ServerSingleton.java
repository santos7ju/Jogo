package command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerSingleton {
	private static ServerSingleton service;
	private List<String> todosComando = new ArrayList<>();

	public synchronized static ServerSingleton instance() {
		if (service == null) {
			service = new ServerSingleton();
		}
		return service;
	}

	private Map<String, Command> comandos = new HashMap<>();

	public ServerSingleton() {
		criarComandos();
	}

	private void criarComandos() {

		Collections.addAll(this.todosComando, "arremessarMAchado", "mapa", "sala", "bloquearPorta",
				"iniciar", "pegar(Machado)","inventario", "pegar(Chave)", "pegar(Pocao)",
				"pegar(Ouro)","pegar(Diamante)","largarItem", "moverJogador",
				"moverTroll", "removerItem", "abrir(A)", "abrir(B)", "abrir(C)", "fim");
		comandos.put("iniciar", new IniciarPartidaCommand());
		comandos.put("mapa", new VerMapaCommand());
		comandos.put("sala", new VerSalaCommand());
		comandos.put("fim", new FinalizarPartidaCommand());
		comandos.put("abrir(A)", new AbrirPortaCommand("A"));
		comandos.put("abrir(B)", new AbrirPortaCommand("B"));
		comandos.put("abrir(C)", new AbrirPortaCommand("C"));
		comandos.put("pegar(Machado)", new PegarItemCommand("Machado"));
		comandos.put("pegar(Pocao)", new PegarItemCommand("Pocao"));
		comandos.put("pegar(Chave)", new PegarItemCommand("Chave"));
		comandos.put("pegar(Ouro)", new PegarItemCommand("Ouro"));
		comandos.put("pegar(Diamante)", new PegarItemCommand("Diamante"));
		comandos.put("inventario", new VerInventarioCommand());

		//------------ ainda não implementados-----------------------------
		comandos.put("arremessarMachado", new ArremessarMachadoCommand());
		comandos.put("bloquearPorta", new BloquearPortaCommand());
		comandos.put("largarItem", new LargarItemCommand());
		comandos.put("moverJogador", new MoverJogadorCommand());
		comandos.put("moverTroll", new MoverTrollCommand());
		comandos.put("removerItem", new RemoverItemCommand());

	}

	public void service(String comando, Object[] objects) throws ComandoInvalido {
		if (this.todosComando.contains(comando) == false) {
			throw new ComandoInvalido();
		}
		Command c = comandos.get(comando);
		c.execute(objects);
	}

}
