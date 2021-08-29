package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.atletas.Selecao;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.partidas.Partida;
import br.ufrn.imd.modelo.partidas.PartidaFutebol;

public class TelaAdicionarPartida extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final int T_BORDA = 20;
	
	private JPanel panelCardCentral;
	private JComboBox<Selecao> comboBoxPaises1;
	private JComboBox<Selecao> comboBoxPaises2;
	private JTextField fieldPlacarFutebol1;
	private JTextField fieldPlacarFutebol2;
	private JTextArea textAreaDescricao;
	private JButton buttonCancelar;
	private JButton buttonSelecionar;
	
	private Partida partida;
	private Esporte esporte;
	
	
	public TelaAdicionarPartida(Esporte e) {
		esporte = e;
		
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
		panelLabel.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		
		
		//Configurando painel central com cards
		panelCardCentral = new JPanel();
		panelCardCentral.setLayout(new CardLayout());
		panelCardCentral.add(montaEtapaPaises(), "Teste");
		panelCardCentral.add(montaEtapaPartida(), "Teste2");
		panelCardCentral.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		
		
		//Criando botões da janela de seleção de esporte
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setActionCommand("Cancelar");
		buttonCancelar.addActionListener(this);	
        buttonSelecionar = new JButton("Avançar");
        buttonSelecionar.setActionCommand("Avançar");
        buttonSelecionar.addActionListener(this);
		
		//Adicionando botões ao seu painel
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.LINE_AXIS));
		panelBotoes.setBorder(BorderFactory.createEmptyBorder(0, T_BORDA, T_BORDA, T_BORDA));
		panelBotoes.add(Box.createHorizontalGlue());
		panelBotoes.add(buttonCancelar);
		panelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
		panelBotoes.add(buttonSelecionar);
		
		//Adicionando todos paineis ao container principal
		ct.add(panelLabel, BorderLayout.PAGE_START);
		ct.add(panelCardCentral, BorderLayout.CENTER);
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

	
	private JPanel montaEtapaPaises() {
		//Adicionando selects dos países
		BancoSelecao bs = BancoSelecao.getInstance();
		comboBoxPaises1 = new JComboBox<Selecao>(bs.encontraSelecoesPorEsporte(esporte.getID()));
		comboBoxPaises2 = new JComboBox<Selecao>(bs.encontraSelecoesPorEsporte(esporte.getID()));
		JPanel panelSelectsPaises = new JPanel();
		panelSelectsPaises.setLayout(new BoxLayout(panelSelectsPaises, BoxLayout.LINE_AXIS));
		panelSelectsPaises.setBorder(BorderFactory.createEmptyBorder(0, T_BORDA, T_BORDA, T_BORDA));
		panelSelectsPaises.add(Box.createVerticalGlue());
		comboBoxPaises1.setMaximumSize(new Dimension(400, 30));
		comboBoxPaises2.setMaximumSize(new Dimension(400, 30));
		panelSelectsPaises.add(comboBoxPaises1);
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelSelectsPaises.add(labelX);
		panelSelectsPaises.add(comboBoxPaises2);
		return panelSelectsPaises;
	}
	
	private JPanel montaEtapaPartida() {
		
		if(esporte instanceof Futebol) {
			partida = new PartidaFutebol();
		}
		
		
		JPanel panelPlacares = new JPanel();
		panelPlacares.setLayout(new BoxLayout(panelPlacares, BoxLayout.LINE_AXIS));
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		

		fieldPlacarFutebol1 = new JTextField();
		fieldPlacarFutebol2 = new JTextField();
		fieldPlacarFutebol1.setMaximumSize(new Dimension(400, 30));
		fieldPlacarFutebol2.setMaximumSize(new Dimension(400, 30));
		
		//Ignora qualquer entrada que não for número ou a tecla de backspace
		fieldPlacarFutebol1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		fieldPlacarFutebol2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		
		panelPlacares.add(fieldPlacarFutebol1);
		panelPlacares.add(labelX);
		panelPlacares.add(fieldPlacarFutebol2);
		
		JPanel panelDescricao = new JPanel();
		panelDescricao.setLayout(new BoxLayout(panelDescricao, BoxLayout.LINE_AXIS));
		textAreaDescricao = new JTextArea();
		panelDescricao.add(textAreaDescricao);
		
		JPanel panelPartida = new JPanel();
		panelPartida.setLayout(new BoxLayout(panelPartida, BoxLayout.PAGE_AXIS));
		
		panelPartida.add(panelPlacares);
		panelPartida.add(panelDescricao);
		
		return panelPartida;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Avançar")) {
			
			if(esporte instanceof Futebol) {
				((PartidaFutebol) partida).setParticipante1((Selecao) comboBoxPaises1.getSelectedItem());
				((PartidaFutebol) partida).setParticipante2((Selecao) comboBoxPaises2.getSelectedItem());
			}
			
			CardLayout cl = (CardLayout)(panelCardCentral.getLayout());
	        cl.show(panelCardCentral, "Teste2");
	        buttonSelecionar.setText("Salvar");
	        buttonSelecionar.setActionCommand("Salvar");
	        buttonCancelar.setText("Voltar");
	        buttonCancelar.setActionCommand("Voltar");
		}
		else if(e.getActionCommand().equals("Salvar")) {
			if(esporte instanceof Futebol) {
				((PartidaFutebol) partida).setPlacarParticipante1(Integer.parseInt(fieldPlacarFutebol1.getText()));
				((PartidaFutebol) partida).setPlacarParticipante2(Integer.parseInt(fieldPlacarFutebol2.getText()));
				((PartidaFutebol) partida).calculaVencedor();
				((PartidaFutebol) partida).setData(null);
				((PartidaFutebol) partida).setDescricao(null);
			}
		}
		else if(e.getActionCommand().equals("Cancelar")) {
			this.dispose();
		}
		else if(e.getActionCommand().equals("Voltar")) {
			CardLayout cl = (CardLayout)(panelCardCentral.getLayout());
	        cl.show(panelCardCentral, "Teste");
	        buttonSelecionar.setText("Avançar");
	        buttonSelecionar.setActionCommand("Avançar");
	        buttonCancelar.setText("Cancelar");
	        buttonCancelar.setActionCommand("Cancelar");
		}
	}
	
}
