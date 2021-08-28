package br.ufrn.imd.modelo.partidas;

import br.ufrn.imd.modelo.atletas.Selecao;

public class PartidaVolei extends Partida{
	private int setsParticipante1;
	private int setsParticipante2;
	private int pontosSet1Parti1;
	private int pontosSet1Parti2;
	private int pontosSet2Parti1;
	private int pontosSet2Parti2;
	private int pontosSet3Parti1;
	private int pontosSet3Parti2;
	private int pontosSet4Parti1;
	private int pontosSet4Parti2;
	private int pontosSet5Parti1;
	private int pontosSet5Parti2;
	
	
	public PartidaVolei(Selecao participante1, Selecao participante2) {
		super(participante1, participante2);
		setsParticipante1 = 0;
		setsParticipante2 = 0;
	}

	public int getSetsParticipante1() {
		return setsParticipante1;
	}
	public void setSetsParticipante1(int setsParticipante1) {
		this.setsParticipante1 = setsParticipante1;
	}

	public int getSetsParticipante2() {
		return setsParticipante2;
	}
	public void setSetsParticipante2(int setsParticipante2) {
		this.setsParticipante2 = setsParticipante2;
	}

	public int getPontosSet1Parti1() {
		return pontosSet1Parti1;
	}
	public void setPontosSet1Parti1(int pontosSet1Parti1) {
		this.pontosSet1Parti1 = pontosSet1Parti1;
	}

	public int getPontosSet1Parti2() {
		return pontosSet1Parti2;
	}
	public void setPontosSet1Parti2(int pontosSet1Parti2) {
		this.pontosSet1Parti2 = pontosSet1Parti2;
	}

	public int getPontosSet2Parti1() {
		return pontosSet2Parti1;
	}
	public void setPontosSet2Parti1(int pontosSet2Parti1) {
		this.pontosSet2Parti1 = pontosSet2Parti1;
	}

	public int getPontosSet2Parti2() {
		return pontosSet2Parti2;
	}
	public void setPontosSet2Parti2(int pontosSet2Parti2) {
		this.pontosSet2Parti2 = pontosSet2Parti2;
	}

	public int getPontosSet3Parti1() {
		return pontosSet3Parti1;
	}
	public void setPontosSet3Parti1(int pontosSet3Parti1) {
		this.pontosSet3Parti1 = pontosSet3Parti1;
	}

	public int getPontosSet3Parti2() {
		return pontosSet3Parti2;
	}
	public void setPontosSet3Parti2(int pontosSet3Parti2) {
		this.pontosSet3Parti2 = pontosSet3Parti2;
	}

	public int getPontosSet4Parti1() {
		return pontosSet4Parti1;
	}
	public void setPontosSet4Parti1(int pontosSet4Parti1) {
		this.pontosSet4Parti1 = pontosSet4Parti1;
	}

	public int getPontosSet4Parti2() {
		return pontosSet4Parti2;
	}
	public void setPontosSet4Parti2(int pontosSet4Parti2) {
		this.pontosSet4Parti2 = pontosSet4Parti2;
	}

	public int getPontosSet5Parti1() {
		return pontosSet5Parti1;
	}
	public void setPontosSet5Parti1(int pontosSet5Parti1) {
		this.pontosSet5Parti1 = pontosSet5Parti1;
	}

	public int getPontosSet5Parti2() {
		return pontosSet5Parti2;
	}
	public void setPontosSet5Parti2(int pontosSet5Parti2) {
		this.pontosSet5Parti2 = pontosSet5Parti2;
	}

}
