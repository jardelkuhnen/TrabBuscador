package br.univel.dao.postgres;

import java.util.List;

import br.univel.model.Pessoa;

public class PessoaController {

	public List<Pessoa> buscarDados(String criterio) {

		int temNumero = 0;
		int numeroEncontrado = 0;

		Pessoa pessoa = new Pessoa();

		for (int i = 0; i < criterio.length(); i++) {
			
			// Verifica se são apenas letras na busca, se tiver numeros entra no if
			if (Character.isDigit(criterio.charAt(i)) == true) {
				temNumero++;
				numeroEncontrado = i;
				break;
			}

		}

		pessoa.setNome(criterio);
		pessoa.setProfissao(criterio);

		if (temNumero <= 0) {

			pessoa.setId(0);
			pessoa.setIdade(0);

		} else {
			pessoa.setId(numeroEncontrado);
			pessoa.setIdade(numeroEncontrado);

		}

		return new PessoaDao().getPessoas(pessoa);
	}

}
