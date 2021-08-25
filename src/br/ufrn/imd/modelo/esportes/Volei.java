package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaVolei;

public class Volei extends Esporte {
	private ArrayList<PartidaVolei> partidas;
	
	public Volei() {
		this.partidas = new ArrayList<PartidaVolei>();
		this.nome = "Vôlei";
	}
	
	public ArrayList<PartidaVolei> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaVolei> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaVolei partida) {
		partidas.add(partida);
	}
	
	public ArrayList<PartidaVolei> buscarPartidasSelecao(String pais){
		ArrayList<PartidaVolei> partidasPais = new ArrayList<PartidaVolei>();
		for(PartidaVolei p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
