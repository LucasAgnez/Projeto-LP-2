package imd.modelo;

import java.util.ArrayList;

public class Selecao {
	private String pais;
	private Esporte esporte;
	private ArrayList<AtletaColetivo> time;
	
	public Selecao(String pais, Esporte esporte) {
		this.pais = pais;
		this.esporte = esporte;
		time = new ArrayList<AtletaColetivo>();
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ArrayList<AtletaColetivo> getTime() {
		return time;
	}
	public void setTime(ArrayList<AtletaColetivo> time) {
		this.time = time;
	}
	public void addAtleta(AtletaColetivo atleta) {
		time.add(atleta);
	}
	public Esporte getEsporte() {
		return esporte;
	}
	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}
	
}
