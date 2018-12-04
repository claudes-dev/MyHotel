package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.start.myhotel.controller.AdministradorController;
import br.com.start.myhotel.model.Administrador;

public class AdministradorService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	Administrador objeto = new Administrador();
	objeto.setNome(req.getParameter("nome"));
	objeto.setCpf(req.getParameter("cpf"));
		AdministradorController controler = new  AdministradorController();
		if(controler.ValidarInclusaoAdm(objeto)) {
			//DAO inserir
		}else {
			//
		}
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
