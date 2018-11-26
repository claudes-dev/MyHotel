package br.com.start.myhotel.model;

public class ClienteDao {

	private String cpfCliente;
	private String rgCliente;
	private String nomeCliente;
	private int numQuarto;
//	private Date dataSaida;
//	private Date dataEntrada;
//	private Date dataNascimento;
	
	
//	getters and setters
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	
	
	
}
