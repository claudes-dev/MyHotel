package br.com.start.myhotel.model;

public class Reserva {

	private int idReserva;
	private int idFuncionario;
	private String DataEntrada;
	private String DataSaida;
	private double valor;
	private int idCliente;
	private int idServico;
	private int numQuarto;
	
	public Reserva() {
		
	}
	
	//GETTERS E SETERS
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getDataEntrada() {
		return DataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		DataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return DataSaida;
	}
	public void setDataSaida(String dataSaida) {
		DataSaida = dataSaida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	
	
	
}
