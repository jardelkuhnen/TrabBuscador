package br.univel.dao.postgres;

import java.util.List;

public class PessoaController {

	public List getPessoas(String text) {

		return new PessoaDao().getPessoas(text.trim());

	}

}
