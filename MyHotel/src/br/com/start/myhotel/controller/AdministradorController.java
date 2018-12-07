package br.com.start.myhotel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.AdministradorBO;
import br.com.start.myhotel.model.Funcionario;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoEdicao;


public class AdministradorController extends HttpServlet{
	
	private AdministradorBO admBO = new AdministradorBO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String operacao = req.getParameter("operacao");
		if(operacao.equals("CADASTRAR")) {
			cadastrarFuncionario(req, res);
		} else if(operacao.equals("GERENCIAR_STATUS")) {
			gerenciarStatus(req, res);
		} else if(operacao.equals("ADICIONAR_QUARTO")) {
			adicionarQuarto(req, res);
		}
		
	}
	
	private void adicionarQuarto(HttpServletRequest req, HttpServletResponse res) {
		String nome = req.getParameter("nome");
	}

	private void cadastrarFuncionario(HttpServletRequest req, HttpServletResponse res) {
		
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String senha = req.getParameter("senha");
		String tipoConta = req.getParameter("tipoConta");
		
		Funcionario f = new Funcionario(nome, cpf, senha);
		f.setTipoConta(tipoConta);
		
		try {
			admBO.cadastrarFuncionario(f);
			//mandar mensagem de sucesso para a tela
		} catch (ExcecaoCadastro e) {
			//mandar mensagem de erro para a tela 
		}
	}
	

	private void gerenciarStatus(HttpServletRequest req, HttpServletResponse res) {
		String status = req.getParameter("status");
		String cpf = req.getParameter("cpf");
		
		Funcionario f = new Funcionario();
		f.setCpf(cpf);
		f.setStatus(Integer.parseInt(status));
		try {
			admBO.gerenciarStatus(f);
			//mandar mensagem de sucesso para a tela
		} catch (ExcecaoEdicao e) {
			//mandar mensagem de erro para a tela 
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean ValidarInclusaoAdm(Administrador administrador) {
		boolean retorno = true;
		
		if(administrador.getCpf()=="") {
			retorno = false;
		}if(administrador.getSenha() == "") {
			retorno = false;
		}if(administrador.getNome() == "") {
			retorno = false;
		}
		
		return retorno;
	}
	public boolean ValidarExclusaoAdm(Administrador administrador) {
		boolean retorno = true;
		
		if(administrador.getId_adm() == 0) {
			retorno = false;
		}
		return retorno;
	}
	
	
}
