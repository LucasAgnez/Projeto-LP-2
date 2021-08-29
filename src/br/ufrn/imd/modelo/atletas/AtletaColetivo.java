package br.ufrn.imd.modelo.atletas;

import java.util.Date;

public class AtletaColetivo extends Atleta {
	private String posicao;
	private Selecao selecao;
	
	public AtletaColetivo() {}
	
	public AtletaColetivo(Date dataNascimento, String nome, int altura, double peso, 
			 String posicao, Selecao selecao, String nacionalidade) {
		super(dataNascimento, nome, altura, peso, nacionalidade);
		this.posicao = posicao;
		this.selecao = selecao;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	

}
