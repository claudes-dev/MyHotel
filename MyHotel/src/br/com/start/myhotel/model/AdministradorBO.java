package br.com.start.myhotel.model;

import dao.AdministradorDao;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoEdicao;

public class AdministradorBO {

	private AdministradorDao dao = new AdministradorDao();
	
	public void cadastrarFuncionario(Funcionario f) throws ExcecaoCadastro {
		dao.criarFuncionario(f);
	}

	public void gerenciarStatus(Funcionario f) throws ExcecaoEdicao {
		dao.gerenciarStatus(f);
	}

}
