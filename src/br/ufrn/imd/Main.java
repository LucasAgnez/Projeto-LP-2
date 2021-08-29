package br.ufrn.imd;
import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.visao.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		//Carrega dados dos arquivos
		BancoSelecao.getInstance();
		
		//Mostra tela inicial
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}

}
