package br.com.start.myhotel.controller;

import br.com.start.myhotel.model.Reserva;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.start.myhotel.model.FuncionarioBO;

public class FuncionarioController extends HttpServlet {

	FuncionarioBO funcBO = new FuncionarioBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String operacao = req.getParameter("operacao");
		// 1
		if (operacao.equals("FAZER_RESERVA")) {
			fazerReserva(req, res);
			// 2
		} else if (operacao.equals("SUSPENDER_RESERVA")) {
			suspenderReserva(req, res);
			// 3
		} else if (operacao.equals("BUSCAR_RESERVAS")) {
			buscarReservas(req, res);
			// 4
		} else if (operacao.equals("BUSCAR_RESERVA")) {
			buscarReserva(req, res);
		}

	}

	private void fazerReserva(HttpServletRequest req, HttpServletResponse res) {

		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
		int idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
		String dataEntrada = req.getParameter("dataEntrada");
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		int idServico = Integer.parseInt(req.getParameter("idServico"));
		int numQuarto = Integer.parseInt(req.getParameter("numQuarto"));

		Reserva reserva = new Reserva();

		reserva.setIdReserva(idReserva);
		reserva.setIdFuncionario(idFuncionario);
		reserva.setDataEntrada(dataEntrada);
		reserva.setIdCliente(idCliente);
		reserva.setIdServico(idServico);
		reserva.setNumQuarto(numQuarto);

		try {
			funcBO.fazerReserva(reserva);
			req.setAttribute("mensagem", "Reserva cadastrada com sucesso");

		} catch (ExcecaoCadastro excecao) {
			req.setAttribute("mensagem", "Reserva não cadastrada com sucesso");
		}
	}

	private void suspenderReserva(HttpServletRequest req, HttpServletResponse res) {
		String dataSaida = req.getParameter("dataSaida");
		double valor = Double.parseDouble(req.getParameter("valor"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));

		Reserva reserva = new Reserva();

		reserva.setDataSaida(dataSaida);
		reserva.setValor(valor);
		reserva.setIdCliente(idCliente);

		try {
			funcBO.suspenderReserva(reserva);
			req.setAttribute("mensagem", "Reserva suspendida com sucesso");
		} catch (ExcecaoExclusao excecao) {
			req.setAttribute("mensagem", "Reserva não foi suspendida");
		}
	}

	private List<Reserva> buscarReservas(HttpServletRequest req, HttpServletResponse res) {
		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
		
		Reserva reserva = new Reserva();
		reserva.setIdReserva(idReserva);
		//funcBO.buscarReservas(reserva);
		try {
			funcBO.buscarReservas(reserva);
			req.setAttribute("mensagem", "Reserva não foi suspendida");
			return funcBO.buscarReservas(reserva);
		}catch(ExcecaoBusca e) {
			req.setAttribute("mensagem", "Reserva não foi suspendida");
		}
		return  null;
	}

	private void buscarReserva(HttpServletRequest req, HttpServletResponse res) {
		int idReserva = Integer.parseInt(req.getParameter("idReserva"));

		Reserva reserva = new Reserva();

		reserva.setIdReserva(idReserva);
		try {
			funcBO.buscarReserva(reserva);
			req.setAttribute("mensagem", "Reserva carregada com sucesso");
		} catch (ExcecaoBusca excecao) {
			req.setAttribute("mensagem", "Reserva não encontrada");
		}
	}
}