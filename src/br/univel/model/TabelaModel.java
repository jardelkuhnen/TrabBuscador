package br.univel.model;

import javax.swing.table.AbstractTableModel;

public class TabelaModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnName(int column) {

		return super.getColumnName(column);
	}

}
