package br.com.start.myhotel.model;

import java.util.List;

import dao.FuncionarioDao;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;

public class FuncionarioBO {

	private FuncionarioDao dao = new FuncionarioDao();

	// ADICIONAL CLIENTE
	public void cadastrarCliente(Cliente c) throws ExcecaoCadastro {
		dao.adicionarCliente(c);
	}

	// LISTAR QUARTOS
	public List<Quarto> listarQuartos() throws ExcecaoBusca {
		return dao.listarQuartos();
	}

	// 1- FUN플O PARA CADASTRAR RESERVA
	public void fazerReserva(Reserva r) throws ExcecaoCadastro {
		dao.cadastrarReserva(r);
	}

	// 2- FUN플O PARA SUSPENDER RESERVA
	public void suspenderReserva(Reserva r) throws ExcecaoExclusao {
		dao.suspenderReserva(r);
	}

	// 3- FUN플O PARA BUSCAR TODAS RESERVAS
	public List<Reserva> buscarReservas(Reserva r) throws ExcecaoBusca {
		return dao.listarReservas();
	}

	// 4- FUN플O PARA BUSCAR UMA RESERVA
	public void buscarReserva(Reserva r) throws ExcecaoBusca {
		dao.buscarReserva(r);
	}
}