package br.com.start.myhotel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.AdministradorBO;
import br.com.start.myhotel.model.Funcionario;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoEdicao;
import excecoes.ExcecaoExclusao;

public class AdministradorController extends HttpServlet {

	private AdministradorBO admBO = new AdministradorBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String operacao = req.getParameter("operacao");
		//1
		if(operacao.equals("CADASTRAR_ADM")) {
			cadastrarAdm(req, res);
		//2
		}else if(operacao.equals("EXCLUIR_ADM")) {
			excluirAdm(req, res);
		//3
		}else if(operacao.equals("ATUALIZAR_ADM")) {
			atualizarAdm(req, res);
		//4
		} else if(operacao.equals("BUSCAR_ADMS")) {
			buscarAdms(req, res);
		//5
		}else if(operacao.equals("BUSCAR_ADM")){
			buscarAdm(req, res);
		//6	
		} else if (operacao.equals("CADASTRAR_FUNCIONARIO")) {
			cadastrarFuncionario(req, res);
		//7
		}else if(operacao.equals("EDITAR_FUNCIONARIO")) {
			editarFuncionario(req, res);
		//8	
		} else if(operacao.equals("BUSCAR_FUNCIONARIO")){
			buscarFuncionario(req, res);
		//8	
		}else if(operacao.equals("BUSCAR_FUNCIONARIO")){
			buscarFuncionarios(req,res);
		//9
		} else if (operacao.equals("GERENCIAR_STATUS")) {
			gerenciarStatus(req, res);
		//10
		} else if (operacao.equals("ADICIONAR_QUARTO")) {
			adicionarQuarto(req, res);
		//11
		} else if (operacao.equals("BUSCA_ADMINISTRADORES")) {
			buscarAdms(req,res);
		}
		
	}
		
	private void editarFuncionario(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	private void buscarFuncionarios(HttpServletRequest req, HttpServletResponse res) {
		
	}

	private void buscarFuncionario(HttpServletRequest req, HttpServletResponse res) {
		
	}

	// 1-MÉTODO PARA CRIAR ADMINISTRADOR
	private void cadastrarAdm(HttpServletRequest req, HttpServletResponse res) {
		String cpf = req.getParameter("cpf");
		String senha = req.getParameter("senha");
		String nome = req.getParameter("senha");
		
		Administrador adm = new Administrador(cpf,senha,nome);
		

	}
	
	// 2-MÉTODO PARA EXCLUIR ADMINISTRADOR
	private void excluirAdm(HttpServletRequest req, HttpServletResponse res) {
		String cpf = req.getParameter("cpf");

		Administrador adm = new Administrador();
		adm.setCpf(cpf);
		try {
			admBO.excluirAdm(adm);
			req.setAttribute("mensagem", "Administrador exluído com sucesso");
			
		} catch (ExcecaoExclusao e) {
			req.setAttribute("mensagem", "erro ao excluir o administrador");
			
		}
	}
	
	// 3-FUNÇÃO, ATUALIZAR ADM
	private void atualizarAdm(HttpServletRequest req, HttpServletResponse res) {
		
		
	}

	// 4-BUSCAR TODOS ADMS
	private void buscarAdms(HttpServletRequest req, HttpServletResponse res) {
		String tipoConta = req.getParameter("tipo conta");

		Administrador adm = new Administrador();
		adm.setTipoConta(tipoConta);
		try {
			admBO.buscarAdms(adm);
			req.setAttribute("mensagem", "Administradores encontrados com sucesso");
			
		} catch (ExcecaoBusca e) {
			req.setAttribute("mensagem", "Administradores não encontrados");
			
		}

	}
	// 5-BUSCAS UM ADM
	private void buscarAdm(HttpServletRequest req, HttpServletResponse res) throws ExcecaoBusca{
		String cpf = req.getParameter("cpf");
		
		Administrador adm = new Administrador();
		adm.setCpf(cpf);
		try {
			admBO.buscarAdm(adm);
			req.setAttribute("mensagem", "Administrador encontrado com sucesso" );
		}catch(ExcecaoBusca exception) {
			req.setAttribute("mensagem", "Administrador não esncontrado" );
		}

	}
	// 6-MÉTODO PARA CRIAR FUNCIONÁRIO
	private void cadastrarFuncionario(HttpServletRequest req, HttpServletResponse res) {

		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String senha = req.getParameter("senha");
		String tipoConta = req.getParameter("tipoConta");

		Funcionario f = new Funcionario(nome, cpf, senha);
		f.setTipoConta(tipoConta);

		try {
			admBO.cadastrarFuncionario(f);
			req.setAttribute("mensagem", "Funcionário cadastrado com sucesso");
			
		} catch (ExcecaoCadastro e) {
			req.setAttribute("mensagem", "Erro no cadastro, por favor");
		}
	}
	
	private void adicionarQuarto(HttpServletRequest req, HttpServletResponse res) {
		String nome = req.getParameter("nome");
	}

	private void gerenciarStatus(HttpServletRequest req, HttpServletResponse res) {
		String status = req.getParameter("status");
		String cpf = req.getParameter("cpf");

		Funcionario f = new Funcionario();
		f.setCpf(cpf);
		f.setStatus(Integer.parseInt(status));
		try {
			admBO.gerenciarStatus(f);
			// mandar mensagem de sucesso para a tela
		} catch (ExcecaoEdicao e) {
			// mandar mensagem de erro para a tela
		}

	}

}
