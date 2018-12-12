package br.com.start.myhotel.model;

public class Funcionario extends Pessoa{
		
	private int IdFunc;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, String senha, String email) {
		//CONSTRUTOR CONTENDO ATRIBUTOS DA CLASSE CLIENTE, E DA SUPER CLASSE PESSOA
		super(nome, cpf, senha, email);
	}

	// pra poder sair os dados no select, se n por o to string aparece o lugar  do objeto na jvm
	@Override
	public String toString() {
		String saida = this.getCpf()  + this.getNome()  + this.getSenha() + this.getEmail();
		return saida;
	}

	public int getIdFunc() {
		return IdFunc;
	}

	public void setIdFunc(int idFunc) {
		IdFunc = idFunc;
	}
}
