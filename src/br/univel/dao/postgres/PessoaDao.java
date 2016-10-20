package br.univel.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.Pessoa;

public class PessoaDao {

	private static final String SQL_SELECT = "SELECT * FROM PESSOA WHERE ID = ? OR NOME = ? OR IDADE = ? OR PROFISSAO = ?";
	Connection con = ConexaoPostgres.getConnection();
	ResultSet rs = null;

	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public List getPessoas(String text) {

		try {

			PreparedStatement stmt = con.prepareStatement(SQL_SELECT);

			rs = stmt.executeQuery();

			while (rs.next()) {
				pessoas.add(readResultSet(rs));
			}

			return pessoas;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pessoas;

	}

	private Pessoa readResultSet(ResultSet rs) throws SQLException {

		Integer id = rs.getInt("id");
		String nome = rs.getString("nome");
		Integer idade = rs.getInt("idade");
		String profissao = rs.getString("peofissao");

		return new Pessoa(id, nome, idade, profissao);
	}

}
