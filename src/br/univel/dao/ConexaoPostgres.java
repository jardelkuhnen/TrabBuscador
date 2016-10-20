package br.univel.dao;

import java.sql.Connection;

import br.univel.interfaces.Conexao;

public class ConexaoPostgres implements Conexao {

	@Override
	public Connection getConnection() {

		return null;
	}

}
