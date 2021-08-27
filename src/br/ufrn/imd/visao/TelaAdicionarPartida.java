package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaAdicionarPartida extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	int codF = 1;
	
	public TelaAdicionarPartida(String esporte) {
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		JButton buttonAdicionarPartida = new JButton(esporte);
		buttonAdicionarPartida.setActionCommand("Teste");
		buttonAdicionarPartida.addActionListener(this);	
		ct.add(buttonAdicionarPartida);
		
		setSize(400,400);
		setResizable(true);
		setTitle("Adicionar partida");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
