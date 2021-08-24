package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaBasquete;

public class Basquete extends Esporte {
	private ArrayList<PartidaBasquete> partidas;

	public ArrayList<PartidaBasquete> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaBasquete> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaBasquete partida) {
		partidas.add(partida);
	}
}
