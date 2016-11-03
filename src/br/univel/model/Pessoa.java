package br.univel.model;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;

@Tabela("Pessoa")
public class Pessoa {

	private Integer id;

	private String nome;

	private Integer idade;

	private String profissao;

	public Pessoa(Integer id, String nome, Integer idade, String profissao) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
	}

	public Pessoa() {
	}

	@Coluna(nome = "Id", pk = true, posicao = 0)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Coluna(nome = "Nome", posicao = 1)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Coluna(nome = "Idade", posicao = 2)
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Coluna(nome = "Profissão", posicao = 3)
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", profissao=" + profissao + "]";
	}

}
