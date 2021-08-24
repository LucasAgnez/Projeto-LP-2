package imd.modelo.partidas;

import imd.modelo.atletas.Selecao;

public class PartidaBasquete extends Partida{
	private int pontuacaoParticipante1;
	private int pontuacaoParticipante2;
	
	public PartidaBasquete(Selecao participante1, Selecao participante2, int pontuacaoParticipante1,
			int pontuacaoParticipante2) {
		super(participante1, participante2);
		this.pontuacaoParticipante1 = pontuacaoParticipante1;
		this.pontuacaoParticipante2 = pontuacaoParticipante2;
		if(pontuacaoParticipante1 > pontuacaoParticipante2) {
			setVencedor(participante1);
		}
		else if(pontuacaoParticipante1 < pontuacaoParticipante2) {
			setVencedor(participante2);
		}
		else {} //throw empate
	}

	public int getPontuacaoParticipante1() {
		return pontuacaoParticipante1;
	}
	public void setPontuacaoParticipante1(int pontuacaoParticipante1) {
		this.pontuacaoParticipante1 = pontuacaoParticipante1;
	}
	public int getPontuacaoParticipante2() {
		return pontuacaoParticipante2;
	}
	public void setPontuacaoParticipante2(int pontuacaoParticipante2) {
		this.pontuacaoParticipante2 = pontuacaoParticipante2;
	}
}
