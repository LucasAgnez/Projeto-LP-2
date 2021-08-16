package imd.modelo.partidas;

public class SetTenis {
	private int gamesParticipante1;
	private int gamesParticipante2;
	
	public SetTenis(int gamesParticipante1, int gamesParticipante2) {
		super();
		this.gamesParticipante1 = gamesParticipante1;
		this.gamesParticipante2 = gamesParticipante2;
	}
	public SetTenis() {
		this.gamesParticipante1 = 0;
		this.gamesParticipante2 = 0;
	}
	public int getGamesParticipante1() {
		return gamesParticipante1;
	}
	public void setGamesParticipante1(int gamesParticipante1) {
		this.gamesParticipante1 = gamesParticipante1;
	}
	public int getGamesParticipante2() {
		return gamesParticipante2;
	}
	public void setGamesParticipante2(int gamesParticipante2) {
		this.gamesParticipante2 = gamesParticipante2;
	}
}
