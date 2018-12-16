package br.com.start.myhotel.controller;

import br.com.start.myhotel.model.Reserva;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.websocket.Session;

import br.com.start.myhotel.model.Cliente;
import br.com.start.myhotel.model.FuncionarioBO;

public class FuncionarioController extends HttpServlet {

	FuncionarioBO funcBO = new FuncionarioBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String operacao = req.getParameter("operacao");
		
			//ADICIONAL
		if(operacao.equals("CADASTRAR_CLIENTE")) {
			cadastrarCliente(req, res);
			redirecionar(req, res, "funcionario/gerenciarclientes.jsp");
			// 1
		}else if (operacao.equals("FAZER_RESERVA")) {
			fazerReserva(req, res);
			redirecionar(req, res, "funcionario/gerenciarreservas.jsp");
			// 2
//		} else if (operacao.equals("SUSPENDER_RESERVA")) {
//			suspenderReserva(req, res);
//			// 3
//		} else if (operacao.equals("BUSCAR_RESERVAS")) {
//			buscarReservas(req, res);
//			// 4
//		} else if (operacao.equals("BUSCAR_RESERVA")) {
//			buscarReserva(req, res);
		}
}
	
	private void redirecionar(HttpServletRequest req, HttpServletResponse res, String pagina) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/view/"+pagina);  
		rd.forward(req, res);//method may be include or forward  
	}
	
	private void cadastrarCliente(HttpServletRequest req, HttpServletResponse res) {
		
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		
		
		try {
			funcBO.cadastrarCliente(cliente);
			req.setAttribute("mensagem", "Cliente cadastrado com sucesso");
		}catch(ExcecaoCadastro excecao) {
			req.setAttribute("mensagem", "Falha ao cadastrar cliente");
		}
		
	}
	private void fazerReserva(HttpServletRequest req, HttpServletResponse res) {

		String dataEntrada = req.getParameter("dataEntrada");
		String dataSaida = req.getParameter("dataSaida");
		int IdFunc = Integer.parseInt(req.getParameter("funcionarioReserva"));
		int numQuarto = Integer.parseInt(req.getParameter("numQuarto"));
		String cpfCliente = req.getParameter("clienteReserva");
	
		

		Reserva reserva = new Reserva();

		reserva.setDataEntrada(dataEntrada);
		reserva.setDataSaida(dataSaida);
		reserva.setIdFuncionario(IdFunc);
		reserva.setNumQuarto(numQuarto);
		reserva.setcpfCliente(cpfCliente);

		try {
			funcBO.fazerReserva(reserva);
			req.setAttribute("mensagem", "Reserva cadastrada com sucesso");

		} catch (ExcecaoCadastro excecao) {
			req.setAttribute("mensagem", "Reserva não cadastrada com sucesso");
		}
	}

//	private void suspenderReserva(HttpServletRequest req, HttpServletResponse res) {
//		String dataSaida = req.getParameter("dataSaida");
//		double valor = Double.parseDouble(req.getParameter("valor"));
//		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
//
//		Reserva reserva = new Reserva();
//
//		reserva.setDataSaida(dataSaida);
//		reserva.setValor(valor);
//		reserva.setIdCliente(idCliente);
//
//		try {
//			funcBO.suspenderReserva(reserva);
//			req.setAttribute("mensagem", "Reserva suspendida com sucesso");
//		} catch (ExcecaoExclusao excecao) {
//			req.setAttribute("mensagem", "Reserva não foi suspendida");
//		}
//	}

//	private List<Reserva> buscarReservas(HttpServletRequest req, HttpServletResponse res) {
//		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
//		
//		Reserva reserva = new Reserva();
//		reserva.setIdReserva(idReserva);
//		//funcBO.buscarReservas(reserva);
//		try {
//			funcBO.buscarReservas(reserva);
//			req.setAttribute("mensagem", "Reserva não foi suspendida");
//			return funcBO.buscarReservas(reserva);
//		}catch(ExcecaoBusca e) {
//			req.setAttribute("mensagem", "Reserva não foi suspendida");
//		}
//		return  null;
//	}
//
//	private void buscarReserva(HttpServletRequest req, HttpServletResponse res) {
//		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
//
//		Reserva reserva = new Reserva();
//
//		reserva.setIdReserva(idReserva);
//		try {
//			funcBO.buscarReserva(reserva);
//			req.setAttribute("mensagem", "Reserva carregada com sucesso");
//		} catch (ExcecaoBusca excecao) {
//			req.setAttribute("mensagem", "Reserva não encontrada");
//		}
//	}

	   
}	    