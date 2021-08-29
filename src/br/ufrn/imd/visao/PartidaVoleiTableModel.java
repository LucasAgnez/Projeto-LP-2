package br.ufrn.imd.visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufrn.imd.controle.BancoSelecao;
import br.ufrn.imd.modelo.partidas.PartidaVolei;

public class PartidaVoleiTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private BancoSelecao bs = BancoSelecao.getInstance();
	private ArrayList<PartidaVolei> dados;
	private String[] colunas = {"Data", "Participante 1", "Pontos", "Participante 2", "Vencedor", "Descricao"};

	
	public PartidaVoleiTableModel() {
		dados = bs.getPartidasVolei();
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
				return String.format("%td/%<tm/%<tY %<tH:%<tM", dados.get(coluna).getData());
			case 1:
				return dados.get(coluna).getParticipante1();
			case 2:
				return dados.get(coluna).getSetsParticipante1() + "x" + dados.get(coluna).getSetsParticipante2();
			case 3:
				return dados.get(coluna).getParticipante2();
			case 4:
				return dados.get(coluna).getVencedor();
			case 5:
				return dados.get(coluna).getDescricao();
		}
		return null;
	}
}
