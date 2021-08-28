package br.ufrn.imd.modelo.atletas;

import java.util.HashSet;

import br.ufrn.imd.modelo.esportes.Esporte;

public class Selecao {
	private int ID;
	private Esporte esporte;
	private String pais;
	private HashSet<Atleta> time;

	
	
	
	public Selecao() {}
	
	public Selecao(String pais, String esporte) {
		this.pais = pais;
		time = new HashSet<Atleta>();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public Esporte getEsporte() {
		return esporte;
	}
	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public HashSet<Atleta> getTime() {
		return time;
	}
	public void setTime(HashSet<Atleta> time) {
		this.time = time;
	}
	public void addAtleta(Atleta atleta) {
		time.add(atleta);
	}
	
}
