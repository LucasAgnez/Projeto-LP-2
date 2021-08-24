package br.ufrn.imd.modelo.partidas;

public class SetVolei {
	private int pontosParticipante1;
	private int pontosParticipante2;
	
	public SetVolei(int pontosParticipante1, int pontosParticipante2) {
		super();
		this.pontosParticipante1 = pontosParticipante1;
		this.pontosParticipante2 = pontosParticipante2;
	}
	public SetVolei() {
		this.pontosParticipante1 = 0;
		this.pontosParticipante2 = 0;
	}
	public int getPontosParticipante1() {
		return pontosParticipante1;
	}
	public void setPontosParticipante1(int pontosParticipante1) {
		this.pontosParticipante1 = pontosParticipante1;
	}
	public int getPontosParticipante2() {
		return pontosParticipante2;
	}
	public void setPontosParticipante2(int pontosParticipante2) {
		this.pontosParticipante2 = pontosParticipante2;
	}
}
