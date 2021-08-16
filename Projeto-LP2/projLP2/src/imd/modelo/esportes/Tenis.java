package imd.modelo.esportes;

import java.util.ArrayList;

import imd.modelo.partidas.PartidaTenis;

public class Tenis extends Esporte {
	private ArrayList<PartidaTenis> partidas;

	public ArrayList<PartidaTenis> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaTenis> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaTenis partida) {
		partidas.add(partida);
	}
}
