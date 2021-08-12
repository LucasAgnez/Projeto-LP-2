package imd.modelo;


public abstract class Partida {
	private Selecao participante1;
	private Selecao participante2;
	private Selecao vencedor;
	private String descricao;
	
	public Partida(Selecao participante1, Selecao participante2) {
		super();
		this.participante1 = participante1;
		this.participante2 = participante2;
	}
	public Selecao getParticipante1() {
		return participante1;
	}
	public void setParticipante1(Selecao participante1) {
		this.participante1 = participante1;
	}
	public Selecao getParticipante2() {
		return participante2;
	}
	public void setParticipante2(Selecao participante2) {
		this.participante2 = participante2;
	}
	public Selecao getVencedor() {
		return vencedor;
	}
	public void setVencedor(Selecao vencedor) {
		this.vencedor = vencedor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
