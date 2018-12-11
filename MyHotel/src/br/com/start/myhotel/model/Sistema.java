package br.com.start.myhotel.model;

public class Sistema {
    
	private String email_login;
	private String senha_login;
	
	
	
	public Sistema() {
		
	}
	
	
	public Sistema(String email, String senha) {
		this.email_login=email;
		this.senha_login=senha;
		}



	public String getEmail_login() {
		return email_login;
	}



	public void setEmail_login(String email_login) {
		this.email_login = email_login;
	}



	public String getSenha_login() {
		return senha_login;
	}



	public void setSenha_login(String senha_login) {
		this.senha_login = senha_login;
	}
	
	

}
