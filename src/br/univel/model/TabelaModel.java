package br.univel.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.anotacoes.Coluna;

public class TabelaModel extends AbstractTableModel {

	List<?> lista = new ArrayList();

	public TabelaModel(final List lista) {
		this.lista = lista;
	}

	public void incluir(List<Object> objeto) {
		this.lista = objeto;
		fireTableDataChanged();
	}

	public int getColumnCount() {

		Object objeto = lista.get(0);

		Class<?> classe = objeto.getClass();

		int colunas = 0;

		for (Method metodo : classe.getDeclaredMethods()) {

			if (metodo.isAnnotationPresent(Coluna.class)) {
				colunas++;

			}

		}
		return colunas;
	}

	public int getRowCount() {

		return lista.size();
	}

	public Object getValueAt(int row, int column) {

		Object objeto = lista.get(0);

		Class<?> classe = objeto.getClass();

		try {
			for (Method method : classe.getDeclaredMethods()) {

				Coluna anotacao = method.getAnnotation(Coluna.class);

				if (anotacao.posicao() == column) {
					return method.invoke(objeto);
				}

			}
		} catch (Exception e) {
			return "Algo deu errado";
		}

		return "";
	}

	@Override
	public String getColumnName(int column) {

		Object objeto = lista.get(0);

		Class<?> classe = objeto.getClass();

		for (Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {

				Coluna anotacao = metodo.getAnnotation(Coluna.class);

				if (anotacao.posicao() == column) {

					return anotacao.nome();
				}

			}

		}
		return "erro";

	}

}
