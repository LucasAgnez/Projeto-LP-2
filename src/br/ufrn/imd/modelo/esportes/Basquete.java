package br.ufrn.imd.modelo.esportes;

import java.util.ArrayList;

import br.ufrn.imd.modelo.partidas.PartidaBasquete;

public class Basquete extends Esporte {
	private ArrayList<PartidaBasquete> partidas;
	
	public Basquete() {
		this.partidas = new ArrayList<PartidaBasquete>();
	}
	
	public ArrayList<PartidaBasquete> getPartida() {
		return partidas;
	}

	public void setPartida(ArrayList<PartidaBasquete> partidas) {
		this.partidas = partidas;
	}
	
	public void addPartida(PartidaBasquete partida) {
		partidas.add(partida);
	}
	
	public ArrayList<PartidaBasquete> buscarPartidasSelecao(String pais){
		ArrayList<PartidaBasquete> partidasPais = new ArrayList<PartidaBasquete>();
		for(PartidaBasquete p : partidas) {
			if(p.getParticipante1().getPais().equalsIgnoreCase(pais) || 
			p.getParticipante2().getPais().equalsIgnoreCase(pais)) {
				partidasPais.add(p);
			}
		}
		return partidasPais;
	}
}
