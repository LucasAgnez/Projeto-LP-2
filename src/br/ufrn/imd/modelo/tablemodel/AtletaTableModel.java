package br.ufrn.imd.modelo.tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.atletas.Atleta;
import br.ufrn.imd.modelo.atletas.AtletaColetivo;

public class AtletaTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private BancoSelecao bs = BancoSelecao.getInstance();
	private ArrayList<Atleta> dados;

	
	public AtletaTableModel(String s) {
		dados = bs.getAtletas(s);
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
			case 0:
				return "Nome";
			case 1: 
				return "Data de Nascimento";
			case 2:	
				return "Peso";
			case 3:
				return "Altura";
			case 4:
				return "Nacionalidade";
			case 5:
				return "Posicao";
		}
		return null;
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
