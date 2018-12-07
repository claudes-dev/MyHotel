package br.com.start.myhotel.model;

public class Administrador extends Pessoa {
	private int id_adm;
	public Administrador() {

	}

	public Administrador(String nome, String cpf, String senha) {
		// CONSTRUTOR CONTENDO ATRIBUTOS DA CLASSE CLIENTE, E DA SUPER CLASSE PESSOA
		super(nome, cpf, senha);

	}

	// pra poder sair os dados no select, se n por o to string aparece o lugar do
	// objeto na jvm
	@Override
	public String toString() {
		String saida = this.getCpf() + "  " + this.getNome();
		return saida;
	}

	public int getId_adm() {
		return id_adm;
	}

	public void setId_adm(int id_adm) {
		this.id_adm = id_adm;
	}
}
