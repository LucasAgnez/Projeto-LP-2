package br.ufrn.imd.visao;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import br.ufrn.imd.modelo.esportes.Basquete;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.esportes.Volei;
import br.ufrn.imd.modelo.tablemodel.PartidaBasqueteTableModel;
import br.ufrn.imd.modelo.tablemodel.PartidaFutebolTableModel;
import br.ufrn.imd.modelo.tablemodel.PartidaVoleiTableModel;

public class TelaProcurarPartidas extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	PartidaFutebolTableModel pftm;
	PartidaVoleiTableModel pvtm;
	PartidaBasqueteTableModel pbtm;
	
	JTable tabela;
	
	public TelaProcurarPartidas(Esporte e) {
		Container ct = this.getContentPane();
		ct.setLayout((new GridLayout(1, 1)));
		setLayout(new FlowLayout());
		if(e instanceof Futebol) {
			pftm = new PartidaFutebolTableModel();
			tabela = new JTable(pftm);
		}
		else if (e instanceof Volei) {
			pvtm = new PartidaVoleiTableModel();
			tabela = new JTable(pvtm);
		}
		else if(e instanceof Basquete) {
			pbtm = new PartidaBasqueteTableModel();
			tabela = new JTable(pbtm);
		}
		
		ct.add(tabela);
		
		
		int larguraJanela = 600;
		int alturaJanela = 400;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
