package br.ufrn.imd.modelo.atletas;

import java.util.ArrayList;

public class Selecao {
	private String pais;
	private String esporte;
	private ArrayList<Atleta> time;
	
	public Selecao(String pais, String esporte) {
		this.pais = pais;
		this.esporte = esporte;
		time = new ArrayList<Atleta>();
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ArrayList<Atleta> getTime() {
		return time;
	}
	public void setTime(ArrayList<Atleta> time) {
		this.time = time;
	}
	public void addAtleta(Atleta atleta) {
		time.add(atleta);
	}
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	
}
