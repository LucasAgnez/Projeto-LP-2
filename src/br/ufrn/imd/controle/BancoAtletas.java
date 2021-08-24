package br.ufrn.imd.controle;

import java.util.ArrayList;
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
	
	public ArrayList<Atleta>  buscarAtleta(String nome) {
		ArrayList<Atleta> atls = new ArrayList<Atleta>();
		for(Atleta a : atletasIndividuais) {
			if(a.getNome().equalsIgnoreCase(nome)) {
				atls.add(a);
			}
		}
		for(Selecao s : selecoes) {
			for(Atleta a : s.getTime()) {
				if(a.getNome().equalsIgnoreCase(nome)) {
					atls.add(a);
				}
			}
		}
		return atls;
	}
	
	public Selecao buscarSelecao(String nome) {
		for(Selecao s : selecoes) {
			if(nome.equalsIgnoreCase(s.getPais())) {
				return s;
			}
		}
		System.out.println("selecao nao encontrada");
		return null;
	}

}

