package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		paises1 = new JComboBox<String>(bs.encontraPaisesPorEsporte(esporte.getID()));
		paises2 = new JComboBox<String>(bs.encontraPaisesPorEsporte(esporte.getID()));
		
		
		JPanel panelBoxCentral = new JPanel();
		panelBoxCentral.setLayout(new BorderLayout());
		
		JPanel panelCardCentral = new JPanel();
		panelCardCentral.setLayout(new CardLayout());
		
		JPanel panelSelectsPaises = new JPanel();
		panelSelectsPaises.setLayout(new BoxLayout(panelSelectsPaises, BoxLayout.LINE_AXIS));
		//panelSelectsPaises.setLayout(new FlowLayout());
		panelSelectsPaises.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelSelectsPaises.add(Box.createVerticalGlue());
		paises1.setMaximumSize(new Dimension(400, 30));
		paises2.setMaximumSize(new Dimension(400, 30));
		panelSelectsPaises.add(paises1);
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelSelectsPaises.add(labelX);
		panelSelectsPaises.add(paises2);
		
		panelCardCentral.add(panelSelectsPaises);
		panelBoxCentral.add(panelCardCentral, BorderLayout.CENTER);
		
		
		//Criando botões da janela de seleção de esporte
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setActionCommand("Cancelar");
		buttonCancelar.addActionListener(this);	
        JButton buttonSelecionar = new JButton("Selecionar");
        buttonSelecionar.setActionCommand("Selecionar");
        buttonSelecionar.addActionListener(this);
		
		//Adicionando botões ao seu painel
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.LINE_AXIS));
		panelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelBotoes.add(Box.createHorizontalGlue());
		panelBotoes.add(buttonCancelar);
		panelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
		panelBotoes.add(buttonSelecionar);
		
		//Adicionando todos paineis ao container principal
		ct.add(panelLabel, BorderLayout.PAGE_START);
		ct.add(panelBoxCentral, BorderLayout.CENTER);
		ct.add(panelBotoes, BorderLayout.PAGE_END);
		
		//Configurando tamanho, posição e título da janela
		int larguraJanela = 600;
        int alturaJanela = 400;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Adicionar partida de " + esporte);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Selecionar")) {
			
		}
		else if(e.getActionCommand().equals("Cancelar")) {
			this.dispose();
		}
	}
	
}
