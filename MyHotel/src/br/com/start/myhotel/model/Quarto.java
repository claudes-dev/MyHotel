package br.com.start.myhotel.model;

public class Quarto {
	
	//ATRIBUTOS DA PRÓRPIA CLASSE QUARTO
	private int numQuarto;
	private int andar;
	private int quantidadeCama;
	private int quantidadeBanheiro;
	private double precoMensal;
	private double precoDiaria;

	//SE ESTARÁ OCULPA OU NÃO
	private boolean status;
	//private Date tempoReserva;
	
	//GETTERS E SETERS
	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getQuantidadeCama() {
		return quantidadeCama;
	}

	public void setQuantidadeCama(int quantidadeCama) {
		this.quantidadeCama = quantidadeCama;
	}

	public int getQuantidadeBanheiro() {
		return quantidadeBanheiro;
	}

	public void setQuantidadeBanheiro(int quantidadeBanheiro) {
		this.quantidadeBanheiro = quantidadeBanheiro;
	}

	public double getPrecoMensal() {
		return precoMensal;
	}

	public void setPrecoMensal(double precoMensal) {
		this.precoMensal = precoMensal;
	}

	public double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
