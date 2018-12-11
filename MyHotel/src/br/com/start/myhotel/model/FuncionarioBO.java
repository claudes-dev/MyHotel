package br.com.start.myhotel.model;

import dao.FuncionarioDao;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;

public class FuncionarioBO {

	private FuncionarioDao dao = new FuncionarioDao();

	// 1- FUN플O PARA CADASTRAR RESERVA
	public void fazerReserva(Reserva r) throws ExcecaoCadastro {
		dao.cadastrarReserva(r);
		
	}

	// 2- FUN플O PARA SUSPENDER RESERVA
	public void suspenderReserva(Reserva r) throws ExcecaoExclusao {
		dao.suspenderReserva(r);
	}

	// 3- FUN플O PARA BUSCAR TODAS RESERVAS
	public void buscarReservas(Reserva r) throws ExcecaoBusca {
		dao.buscarReserva(r);
	}

	// 4- FUN플O PARA BUSCAR UMA RESERVA
	public void buscarReserva(Reserva r) throws ExcecaoBusca {
		dao.buscarReserva(r);
	}
}