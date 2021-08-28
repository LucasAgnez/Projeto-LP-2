package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.esportes.Esporte;

public class TelaAdicionarPartida extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	int codF = 1;
	
	JComboBox<String> paises1;
	JComboBox<String> paises2;
	
	public TelaAdicionarPartida(Esporte esporte) {
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		//Label de seleção dos países
		JLabel labelPaises = new JLabel("Selecione os países da partida:");
		labelPaises.setAlignmentX(CENTER_ALIGNMENT);
		
		//Adicionando label
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));
		panelLabel.add(labelPaises);
		panelLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		//Adicionando selects dos países
		BancoSelecao bs = BancoSelecao.getInstance();
		
		System.out.println(esporte.getID());
		paises1 = new JComboBox<String>(bs.encontraPaisesPorEsporte(esporte.getID()));
		paises2 = new JComboBox<String>(bs.encontraPaisesPorEsporte(esporte.getID()));
		
		
		JPanel panelBoxSelectPaises = new JPanel();
		panelBoxSelectPaises.setLayout(new BorderLayout());
		
		JPanel panelSelectsPaises = new JPanel();
		panelSelectsPaises.setLayout(new FlowLayout());
		panelSelectsPaises.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelSelectsPaises.add(Box.createVerticalGlue());
		paises1.setMinimumSize(new Dimension(400, 30));
		paises2.setMinimumSize(new Dimension(400, 30));
		panelSelectsPaises.add(paises1);
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelSelectsPaises.add(labelX);
		panelSelectsPaises.add(paises2);
		
		panelBoxSelectPaises.add(panelSelectsPaises);
		
		
		
		
		ct.add(panelLabel, BorderLayout.PAGE_START);
		ct.add(panelBoxSelectPaises, BorderLayout.CENTER);
		//ct.add(panelBoxSelectPaises);
		
		setSize(600, 400);
		setResizable(true);
		setTitle("Adicionar partida de " + esporte);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
