package imd.modelo;

import java.util.ArrayList;

public abstract class Esporte {
	private String nome;
	private ArrayList<Partida> partida;
	private String genero;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Partida> getPartida() {
		return partida;
	}
	public void setPartida(ArrayList<Partida> partida) {
		this.partida = partida;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public abstract void addPartida();
}
