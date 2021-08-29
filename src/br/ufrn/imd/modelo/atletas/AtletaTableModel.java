package br.ufrn.imd.modelo.atletas;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.table.AbstractTableModel;


import br.ufrn.imd.controle.BancoSelecao;

public class AtletaTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private BancoSelecao bs = BancoSelecao.getInstance();
	private ArrayList<Atleta> dados;
	private String[] colunas = {"Nome", "Data de Nascimento", "Peso", "Altura", "Nacionalidade", "Posicao"};

	
	public AtletaTableModel(String s) {
		dados = bs.buscarAtleta(s);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna){
			case 0:
				return dados.get(linha).getNome();
			case 1:
				return String.format("%td/%<tm/%<tY %<tH:%<tM", dados.get(linha).getDataNascimento());
			case 2:
				return dados.get(linha).getPeso();
			case 3:
				return dados.get(linha).getAltura();
			case 4:
				return dados.get(linha).getNacionalidade();	
			case 5:
				return ((AtletaColetivo) (dados.get(linha))).getPosicao();
		}
		return null;
	}

}
