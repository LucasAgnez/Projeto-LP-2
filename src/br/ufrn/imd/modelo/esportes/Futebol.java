package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaFutebol;

public class Futebol extends Esporte {
	private ArrayList<PartidaFutebol> partidas;

	public Futebol() {
		this.partidas = new ArrayList<PartidaFutebol>();
		this.nome = "Futebol";
	}
	
	public ArrayList<PartidaFutebol> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaFutebol> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaFutebol partida) {
		partidas.add(partida);
	}
	
	public ArrayList<PartidaFutebol> buscarPartidasSelecao(String pais){
		ArrayList<PartidaFutebol> partidasPais = new ArrayList<PartidaFutebol>();
		for(PartidaFutebol p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
