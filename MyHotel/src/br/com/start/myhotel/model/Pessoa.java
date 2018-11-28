package br.com.start.myhotel.model;

public abstract class Pessoa {
	
	String nome;
	String cpf;
	int id;
	String senha;
	
	//CONSTRUTOR QUE COMPLETO
	public Pessoa(String nome, String cpf, int id, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
		this.senha = senha;
	}
	
	//CONSTRUTOR SEM O ATRIBUTO ID
	public Pessoa(String nome, String cpf) {
			this.nome = nome;
			this.cpf = cpf;
	}
	
	// GET E SETERS DA CLASSE
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
}
