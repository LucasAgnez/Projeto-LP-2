package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.esportes.*;
import br.ufrn.imd.modelo.partidas.*;

public class BancoPartidas{
	private Basquete eventosBasquete;
	private Futebol eventosFutebol;
	private Tenis eventosTenis;
	private Volei eventosVolei;

	public BancoPartidas(){
		this.eventosBasquete = new Basquete();
		this.eventosFutebol = new Futebol();
		this.eventosTenis = new Tenis();
		this.eventosVolei= new Volei();
	}

	public Basquete getEventosBasquete() {
		return eventosBasquete;
	}

	public void setEventosBasquete(Basquete eventosBasquete) {
		this.eventosBasquete = eventosBasquete;
	}
	
	public void addPartidaBasquete(PartidaBasquete partida) {
		eventosBasquete.addPartida(partida);
	}

	public Futebol getEventosFutebol() {
		return eventosFutebol;
	}

	public void setEventosFutebol(Futebol eventosFutebol) {
		this.eventosFutebol = eventosFutebol;
	}

	public void addPartidaFutebol(PartidaFutebol partida) {
		eventosFutebol.addPartida(partida);
	}
	
	public Tenis getEventosTenis() {
		return eventosTenis;
	}

	public void setEventosTenis(Tenis eventosTenis) {
		this.eventosTenis = eventosTenis;
	}

	public void addPartidaTenis(PartidaTenis partida) {
		eventosTenis.addPartida(partida);
	}
	
	public Volei getEventosVolei() {
		return eventosVolei;
	}

	public void setEventosVolei(Volei eventosVolei) {
		this.eventosVolei = eventosVolei;
	}
	
	public void addPartidaVolei(PartidaVolei partida) {
		eventosVolei.addPartida(partida);
	}
}