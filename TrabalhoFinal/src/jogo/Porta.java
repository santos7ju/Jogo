package jogo;

import java.util.ArrayList;
import java.util.List;

public class Porta {
	private Boolean trancada;
	private Integer codigoChave;
	private List <Sala> salas = new ArrayList<Sala>();
	public void trancar() {}
	public void detsrancar() {}
	public Boolean getTrancada() {
		return trancada;
	}
	public void setTrancada(Boolean trancada) {
		this.trancada = trancada;
	}
	public Integer getCodigoChave() {
		return codigoChave;
	}
	public void setCodigoChave(Integer codigoChave) {
		this.codigoChave = codigoChave;
	}
	public List<Sala> getSalas() {
		return salas;
	}
	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
}
