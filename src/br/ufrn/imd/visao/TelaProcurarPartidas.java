package br.ufrn.imd.visao;

import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufrn.imd.modelo.esportes.Basquete;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.esportes.Volei;
import br.ufrn.imd.modelo.tablemodel.PartidaBasqueteTableModel;
import br.ufrn.imd.modelo.tablemodel.PartidaFutebolTableModel;
import br.ufrn.imd.modelo.tablemodel.PartidaVoleiTableModel;

public class TelaProcurarPartidas extends JFrame implements ActionListener{
	
	private static final int T_BORDA = 20;
	private static final long serialVersionUID = 1L;
	PartidaFutebolTableModel pftm;
	PartidaVoleiTableModel pvtm;
	PartidaBasqueteTableModel pbtm;
	
	JTable tabela;
	
	public TelaProcurarPartidas(Esporte e) {
		Container ct = this.getContentPane();
		ct.setLayout((new GridLayout(1, 1)));
		
		JPanel panelTabela = new JPanel();
		panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.PAGE_AXIS));
		
		
		JLabel labelTabela = new JLabel("Partidas");
		labelTabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		panelTabela.add(labelTabela);
		
		if(e instanceof Futebol) {
			pftm = new PartidaFutebolTableModel(e);
			tabela = new JTable(pftm);
		}
		else if (e instanceof Volei) {
			pvtm = new PartidaVoleiTableModel(e);
			tabela = new JTable(pvtm);
		}
		else if(e instanceof Basquete) {
			pbtm = new PartidaBasqueteTableModel(e);
			tabela = new JTable(pbtm);
		}

		tabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		JScrollPane sp = new JScrollPane(tabela);
		sp.setBorder(null);
		panelTabela.add(sp);
		
		panelTabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		
		
		ct.add(panelTabela);
		
		
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
