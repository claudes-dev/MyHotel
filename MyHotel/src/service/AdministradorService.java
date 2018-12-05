package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.start.myhotel.controller.AdministradorController;
import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.AdministradorDao;

public class AdministradorService extends HttpServlet {
	AdministradorDao daoAdministrador = new AdministradorDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operacao = req.getParameter("operacao");

		switch (operacao) {
		case "InserirAdministrador":
			Administrador administradorInserir = new Administrador();
			administradorInserir.setNome(req.getParameter("nome"));
			administradorInserir.setCpf(req.getParameter("cpf"));
			AdministradorController controler = new AdministradorController();
			if (controler.ValidarInclusaoAdm(administradorInserir)) {
				// DAO inserir
				daoAdministrador.criarAdm(administradorInserir);
			} else {
				//
			}
			break;
		case "ExcluirAdministrador":

			break;
		default:
			break;
		}

	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
