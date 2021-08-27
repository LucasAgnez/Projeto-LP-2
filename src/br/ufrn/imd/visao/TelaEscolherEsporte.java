package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufrn.imd.controle.TelaPrincipalControle;

public class TelaEscolherEsporte extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
		
	JDesktopPane dtp = new JDesktopPane();
	
	static JList<String> listaEsportes;
	
	TelaPrincipalControle telaPrincipalControle = new TelaPrincipalControle();
	
	public TelaEscolherEsporte() {
		//super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(BorderLayout.CENTER, dtp);
		
		
		//Label da lista de esportes
		JLabel labelEsportes = new JLabel("Selecione o esporte:");
		labelEsportes.setAlignmentX(CENTER_ALIGNMENT);
        
		//Lista de esportes
        listaEsportes = new JList<String>( (telaPrincipalControle.getEsportes().stream().map(e -> e.getNome() ).toArray(String[]::new)));  
        listaEsportes.setSelectedIndex(2);
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
		
		
		
		setSize(400,400);
		setResizable(true);
		setTitle("Agenda Eventos Esportivos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Selecionar")) {
			TelaAdicionarPartida telaEscolherPartida = new TelaAdicionarPartida(listaEsportes.getSelectedValue());
			this.setVisible(false);
			telaEscolherPartida.setVisible(true);
		}
	}
}
