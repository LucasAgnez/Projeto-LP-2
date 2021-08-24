package br.ufrn.imd.controle;

import java.util.HashSet;
import java.util.Set;

import br.ufrn.imd.modelo.atletas.*;

public class BancoAtletas {
	private Set<Selecao> selecoes;
	private Set<Atleta> atletasIndividuais;
	
	public BancoAtletas() {
		this.selecoes = new HashSet<Selecao>();
		this.atletasIndividuais = new HashSet<Atleta>();
	}
	
	public Set<Selecao> getSelecoes() {
		return selecoes;
	}
	
	public void setSelecoes(Set<Selecao> selecoes) {
		this.selecoes = selecoes;
	}
	
	public void addSelecao(Selecao selecao) {
		selecoes.add(selecao);
	}
	
	public Set<Atleta> getAtletasIndividuais() {
		return atletasIndividuais;
	}
	
	public void setAtletasIndividuais(Set<Atleta> atletasIndividuais) {
		this.atletasIndividuais = atletasIndividuais;
	}
	
	public void addAtleta(Atleta atleta) {
		atletasIndividuais.add(atleta);
	}

}

