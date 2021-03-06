package br.ufrn.imd.modelo.partidas;

import br.ufrn.imd.modelo.atletas.Selecao;

public class PartidaFutebol extends Partida {
	private int placarParticipante1;
	private int placarParticipante2;
	

	public PartidaFutebol() {}
	
	public PartidaFutebol(Selecao participante1, Selecao participante2, int placarParticipante1,
			int placarParticipante2) {
		super(participante1, participante2);
		this.placarParticipante1 = placarParticipante1;
		this.placarParticipante2 = placarParticipante2;
	}

	public int getPlacarParticipante1() {
		return placarParticipante1;
	}
	public void setPlacarParticipante1(int placarParticipante1) {
		this.placarParticipante1 = placarParticipante1;
	}
	public int getPlacarParticipante2() {
		return placarParticipante2;
	}
	public void setPlacarParticipante2(int placarParticipante2) {
		this.placarParticipante2 = placarParticipante2;
	}
	
	public void calculaVencedor() {
		if(placarParticipante1 > placarParticipante2) {
			this.vencedor = this.participante1;
		}
		else {
			this.vencedor = this.participante2;
		}
	}
}
