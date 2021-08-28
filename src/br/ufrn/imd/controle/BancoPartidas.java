package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.esportes.*;

public class BancoPartidas{
	private Basquete eventosBasquete;
	private Futebol eventosFutebol;
	private Volei eventosVolei;
	
	private static BancoPartidas bancoPartidas;

	public BancoPartidas(){
		this.eventosBasquete = new Basquete();
		this.eventosFutebol = new Futebol();
		this.eventosVolei= new Volei();
	}
	
	public static BancoPartidas getInstance() {
		if (bancoPartidas == null) {
			bancoPartidas = new BancoPartidas();
		}
		return bancoPartidas;
	}

	public Basquete getEventosBasquete() {
		return eventosBasquete;
	}

	public void setEventosBasquete(Basquete eventosBasquete) {
		this.eventosBasquete = eventosBasquete;
	}
	
	public Futebol getEventosFutebol() {
		return eventosFutebol;
	}

	public void setEventosFutebol(Futebol eventosFutebol) {
		this.eventosFutebol = eventosFutebol;
	}
	
	public Volei getEventosVolei() {
		return eventosVolei;
	}

	public void setEventosVolei(Volei eventosVolei) {
		this.eventosVolei = eventosVolei;
	}
	

	
}
