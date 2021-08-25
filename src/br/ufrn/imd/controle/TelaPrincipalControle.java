package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.esportes.Esporte;

public class TelaPrincipalControle {
	
	
	private BancoPartidas bancoPartidas = new BancoPartidas();
	
	
	public ArrayList<Esporte> getEsportes() {
		ArrayList<Esporte> esportes = new ArrayList<Esporte>();
		esportes.add(bancoPartidas.getEventosFutebol());
		esportes.add(bancoPartidas.getEventosBasquete());
		esportes.add(bancoPartidas.getEventosTenis());
		esportes.add(bancoPartidas.getEventosVolei());
		return esportes;
	}
}
