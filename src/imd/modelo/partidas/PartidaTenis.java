package imd.modelo.partidas;

import imd.modelo.atletas.Selecao;

public class PartidaTenis extends Partida {

	private int setsParticipante1;
	private int setsParticipante2;
	private SetTenis primeiroSet;
	private SetTenis segundoSet;
	private SetTenis terceiroSet;
	private SetTenis quartoSet;
	private SetTenis tieBreak;
	public PartidaTenis(Selecao participante1, Selecao participante2) {
		super(participante1, participante2);
		primeiroSet = new SetTenis();
		segundoSet = new SetTenis();
		terceiroSet = new SetTenis();
		quartoSet = new SetTenis();
		tieBreak = new SetTenis();
		setsParticipante1 = 0;
		setsParticipante2 = 0;
	}
	
	public int getSetsParticipante1() {
		return setsParticipante1;
	}
	public int getSetsParticipante2() {
		return setsParticipante2;
	}
	public SetTenis getPrimeroSet() {
		return primeiroSet;
	}
	public void setPrimeroSet(SetTenis primeroSet) {
		if(primeiroSet.getGamesParticipante1() > primeiroSet.getGamesParticipante2()) {
			setsParticipante1++;
		}
		else if(primeiroSet.getGamesParticipante1()  < primeiroSet.getGamesParticipante2()) {
			setsParticipante2++;
		}
		this.primeiroSet = primeroSet;
	}
	public SetTenis getSegundoSet() {
		return segundoSet;
	}
	public void setSegundoSet(SetTenis segundoSet) {
		if(segundoSet.getGamesParticipante1() > segundoSet.getGamesParticipante2()) {
			setsParticipante1++;
		}
		else if(segundoSet.getGamesParticipante1()  < segundoSet.getGamesParticipante2()) {
			setsParticipante2++;
		}
		this.segundoSet = segundoSet;
	}
	public SetTenis getTerceiroSet() {
		return terceiroSet;
	}
	public void setTerceiroSet(SetTenis terceiroSet) {
		if(terceiroSet.getGamesParticipante1() > terceiroSet.getGamesParticipante2()) {
			setsParticipante1++;
		}
		else if(terceiroSet.getGamesParticipante1()  < terceiroSet.getGamesParticipante2()) {
			setsParticipante2++;
		}
		this.terceiroSet = terceiroSet;
	}
	public SetTenis getQuartoSet() {
		return quartoSet;
	}
	public void setQuartoSet(SetTenis quartoSet) {
		if(quartoSet.getGamesParticipante1() > quartoSet.getGamesParticipante2()) {
			setsParticipante1++;
		}
		else if(quartoSet.getGamesParticipante1()  < quartoSet.getGamesParticipante2()) {
			setsParticipante2++;
		}
		this.quartoSet = quartoSet;
	}
	public SetTenis getTieBreak() {
		return tieBreak;
	}
	public void setTieBreak(SetTenis tieBreak) {
		if(tieBreak.getGamesParticipante1() > tieBreak.getGamesParticipante2()) {
			setsParticipante1++;
		}
		else if(tieBreak.getGamesParticipante1()  < tieBreak.getGamesParticipante2()) {
			setsParticipante2++;
		}
		this.tieBreak = tieBreak;
	}	
}
