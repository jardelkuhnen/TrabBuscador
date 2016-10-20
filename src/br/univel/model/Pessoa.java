package br.univel.model;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;

@Tabela("Pessoa")
public class Pessoa {

	@Coluna(nome = "id", pk = true)
	private Integer id;

	@Coluna(nome = "nome")
	private String nome;

	@Coluna(nome = "idade")
	private Integer idade;

	@Coluna(nome = "profissao")
	private String profissao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade
				+ ", profissao=" + profissao + "]";
	}

}
