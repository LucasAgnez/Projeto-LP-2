package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class TelaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;


	public TelaPrincipal() {
		Container ct = this.getContentPane();
		ct.setLayout((new BorderLayout()));
		

		JPanel panelBox = new JPanel();
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.PAGE_AXIS));
		
		JButton buttonAdicionarPartida = new JButton("Adicionar partida");
		buttonAdicionarPartida.setMaximumSize(new Dimension(250, 40));
		buttonAdicionarPartida.setActionCommand("Adicionar");
		buttonAdicionarPartida.addActionListener(this);	
		buttonAdicionarPartida.setAlignmentX(CENTER_ALIGNMENT);

		JButton buttonBuscarPartida = new JButton("Buscar Partidas");
		buttonBuscarPartida.setMaximumSize(new Dimension(250, 40));
		buttonBuscarPartida.setActionCommand("Buscar Partida");
		buttonBuscarPartida.addActionListener(this);
		buttonBuscarPartida.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton buttonBuscarAtleta= new JButton("Buscar Atletas");
		buttonBuscarAtleta.setMaximumSize(new Dimension(250, 40));
		buttonBuscarAtleta.setActionCommand("Buscar Atleta");
		buttonBuscarAtleta.addActionListener(this);
		buttonBuscarAtleta.setAlignmentX(CENTER_ALIGNMENT);
		
		//Adicionando todos paineis ao container principal
		panelBox.add(Box.createRigidArea(new Dimension(0, 150)));
		panelBox.add(buttonBuscarPartida);
		panelBox.add(Box.createRigidArea(new Dimension(0, 20)));
		panelBox.add(buttonAdicionarPartida);
		panelBox.add(Box.createRigidArea(new Dimension(0, 20)));
		panelBox.add(buttonBuscarAtleta);
		panelBox.add(Box.createRigidArea(new Dimension(0, 20)));
		
		ct.add(panelBox, BorderLayout.CENTER);
		
		//Configurando tamanho, posição e título da janela
        int larguraJanela = 500;
        int alturaJanela = 500;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Agenda Eventos Esportivos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Buscar Partida")) {
			TelaEscolherEsporteProcurarPartidas telaProcurarPartidas = new TelaEscolherEsporteProcurarPartidas();
			telaProcurarPartidas.setVisible(true);
		}
		if(e.getActionCommand().equals("Adicionar")) {
			TelaEscolherEsporte telaAdiocionarEsporte = new TelaEscolherEsporte();
			telaAdiocionarEsporte.setVisible(true);
		}
		if(e.getActionCommand().equals("Buscar Atleta")) {
			TelaProcurarAtletas telaProcurarAtletas= new TelaProcurarAtletas();
			telaProcurarAtletas.setVisible(true);
		}
	}
	
}
