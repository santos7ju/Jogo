package jogo;

import java.util.ArrayList;
import java.util.List;

public class Sala {
	private Integer codSala;
	private List<Machado> machados = new ArrayList<Machado>();
	private List<PocaoMagica> pocoes = new ArrayList<PocaoMagica>();
	private List<Ouro> ouros = new ArrayList<Ouro>();
	private List<Diamante> diamantes = new ArrayList<Diamante>();
	private List<Chave> chaves = new ArrayList<Chave>();
	private List<Troll> trolls = new ArrayList<Troll>();
	private Boolean presencaJogador;

	public void visualizarPortas() {
	}

	public void visualizarElementos() {
	}

	public void construirSala() {

	}

	public void incluirPorta(Porta porta) {
	}

	public Integer quantidadeElementos() {
		return machados.size() + pocoes.size() + chaves.size();
	}

	public void incluirItem(Item x) {
	}

	public void removerItem(Item x) {
	}

	public void incluirOuro(Ouro x) {
	}

	public void removerOuro(Ouro x) {
	}

	public void incluirDiamante(Diamante x) {
	}

	public void removerDiamante(Diamante x) {
	}

	public void incluirTroll(Troll x) {
	}

	public void removerTroll(Troll x) {
	}

	public Integer getCodSala() {
		return codSala;
	}

	public void setCodSala(Integer codSala) {
		this.codSala = codSala;
	}

	public List<Machado> getMachados() {
		return machados;
	}

	public void setMachados(List<Machado> machados) {
		this.machados = machados;
	}

	public List<PocaoMagica> getPocoes() {
		return pocoes;
	}

	public void setPocoes(List<PocaoMagica> pocoes) {
		this.pocoes = pocoes;
	}

	public List<Ouro> getOuros() {
		return ouros;
	}

	public void setOuros(List<Ouro> ouros) {
		this.ouros = ouros;
	}

	public List<Diamante> getDiamantes() {
		return diamantes;
	}

	public void setDiamantes(List<Diamante> diamantes) {
		this.diamantes = diamantes;
	}

	public List<Chave> getChaves() {
		return chaves;
	}

	public void setChaves(List<Chave> chaves) {
		this.chaves = chaves;
	}

	public List<Troll> getTrolls() {
		return trolls;
	}

	public void setTrolls(List<Troll> trolls) {
		this.trolls = trolls;
	}

	public Boolean getPresencaJogador() {
		return presencaJogador;
	}

	public void setPresencaJogador(Boolean presencaJogador) {
		this.presencaJogador = presencaJogador;
	}

}
