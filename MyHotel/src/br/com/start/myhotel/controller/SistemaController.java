package br.com.start.myhotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.Funcionario;
import dao.AdministradorDao;
import dao.FuncionarioDao;

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

		AdministradorDao adminDao;

		FuncionarioDao funcDao;

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String tipo = request.getParameter("tipo");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		// request.setAttribute(email, "nome");

		if (tipo.equals("f")) {
			funcDao = new FuncionarioDao();

			try {
				Funcionario loga = funcDao.buscarPorEmail(email);

				if (loga != null && senha.equals(loga.getSenha())) {

					HttpSession session = request.getSession();
					
					session.setAttribute("logado", loga);
					session.setAttribute("nome", loga.getNome());
					session.setAttribute("email", loga.getEmail());
					session.setAttribute("status", loga.getStatus());
					session.setAttribute("tipo", loga.getTipoConta());
					session.setAttribute("cpf", loga.getCpf());
					
				
					
					
					redirecionar(request, response, "funcionario/painelfunc.jsp");

				} else {
					request.setAttribute("mensagem", "Usuário não encontrado");
					
					redirecionar(request, response, "index.jsp");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (tipo.equals("a")) {
			adminDao = new AdministradorDao();
			try {
				Administrador loga = adminDao.buscarPorEmail(email);

				if (loga != null && (email.equals(loga.getEmail()) && senha.equals(loga.getSenha()))) {

					
					HttpSession session = request.getSession();
					
					session.setAttribute("logado", loga);
					session.setAttribute("nome", loga.getNome());
					session.setAttribute("email", loga.getEmail());
					session.setAttribute("tipo", loga.getTipoConta());
					session.setAttribute("cpf", loga.getCpf());
					
					
					
					redirecionar(request, response, "administrador/gerenciarusuarios.jsp");

				} else {
					request.setAttribute("mensagem", "Usuário ou senha incorretos.");
					redirecionar(request, response, "index.jsp");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (tipo.equals("FAZER_LOGOUT")) {
			fazerLogout(request, response);
			request.setAttribute("mensagem", "Deslogado com sucesso!");
			redirecionar(request, response, "index.jsp");
		}
	}
//		if (email.equals("nome") && senha.equals("senha")) {
//			rd = request.getRequestDispatcher("/view/administrador/paineladmin.jsp");
//			HttpSession session = request.getSession();
//			session.setAttribute("email", email);
//			rd.forward(request, response);
//		} else {
//			out.println("<b>Invalid Login Info.</b><br>");
//			rd = request.getRequestDispatcher("/LoginInfo.jsp");
//			rd.include(request, response);
//		}
//		out.close();
//
//	}

	 private void fazerLogout(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession();


	        session.invalidate();

	        session = request.getSession(false);

}
	
	
	private void redirecionar(HttpServletRequest req, HttpServletResponse res, String pagina) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/view/"+pagina);  
		rd.forward(req, res);//method may be include or forward  
	}
}
