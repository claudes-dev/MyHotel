package br.com.start.myhotel.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CadastroFuncionario")
public class SistemaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SistemaController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated constructor stub
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		request.setAttribute(nome, "nome");
		if (nome.equals("nome") && senha.equals("senha")) {
			rd = request.getRequestDispatcher("/WelcomeServlet");
			rd.forward(request, response);
		} else {
			out.println("<b>Invalid Login Info.</b><br>");
			rd = request.getRequestDispatcher("/LoginInfo.jsp");
			rd.include(request, response);
		}
		out.close();

	}
}
