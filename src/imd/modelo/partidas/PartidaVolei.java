package imd.modelo.partidas;

import imd.modelo.atletas.Selecao;

public class PartidaVolei extends Partida{
	private int setsParticipante1;
	private int setsParticipante2;
	private SetVolei primeiroSet;
	private SetVolei segundoSet;
	private SetVolei terceiroSet;
	private SetVolei quartoSet;
	private SetVolei tieBreak;
	
	public PartidaVolei(Selecao participante1, Selecao participante2) {
		super(participante1, participante2);
		primeiroSet = new SetVolei();
		segundoSet = new SetVolei();
		terceiroSet = new SetVolei();
		quartoSet = new SetVolei();
		tieBreak = new SetVolei();
		setsParticipante1 = 0;
		setsParticipante2 = 0;
	}
	
	public int getSetsParticipante1() {
		return setsParticipante1;
	}
	public int getSetsParticipante2() {
		return setsParticipante2;
	}
	public SetVolei getPrimeroSet() {
		return primeiroSet;
	}
	public void setPrimeroSet(SetVolei primeroSet) {
		if(primeiroSet.getPontosParticipante1() > primeiroSet.getPontosParticipante2()) {
			setsParticipante1++;
		}
		else if(primeiroSet.getPontosParticipante1()  < primeiroSet.getPontosParticipante2()) {
			setsParticipante2++;
		}
		this.primeiroSet = primeroSet;
	}
	public SetVolei getSegundoSet() {
		return segundoSet;
	}
	public void setSegundoSet(SetVolei segundoSet) {
		if(segundoSet.getPontosParticipante1() > segundoSet.getPontosParticipante2()) {
			setsParticipante1++;
		}
		else if(segundoSet.getPontosParticipante1()  < segundoSet.getPontosParticipante2()) {
			setsParticipante2++;
		}
		this.segundoSet = segundoSet;
	}
	public SetVolei getTerceiroSet() {
		return terceiroSet;
	}
	public void setTerceiroSet(SetVolei terceiroSet) {
		if(terceiroSet.getPontosParticipante1() > terceiroSet.getPontosParticipante2()) {
			setsParticipante1++;
		}
		else if(terceiroSet.getPontosParticipante1()  < terceiroSet.getPontosParticipante2()) {
			setsParticipante2++;
		}
		this.terceiroSet = terceiroSet;
	}
	public SetVolei getQuartoSet() {
		return quartoSet;
	}
	public void setQuartoSet(SetVolei quartoSet) {
		if(quartoSet.getPontosParticipante1() > quartoSet.getPontosParticipante2()) {
			setsParticipante1++;
		}
		else if(quartoSet.getPontosParticipante1()  < quartoSet.getPontosParticipante2()) {
			setsParticipante2++;
		}
		this.quartoSet = quartoSet;
	}
	public SetVolei getTieBreak() {
		return tieBreak;
	}
	public void setTieBreak(SetVolei tieBreak) {
		if(tieBreak.getPontosParticipante1() > tieBreak.getPontosParticipante2()) {
			setsParticipante1++;
		}
		else if(tieBreak.getPontosParticipante1()  < tieBreak.getPontosParticipante2()) {
			setsParticipante2++;
		}
		this.tieBreak = tieBreak;
	}	

}
