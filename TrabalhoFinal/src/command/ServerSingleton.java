package command;

import java.util.HashMap;
import java.util.Map;

public class ServerSingleton {
	private static ServerSingleton service;

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
		comandos.put("arremessarMachado", new ArremessarMachadoCommand());
		comandos.put("bloquearPorta", new BloquearPortaCommand());
		comandos.put("iniciarPartida", new IniciarPartidaCommand());
		comandos.put("pegarItem", new PegarItemCommand());
		comandos.put("largarItem", new LargarItemCommand());
		comandos.put("moverJogador", new MoverJogadorCommand());
		comandos.put("moverTroll", new MoverTrollCommand());
		comandos.put("removerItem", new RemoverItemCommand());
		comandos.put("abrirPorta", new AbrirPortaCommand());
		comandos.put("finalizarPartida", new FinalizarPartidaCommand());

	}

	public void comando(String acao, Object[] data) {
		Command c = comandos.get(acao);
		c.execute(data);
	}

}
