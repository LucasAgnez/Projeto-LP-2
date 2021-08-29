package br.ufrn.imd.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufrn.imd.modelo.esportes.Esporte;

public class TelaProcurarPartidas extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Esporte esporte;
	
	public TelaProcurarPartidas(Esporte e) {
		esporte = e;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
