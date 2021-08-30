package br.ufrn.imd.modelo.tablemodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.esportes.Esporte;
import br.ufrn.imd.modelo.partidas.PartidaFutebol;

public class PartidaFutebolTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private BancoSelecao bs = BancoSelecao.getInstance();
	private ArrayList<PartidaFutebol> dados;
	private String[] colunas = {"Data", "Participante 1","Gols", "Participante 2","Descricao"};
	
	public PartidaFutebolTableModel(Esporte e) {
		dados = bs.getPartidasFutebol();
	}

	@Override
	public String getColumnName(int column) {
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
				return dados.get(linha).getPlacarParticipante1() + "x" + dados.get(linha).getPlacarParticipante2();
			case 3:
				return dados.get(linha).getParticipante2();
			case 4:
				return dados.get(linha).getDescricao();
		}
		return null;
	}
}
