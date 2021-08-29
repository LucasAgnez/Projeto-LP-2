package br.ufrn.imd.visao;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JTable;

import br.ufrn.imd.modelo.tablemodel.AtletaTableModel;

public class TelaExibirAtletas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	AtletaTableModel atm;
	JTable tabela;
	
	public TelaExibirAtletas(String s) throws FileNotFoundException {
		Container ct = this.getContentPane();
		ct.setLayout((new GridLayout(1, 1)));
		
		setLayout(new FlowLayout());
		atm = new AtletaTableModel(s);
		
		tabela = new JTable(atm);
		ct.add(tabela);
		
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
