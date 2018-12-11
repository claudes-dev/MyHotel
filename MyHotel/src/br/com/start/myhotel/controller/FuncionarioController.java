package br.com.start.myhotel.controller;

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
			fazerReserva(req,res);	
		// 2
		}else if(operacao.equals("SUSPENDER_RESERVA")) {
			suspenderReserva(req, res);
		// 3
		}else if(operacao.equals("BUSCAR_RESERVAS")) {
			buscarReservas(req, res);
		//4
		}else if(operacao.equals("BUSCAR_RESERVA")) {
			buscarReserva(req, res);
		}
	
	
	}

	private void fazerReserva(HttpServletRequest req, HttpServletResponse res) {
		String idFuncionario = req.getParameter("idFuncionario");
		String DataEntrada = req.getParameter("DataEntrada");
		String email = req.getParameter("DataSaida");
		String valor = req.getParameter("valor");
		String idCliente = req.getParameter("idCliente");
		String idServico = req.getParameter("idServico");
		String numQuarto = req.getParameter("numQuarto");
		
		
		
	}

	private void suspenderReserva(HttpServletRequest req, HttpServletResponse res) {
		
		
	}

	private void buscarReservas(HttpServletRequest req, HttpServletResponse res) {

		
	}

	private void buscarReserva(HttpServletRequest req, HttpServletResponse res) {

		
	}
}
	

