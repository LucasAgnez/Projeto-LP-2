package br.ufrn.imd.modelo.esportes;

import java.util.HashSet;

import br.ufrn.imd.modelo.partidas.PartidaFutebol;

public class Futebol extends Esporte {
	private HashSet<PartidaFutebol> partidas;

	public Futebol() {
		this.partidas = new HashSet<PartidaFutebol>();
		this.nome = "Futebol";
	}
	
	public HashSet<PartidaFutebol> getPartidas() {
		return partidas;
	}

	public void setPartidas(HashSet<PartidaFutebol> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaFutebol partida) {
		partidas.add(partida);
	}
	
	public HashSet<PartidaFutebol> buscarPartidasSelecao(String pais){
		HashSet<PartidaFutebol> partidasPais = new HashSet<PartidaFutebol>();
		for(PartidaFutebol p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
