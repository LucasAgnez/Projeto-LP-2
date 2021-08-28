package br.ufrn.imd.modelo.esportes;

import java.util.HashSet;

import br.ufrn.imd.modelo.partidas.PartidaBasquete;

public class Basquete extends Esporte {
	private HashSet<PartidaBasquete> partidas;
	

	public Basquete() {
		this.partidas = new HashSet<PartidaBasquete>();
		this.nome = "Basquete";
	}
	
	public HashSet<PartidaBasquete> getPartidas() {
		return partidas;
	}

	public void setPartidas(HashSet<PartidaBasquete> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaBasquete partida) {
		partidas.add(partida);
	}
	
	public HashSet<PartidaBasquete> buscarPartidasSelecao(String pais){
		HashSet<PartidaBasquete> partidasPais = new HashSet<PartidaBasquete>();
		for(PartidaBasquete p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
