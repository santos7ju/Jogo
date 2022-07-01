package jogo;


public class PartidaSingleton {
private static PartidaSingleton partida;
private Boolean partidaEmAndamento;
	
	private PartidaSingleton() {
		this.setPartidaEmAndamento(true);
	}
	
	public synchronized static PartidaSingleton instance() {
		if (partida == null) {
			partida= new PartidaSingleton();
			
			
		}
		return partida;
	}
	public void fimPartida() {}

	public Boolean getPartidaEmAndamento() {
		return partidaEmAndamento;
	}

	public void setPartidaEmAndamento(Boolean partidaEmAndamento) {
		this.partidaEmAndamento = partidaEmAndamento;
	}
	

}
