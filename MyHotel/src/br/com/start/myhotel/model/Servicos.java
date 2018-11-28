package br.com.start.myhotel.model;

public class Servicos {
	
	private int idServico;
	private String servico;
	private double preco;
	
	//GETTERS E SETERS
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public String getServico() {
		return servico;
	}
	public void SetServico(String servico) {
		this.servico= servico;
		}
	public double getPreco() {
		return  preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
