package br.com.start.myhotel.model;

public class Funcionario extends Pessoa{
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, String senha) {
		//CONSTRUTOR CONTENDO ATRIBUTOS DA CLASSE CLIENTE, E DA SUPER CLASSE PESSOA
		super(nome, cpf, senha);
	}

	// pra poder sair os dados no select, se n por o to string aparece o lugar do objeto na jvm
	@Override
	public String toString() {
		String saida = this.cpf + "  " + this.nome;
		return saida;
	}
}
