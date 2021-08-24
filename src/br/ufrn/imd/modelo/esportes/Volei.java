package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaVolei;

public class Volei extends Esporte {
	private ArrayList<PartidaVolei> partidas;

	public ArrayList<PartidaVolei> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaVolei> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaVolei partida) {
		partidas.add(partida);
	}
}
