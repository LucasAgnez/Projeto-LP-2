package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.esportes.Esporte;

public class TelaEscolherEsporteProcurarPartidas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static JList<Esporte> listaEsportes;
	
		public TelaEscolherEsporteProcurarPartidas() {
		
			Container ct = this.getContentPane();
			ct.setLayout(new BorderLayout());
			
			
			//Label da lista de esportes
			JLabel labelEsportes = new JLabel("Selecione o esporte:");
			labelEsportes.setAlignmentX(CENTER_ALIGNMENT);
		    
			//Lista de esportes
			BancoSelecao bs = BancoSelecao.getInstance();
		
			
			
		    listaEsportes = new JList<Esporte>(bs.encontraEsportes());
		    listaEsportes.setSelectedIndex(0);
			listaEsportes.setFont(listaEsportes.getFont().deriveFont(22.0f));
			listaEsportes.setFixedCellHeight(44);
		    JScrollPane listScrollPane = new JScrollPane(listaEsportes);
			
			
		
			//Adicionando lista de esportes e sua label no painel panelEsportes
			JPanel panelEsportes = new JPanel();
			panelEsportes.setLayout(new BoxLayout(panelEsportes, BoxLayout.PAGE_AXIS));
			panelEsportes.add(labelEsportes);
			panelEsportes.add(Box.createRigidArea(new Dimension(0, 10)));
			panelEsportes.add(listScrollPane);
			panelEsportes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			
			//Criando botões da janela de seleção de esporte
			JButton buttonCancelar = new JButton("Cancelar");
			buttonCancelar.setActionCommand("Cancelar");
			buttonCancelar.addActionListener(this);	
		    JButton buttonSelecionar = new JButton("Selecionar");
		    buttonSelecionar.setActionCommand("Selecionar");
		    buttonSelecionar.addActionListener(this);
			
		    //Adicionando botões ao seu painel
			JPanel panelBotoesEsporte = new JPanel();
			panelBotoesEsporte.setLayout(new BoxLayout(panelBotoesEsporte, BoxLayout.LINE_AXIS));
			panelBotoesEsporte.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
			panelBotoesEsporte.add(Box.createHorizontalGlue());
			panelBotoesEsporte.add(buttonCancelar);
			panelBotoesEsporte.add(Box.createRigidArea(new Dimension(10, 0)));
			panelBotoesEsporte.add(buttonSelecionar);
			
			//Adicionando todos paineis ao container principal
			ct.add(panelEsportes, BorderLayout.CENTER);
			ct.add(panelBotoesEsporte, BorderLayout.PAGE_END);
			
			//Configurando tamanho, posição e título da janela
			int larguraJanela = 400;
		    int alturaJanela = 400;
			setSize(larguraJanela, alturaJanela);
			Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
			setResizable(true);
			setTitle("Agenda Eventos Esportivos");
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Selecionar")) {
			TelaProcurarPartidas telaProcurarPartida = new TelaProcurarPartidas(listaEsportes.getSelectedValue());
			this.setVisible(false);
			telaProcurarPartida.setVisible(true);
		}
		else if(e.getActionCommand().equals("Cancelar")) {
			this.dispose();
		}
		
	}
}
