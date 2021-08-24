package imd.modelo.esportes;

import java.util.ArrayList;

import imd.modelo.partidas.PartidaFutebol;

public class Futebol extends Esporte {
	private ArrayList<PartidaFutebol> partidas;

	public ArrayList<PartidaFutebol> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaFutebol> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaFutebol partida) {
		partidas.add(partida);
	}
}
