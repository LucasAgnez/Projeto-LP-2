package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaTenis;

public class Tenis extends Esporte {
	private ArrayList<PartidaTenis> partidas;
	
	public Tenis() {
		this.partidas = new ArrayList<PartidaTenis>();
		this.nome = "Tênis";
	}

	public ArrayList<PartidaTenis> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaTenis> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaTenis partida) {
		partidas.add(partida);
	}
	
	public ArrayList<PartidaTenis> buscarPartidasSelecao(String pais){
		ArrayList<PartidaTenis> partidasPais = new ArrayList<PartidaTenis>();
		for(PartidaTenis p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
