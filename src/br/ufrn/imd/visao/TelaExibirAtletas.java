package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import br.ufrn.imd.modelo.tablemodel.AtletaTableModel;

public class TelaExibirAtletas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final int T_BORDA = 20;
	
	AtletaTableModel atm;
	JTable tabela;
	
	
	public TelaExibirAtletas(String s) throws FileNotFoundException {
		Container ct = this.getContentPane();
		ct.setLayout((new BorderLayout()));
		
		JPanel panelTabela = new JPanel();
		panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.PAGE_AXIS));
		
		
		JLabel labelTabela = new JLabel("Atletas");
		labelTabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		panelTabela.add(labelTabela);
		
		atm = new AtletaTableModel(s);
		
		tabela = new JTable(atm);
		tabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		panelTabela.add(tabela);
		
		panelTabela.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		
		
		ct.add(panelTabela);
		
		int larguraJanela = 600;
		int alturaJanela = 400;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Resultado da Pesquisa: " + s);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
