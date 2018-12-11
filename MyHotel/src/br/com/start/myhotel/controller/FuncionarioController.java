package br.com.start.myhotel.controller;

import br.com.start.myhotel.model.Reserva;
import java.io.IOException;
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
		

	}

	private void suspenderReserva(HttpServletRequest req, HttpServletResponse res) {
		String dataSaida = req.getParameter("dataSaida");
		double valor = Double.parseDouble(req.getParameter("valor"));
		
		Reserva reserva = new Reserva();
		
		reserva.setValor(valor);
	}

	private void buscarReservas(HttpServletRequest req, HttpServletResponse res) {

	}

	private void buscarReserva(HttpServletRequest req, HttpServletResponse res) {

	}
}
