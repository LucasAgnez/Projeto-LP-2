package br.ufrn.imd.visao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaProcurarAtletas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int T_BORDA = 20;

	private JPanel panelBoxCentral;
	private JTextField fieldAtletaBuscado;
	private JButton buttonConfirmar;

	public TelaProcurarAtletas() {
		Container ct = this.getContentPane();
		ct.setLayout((new GridLayout(1, 1)));

		JLabel labelBusca = new JLabel("Digite o nome do atleta:");
		labelBusca.setAlignmentX(CENTER_ALIGNMENT);

		fieldAtletaBuscado = new JTextField();
		fieldAtletaBuscado.setMaximumSize(new Dimension(400, 30));
		
		buttonConfirmar = new JButton("Confirmar");
	    buttonConfirmar.setActionCommand("Confirmar");
	    buttonConfirmar.addActionListener(this);
	    
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.LINE_AXIS));
		panelBotoes.setBorder(BorderFactory.createEmptyBorder(0, T_BORDA, T_BORDA, T_BORDA));
		panelBotoes.add(Box.createHorizontalGlue());
		panelBotoes.add(buttonConfirmar);
		
		panelBoxCentral = new JPanel();
		panelBoxCentral.setLayout(new BoxLayout(panelBoxCentral, BoxLayout.PAGE_AXIS));
		panelBoxCentral.add(labelBusca);
		panelBoxCentral.add(fieldAtletaBuscado);
		panelBoxCentral.add(Box.createRigidArea(new Dimension(0, 10)));
		panelBoxCentral.setBorder(BorderFactory.createEmptyBorder(T_BORDA, T_BORDA, T_BORDA, T_BORDA));
		
		
		ct.add(panelBoxCentral);
		ct.add(panelBotoes);

		int larguraJanela = 600;
		int alturaJanela = 400;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Buscar Atleta");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Confirmar")) {
			String s = fieldAtletaBuscado.getText();
			TelaExibirAtletas telaExibirAtletas = null;
			try {
				telaExibirAtletas = new TelaExibirAtletas(s);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			telaExibirAtletas.setVisible(true);
		}

	}

}