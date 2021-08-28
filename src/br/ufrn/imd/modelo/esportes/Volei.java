package br.ufrn.imd.modelo.esportes;

import java.util.HashSet;

import br.ufrn.imd.modelo.partidas.PartidaVolei;

public class Volei extends Esporte {
	private HashSet<PartidaVolei> partidas;
	
	public Volei() {
		this.partidas = new HashSet<PartidaVolei>();
		this.nome = "Vôlei";
	}
	
	public HashSet<PartidaVolei> getPartidas() {
		return partidas;
	}

	public void setPartidas(HashSet<PartidaVolei> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaVolei partida) {
		partidas.add(partida);
	}
	
	public HashSet<PartidaVolei> buscarPartidasSelecao(String pais){
		HashSet<PartidaVolei> partidasPais = new HashSet<PartidaVolei>();
		for(PartidaVolei p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
