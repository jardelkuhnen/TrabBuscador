package br.univel.dao.postgres;

import java.util.List;

import br.univel.model.Pessoa;

public class PessoaController {

	public List<Pessoa> buscarDados(String criterio) {

		int temNumero = 0;

		Pessoa pessoa = new Pessoa();

		for (int i = 0; i < criterio.length(); i++) {

			if (Character.isDigit(criterio.charAt(i)) == true) {
				temNumero++;
				break;
			}

		}

		pessoa.setNome(criterio);
		pessoa.setProfissao(criterio);

		if (temNumero <= 0) {

			pessoa.setId(0);
			pessoa.setIdade(0);

		} else {
			pessoa.setId(Integer.parseInt(criterio));
			pessoa.setIdade(Integer.parseInt(criterio));

		}

		return new PessoaDao().getPessoas(pessoa);
	}

}
