package imd.modelo;

public abstract class Esporte {
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public abstract void addPartida();
}
