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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.atletas.Selecao;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.esportes.Futebol;
import br.ufrn.imd.modelo.esportes.Volei;
import br.ufrn.imd.modelo.esportes.Basquete;
import br.ufrn.imd.modelo.partidas.Partida;
import br.ufrn.imd.modelo.partidas.PartidaBasquete;
import br.ufrn.imd.modelo.partidas.PartidaFutebol;
import br.ufrn.imd.modelo.partidas.PartidaVolei;

public class TelaAdicionarPartida extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final int T_BORDA = 20;
	private static int larguraJanela = 400;
	private static int alturaJanela = 450;
	
	JLabel labelTitulo;
	private JPanel panelCardCentral;
	private JComboBox<Selecao> comboBoxPaises1;
	private JComboBox<Selecao> comboBoxPaises2;
	private JTextField fieldPlacarFutebol1;
	private JTextField fieldPlacarFutebol2;
	private JTextField fieldSet1 = new JTextField();
	private JTextField fieldSet2 = new JTextField();
	private JTextField fieldSet3 = new JTextField();
	private JTextField fieldSet4 = new JTextField();
	private JTextField fieldSet5 = new JTextField();
	private JTextField fieldSet6 = new JTextField();
	private JTextField fieldSet7 = new JTextField();
	private JTextField fieldSet8 = new JTextField();
	private JTextField fieldSet9 = new JTextField();
	private JTextField fieldSet10 = new JTextField();
	private JTextField fieldData;
	private JTextField fieldHora;
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
		labelTitulo = new JLabel("Selecione os países da partida:");
		labelTitulo.setAlignmentX(CENTER_ALIGNMENT);
		
		//Adicionando label
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));
		panelLabel.add(labelTitulo);
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
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Adicionar partida de " + esporte);
	}

	private JPanel montaEtapaPaises() {
		//Adicionando selects dos países
		BancoSelecao bs = BancoSelecao.getInstance();
		comboBoxPaises1 = new JComboBox<Selecao>(bs.getSelecoesPorEsporte(esporte.getID()));
		comboBoxPaises2 = new JComboBox<Selecao>(bs.getSelecoesPorEsporte(esporte.getID()));
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
		
		JPanel panelPontos = null;
		alturaJanela = 450;
		
		if(esporte instanceof Futebol) {
			partida = new PartidaFutebol();
			panelPontos = montaPainelPontosFutebol("Gols");
			panelPontos.setPreferredSize(new Dimension(300, 65));
		}
		else if(esporte instanceof Basquete) {
			partida = new PartidaBasquete();
			panelPontos = montaPainelPontosFutebol("Pontos");
			panelPontos.setPreferredSize(new Dimension(300, 65));
		}
		else if(esporte instanceof Volei) {
			
			partida = new PartidaVolei();
			panelPontos = new JPanel();
			panelPontos.setLayout(new BorderLayout());
			JScrollPane sp = new JScrollPane(montaPainelPontosVolei());
			sp.setBorder(null);
			panelPontos.add(sp);
			panelPontos.setPreferredSize(new Dimension(300, 200));
			alturaJanela = 700;
		}
		
		
		//Define painel de descrição
		JPanel grupoDescricao = new JPanel();
		grupoDescricao.setLayout(new BoxLayout(grupoDescricao, BoxLayout.PAGE_AXIS));
		JLabel labelDescricao = new JLabel("Descrição");
		labelDescricao.setMinimumSize(new Dimension(400, 30));
		labelDescricao.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		JPanel panelDescricao = new JPanel();
		panelDescricao.setLayout(new BoxLayout(panelDescricao, BoxLayout.LINE_AXIS));
		textAreaDescricao = new JTextArea();
		panelDescricao.setBorder(BorderFactory.createEmptyBorder(T_BORDA/2, 0, T_BORDA, 0));
		grupoDescricao.add(labelDescricao);
		grupoDescricao.add(textAreaDescricao);
		
		panelDescricao.add(grupoDescricao);
		
		JPanel panelPartida = new JPanel();
		panelPartida.setLayout(new BoxLayout(panelPartida, BoxLayout.PAGE_AXIS));
		
		
		//Define painel de data e hora
		fieldData = new JTextField();
		fieldHora = new JTextField();
		fieldData.setMinimumSize(new Dimension(400, 30));
		fieldHora.setMinimumSize(new Dimension(400, 30));
		JPanel panelDataHora = new JPanel();
	
		panelDataHora.setPreferredSize(new Dimension(800, 65));
		panelDataHora.setLayout(new BoxLayout(panelDataHora, BoxLayout.LINE_AXIS));
		fieldData.setMaximumSize(new Dimension(200, 30));
		fieldHora.setMaximumSize(new Dimension(200, 30));
		
		JPanel grupoData = new JPanel();
		grupoData.setLayout(new BoxLayout(grupoData, BoxLayout.PAGE_AXIS));
		JLabel labelData = new JLabel("Data");
		labelData.setMinimumSize(new Dimension(400, 30));
		labelData.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoData.add(labelData);
		grupoData.add(fieldData);
		grupoData.setMaximumSize(new Dimension(400, 60));
		
		JPanel grupoHora = new JPanel();
		grupoHora.setLayout(new BoxLayout(grupoHora, BoxLayout.PAGE_AXIS));
		JLabel labelHora = new JLabel("Hora");
		labelHora.setMinimumSize(new Dimension(400, 30));
		labelHora.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoHora.add(labelHora);
		grupoHora.add(fieldHora);
		grupoHora.setMaximumSize(new Dimension(400, 60));
		
		panelDataHora.add(grupoData);
		panelDataHora.add(Box.createRigidArea(new Dimension(60, 0)));
		panelDataHora.add(grupoHora);
		
		panelPartida.add(panelPontos);
		panelPartida.add(panelDescricao);
		panelPartida.add(panelDataHora);
		
		return panelPartida;
	}
	
	private JPanel montaPainelPontosFutebol(String nomePontos) {
		//Define painel de placares
		JPanel panelPlacares = new JPanel();
		panelPlacares.setLayout(new BoxLayout(panelPlacares, BoxLayout.LINE_AXIS));
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		
		JPanel grupoPlacar1 = new JPanel();
		grupoPlacar1.setLayout(new BoxLayout(grupoPlacar1, BoxLayout.PAGE_AXIS));
		fieldPlacarFutebol1 = new JTextField();
		fieldPlacarFutebol1.setMaximumSize(new Dimension(400, 30));
		JLabel labelPlacar1 = new JLabel(nomePontos);
		labelPlacar1.setMinimumSize(new Dimension(400, 30));
		labelPlacar1.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoPlacar1.add(labelPlacar1);
		grupoPlacar1.add(fieldPlacarFutebol1);
		grupoPlacar1.setMaximumSize(new Dimension(400, 60));
		
		JPanel grupoPlacar2 = new JPanel();
		grupoPlacar2.setLayout(new BoxLayout(grupoPlacar2, BoxLayout.PAGE_AXIS));
		fieldPlacarFutebol2 = new JTextField();
		fieldPlacarFutebol2.setMaximumSize(new Dimension(400, 30));
		JLabel labelPlacar2 = new JLabel(nomePontos);
		labelPlacar2.setMinimumSize(new Dimension(400, 30));
		labelPlacar2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoPlacar2.add(labelPlacar2);
		grupoPlacar2.add(fieldPlacarFutebol2);
		grupoPlacar2.setMaximumSize(new Dimension(400, 60));
		
		
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
		
		panelPlacares.add(grupoPlacar1);
		panelPlacares.add(labelX);
		panelPlacares.add(grupoPlacar2);
		
		return panelPlacares;
	}
	
	private JPanel montaPainelPontosVolei() {
		//Define painel de placares
		JPanel panelSets = new JPanel();
		panelSets.setLayout(new BoxLayout(panelSets, BoxLayout.PAGE_AXIS));
		
		panelSets.add(montaSets(fieldSet1, fieldSet2));
		panelSets.add(montaSets(fieldSet3, fieldSet4));
		panelSets.add(montaSets(fieldSet5, fieldSet6));
		panelSets.add(montaSets(fieldSet7, fieldSet8));
		panelSets.add(montaSets(fieldSet9, fieldSet10));
		
		return panelSets;
	}
	
	private JPanel montaSets(JTextField field1, JTextField field2) {
		JPanel panelSets = new JPanel();
		panelSets.setLayout(new BoxLayout(panelSets, BoxLayout.LINE_AXIS));
		JLabel labelX = new JLabel("X");
		labelX.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		
		JPanel grupoPlacar1 = new JPanel();
		grupoPlacar1.setLayout(new BoxLayout(grupoPlacar1, BoxLayout.PAGE_AXIS));
		//field1 = new JTextField();
		field1.setMaximumSize(new Dimension(400, 30));
		JLabel labelPlacar1 = new JLabel("Pontos");
		labelPlacar1.setMinimumSize(new Dimension(400, 30));
		labelPlacar1.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoPlacar1.add(labelPlacar1);
		grupoPlacar1.add(field1);
		grupoPlacar1.setMaximumSize(new Dimension(400, 60));
		
		JPanel grupoPlacar2 = new JPanel();
		grupoPlacar2.setLayout(new BoxLayout(grupoPlacar2, BoxLayout.PAGE_AXIS));
		//field2 = new JTextField();
		field2.setMaximumSize(new Dimension(400, 30));
		JLabel labelPlacar2 = new JLabel("Pontos");
		labelPlacar2.setMinimumSize(new Dimension(400, 30));
		labelPlacar2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		grupoPlacar2.add(labelPlacar2);
		grupoPlacar2.add(field2);
		grupoPlacar2.setMaximumSize(new Dimension(400, 60));
		
		
		//Ignora qualquer entrada que não for número ou a tecla de backspace
		field1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		field2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		
		panelSets.add(grupoPlacar1);
		panelSets.add(labelX);
		panelSets.add(grupoPlacar2);
		
		return panelSets;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Avançar")) {
			
			if(esporte instanceof Futebol) {
				((PartidaFutebol) partida).setParticipante1((Selecao) comboBoxPaises1.getSelectedItem());
				((PartidaFutebol) partida).setParticipante2((Selecao) comboBoxPaises2.getSelectedItem());
			}
			else if(esporte instanceof Basquete) {
				((PartidaBasquete) partida).setParticipante1((Selecao) comboBoxPaises1.getSelectedItem());
				((PartidaBasquete) partida).setParticipante2((Selecao) comboBoxPaises2.getSelectedItem());
			}
			else if(esporte instanceof Volei) {
				((PartidaVolei) partida).setParticipante1((Selecao) comboBoxPaises1.getSelectedItem());
				((PartidaVolei) partida).setParticipante2((Selecao) comboBoxPaises2.getSelectedItem());
			}
			labelTitulo.setText("Adicione dados da partida:");
			CardLayout cl = (CardLayout)(panelCardCentral.getLayout());
	        cl.show(panelCardCentral, "Teste2");
	        buttonSelecionar.setText("Salvar");
	        buttonSelecionar.setActionCommand("Salvar");
	        buttonCancelar.setText("Voltar");
	        buttonCancelar.setActionCommand("Voltar");
		}
		
		else if(e.getActionCommand().equals("Salvar")) {
			if(esporte instanceof Futebol) {
				if(fieldPlacarFutebol1.getText().isEmpty() || fieldPlacarFutebol2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos de gols são obrigatórios!");
					return;
				}
				((PartidaFutebol) partida).setPlacarParticipante1(Integer.parseInt(fieldPlacarFutebol1.getText()));
				((PartidaFutebol) partida).setPlacarParticipante2(Integer.parseInt(fieldPlacarFutebol2.getText()));
				((PartidaFutebol) partida).calculaVencedor();
				
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				try{ 
					((PartidaFutebol) partida).setData(ft.parse(fieldData.getText() + " " + fieldHora.getText()));
				} catch(ParseException ex){ 
					JOptionPane.showMessageDialog(null, "Campos de data e hora estão em formatos inválidos.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((PartidaFutebol) partida).setDescricao(textAreaDescricao.getText());
				BancoSelecao bs = BancoSelecao.getInstance();
				try {
					bs.salvarPartidaFutebol((PartidaFutebol) partida);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Um problema aconteceu na hora de salvar.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "Partida salva com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
				this.dispose();
			}
			
			else if(esporte instanceof Basquete) {
				if(fieldPlacarFutebol1.getText().isEmpty() || fieldPlacarFutebol2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos de pontos são obrigatórios!", "Tente novamente", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((PartidaBasquete) partida).setPontuacaoParticipante1(Integer.parseInt(fieldPlacarFutebol1.getText()));
				((PartidaBasquete) partida).setPontuacaoParticipante2(Integer.parseInt(fieldPlacarFutebol2.getText()));
				((PartidaBasquete) partida).calculaVencedor();
				
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				try{ 
					((PartidaBasquete) partida).setData(ft.parse(fieldData.getText() + " " + fieldHora.getText()));
				} catch(ParseException ex){ 
					JOptionPane.showMessageDialog(null, "Campos de data e hora estão em formatos inválidos.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((PartidaBasquete) partida).setDescricao(textAreaDescricao.getText());
				BancoSelecao bs = BancoSelecao.getInstance();
				try {
					bs.salvarPartidaBasquete((PartidaBasquete) partida);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Um problema aconteceu na hora de salvar.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "Partida salva com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
				this.dispose();
			}
			else if(esporte instanceof Volei) {
				if(fieldSet1.getText().isEmpty() || fieldSet2.getText().isEmpty() || fieldSet3.getText().isEmpty() || fieldSet4.getText().isEmpty() || 
						fieldSet5.getText().isEmpty() || fieldSet6.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Os pontos dos primeiros 3 sets são obrigatórios!", "Tente novamente", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((PartidaVolei) partida).setPontosSet1Parti1(Integer.parseInt(fieldSet1.getText()));
				((PartidaVolei) partida).setPontosSet1Parti2(Integer.parseInt(fieldSet2.getText()));
				((PartidaVolei) partida).setPontosSet2Parti1(Integer.parseInt(fieldSet3.getText()));
				((PartidaVolei) partida).setPontosSet2Parti2(Integer.parseInt(fieldSet4.getText()));
				((PartidaVolei) partida).setPontosSet3Parti1(Integer.parseInt(fieldSet5.getText()));
				((PartidaVolei) partida).setPontosSet3Parti2(Integer.parseInt(fieldSet6.getText()));
				if(!fieldSet7.getText().isEmpty() && !fieldSet8.getText().isEmpty()){
					((PartidaVolei) partida).setPontosSet4Parti1(Integer.parseInt(fieldSet7.getText()));
					((PartidaVolei) partida).setPontosSet4Parti2(Integer.parseInt(fieldSet8.getText()));
					if(!fieldSet9.getText().isEmpty() && !fieldSet10.getText().isEmpty()){
						((PartidaVolei) partida).setPontosSet5Parti1(Integer.parseInt(fieldSet9.getText()));
						((PartidaVolei) partida).setPontosSet5Parti2(Integer.parseInt(fieldSet10.getText()));
					}
				}
					
				((PartidaVolei) partida).calculaVencedor();
				
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				try{ 
					((PartidaVolei) partida).setData(ft.parse(fieldData.getText() + " " + fieldHora.getText()));
				} catch(ParseException ex){ 
					JOptionPane.showMessageDialog(null, "Campos de data e hora estão em formatos inválidos.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
					return;
				}
				((PartidaVolei) partida).setDescricao(textAreaDescricao.getText());
				BancoSelecao bs = BancoSelecao.getInstance();
				try {
					bs.salvarPartidaVolei((PartidaVolei) partida);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Um problema aconteceu na hora de salvar.", "Tente novamente", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "Partida salva com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
				this.dispose();
			}
		}
		
		else if(e.getActionCommand().equals("Cancelar")) {
			this.dispose();
		}
		
		else if(e.getActionCommand().equals("Voltar")) {
			labelTitulo.setText("Selecione os países da partida:");
			CardLayout cl = (CardLayout)(panelCardCentral.getLayout());
	        cl.show(panelCardCentral, "Teste");
	        buttonSelecionar.setText("Avançar");
	        buttonSelecionar.setActionCommand("Avançar");
	        buttonCancelar.setText("Cancelar");
	        buttonCancelar.setActionCommand("Cancelar");
		}
	}
	
}
