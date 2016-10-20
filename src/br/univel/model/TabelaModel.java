package br.univel.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.anotacoes.Coluna;

public class TabelaModel extends AbstractTableModel {

	List<?> lista = new ArrayList();

	public TabelaModel(final List lista) {
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {

		Object objeto = lista.get(0);

		Class<?> classe = objeto.getClass();

		int colunas = 0;

		for (Field field : classe.getDeclaredFields()) {

			if (field.isAnnotationPresent(Coluna.class)) {
				colunas++;

			}

		}
		return colunas;
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int column) {

		Object objeto = lista.get(0);

		Class<?> classe = objeto.getClass();

		for (Field field : classe.getDeclaredFields()) {

			Coluna anotacao = field.getAnnotation(Coluna.class);

			if (anotacao.posicao() == column) {

			}

		}

		return null;
	}

	@Override
	public String getColumnName(int column) {

		return super.getColumnName(column);
	}

}
