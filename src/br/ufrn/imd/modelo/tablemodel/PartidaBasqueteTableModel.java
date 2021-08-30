package br.ufrn.imd.modelo.tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.partidas.PartidaBasquete;

public class PartidaBasqueteTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private BancoSelecao bs = BancoSelecao.getInstance();
	private ArrayList<PartidaBasquete> dados;

	
	public PartidaBasqueteTableModel() {
		dados = bs.getPartidasBasquete();
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
			case 0:
				return "Data";
			case 1: 
				return "Participante 1";
			case 2:	
				return "Pontos";
			case 3:
				return "Participante 2";
			case 4:
				return "Descricao";
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
		return 5;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna){
			case 0:
				return String.format("%td/%<tm/%<tY %<tH:%<tM", dados.get(linha).getData());
			case 1:
				return dados.get(linha).getParticipante1();
			case 2:
				return dados.get(linha).getPontuacaoParticipante1() + "x" + dados.get(linha).getPontuacaoParticipante2();
			case 3:
				return dados.get(linha).getParticipante2();
			case 4:
				return dados.get(linha).getDescricao();
		}
		return null;
	}
}
