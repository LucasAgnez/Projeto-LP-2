package br.ufrn.imd.visao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

//import br.ufrn.imd.controle.BancoSelecao;
//import br.ufrn.imd.modelo.atletas.Selecao;




public class TelaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	JMenuBar mnbar = new JMenuBar();
	JMenu menuEdit = new JMenu("Editar");
	JMenu menuAjud = new JMenu("Ajuda");

	public TelaPrincipal() {
		Container ct = this.getContentPane();
		ct.setLayout((new GridLayout(3,1)));
		
		setJMenuBar(mnbar);
		mnbar.add(menuEdit);
		mnbar.add(menuAjud);

		
		JButton buttonAdicionarPartida = new JButton("Adicionar partida");
		buttonAdicionarPartida.setActionCommand("Adicionar");
		buttonAdicionarPartida.addActionListener(this);	
		//buttonAdicionarPartida.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonAdicionarPartida.setAlignmentX(CENTER_ALIGNMENT);

		ct.add(Box.createRigidArea(new Dimension(0, 10)));
		ct.add(buttonAdicionarPartida);
		ct.add(Box.createRigidArea(new Dimension(0, 10)));
		
        int larguraJanela = 1200;
        int alturaJanela = 625;
		setSize(larguraJanela, alturaJanela);
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setBounds(centro.x - larguraJanela / 2, centro.y - alturaJanela / 2, larguraJanela, alturaJanela);
		setResizable(true);
		setTitle("Agenda Eventos Esportivos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		//BancoSelecao bs = BancoSelecao.getInstance();
		//for(Selecao selecao  : bs.getSelecoes()) System.out.println(selecao.getID());
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Adicionar")) {
			TelaEscolherEsporte telaAdiocionarEsporte = new TelaEscolherEsporte();
			telaAdiocionarEsporte.setVisible(true);
		}
	}
	
}
