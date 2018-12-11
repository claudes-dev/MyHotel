package br.com.start.myhotel.model;

public class Cliente extends Pessoa{
	
	//ATRIBUTOS DA PROPRIA CLASSE CLIENTE
	private String dataNascimento;
	private String email;
	private int idServicos;
	private String telefone;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String senha, String dataNascimento, String email,String telefone , int idServicos) {
		//CONSTRUTOR CONTENDO ATRIBUTOS DA CLASSE CLIENTE, E DA SUPER CLASSE PESSOA
		super(nome, cpf);
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.idServicos = idServicos;
	}
	 
	 //GETERS E SETERS
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdServicos() {
		return idServicos;
	}

	public void setIdServicos(int idServicos) {
		this.idServicos = idServicos;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		String saida = this.getCpf() + "  -  " + this.getNome() + "  -  " + this.getEmail();
		return saida;
	}
	 
}
