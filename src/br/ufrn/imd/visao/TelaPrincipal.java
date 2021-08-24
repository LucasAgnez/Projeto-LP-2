package br.ufrn.imd.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TelaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	JDesktopPane dtp = new JDesktopPane();
	
	JMenuBar mnbar = new JMenuBar();	
	JMenu menuEdit = new JMenu("Editar");
	JMenu menuAjud = new JMenu("Ajuda");
	
	public TelaPrincipal() {
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		setJMenuBar(mnbar);
		mnbar.add(menuEdit);
		mnbar.add(menuAjud);

		ct.add(BorderLayout.CENTER, dtp);
		
		setSize(800,600);
		setResizable(true);
		setTitle("Agenda Eventos Esportivos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
