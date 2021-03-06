package br.ufrn.imd.modelo.partidas;

import java.util.Date;

import br.ufrn.imd.modelo.atletas.Selecao;

public abstract class Partida {
	protected Selecao participante1;
	protected Selecao participante2;
	protected Selecao vencedor;
	protected String descricao;
	protected Date data;

	public Partida() {}
	
	public Partida(Selecao participante1, Selecao participante2) {
		super();
		this.participante1 = participante1;
		this.participante2 = participante2;
	}
	
	public Selecao getParticipante1() {
		return participante1;
	}
	public void setParticipante1(Selecao participante1) {
		this.participante1 = participante1;
	}
	public Selecao getParticipante2() {
		return participante2;
	}
	public void setParticipante2(Selecao participante2) {
		this.participante2 = participante2;
	}
	public Selecao getVencedor() {
		return vencedor;
	}
	public void setVencedor(Selecao vencedor) {
		this.vencedor = vencedor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
