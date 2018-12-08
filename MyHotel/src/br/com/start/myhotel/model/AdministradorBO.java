package br.com.start.myhotel.model;

import java.sql.SQLException;

import dao.AdministradorDao;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoEdicao;
import excecoes.ExcecaoExclusao;

public class AdministradorBO {

	private AdministradorDao dao = new AdministradorDao();
	
	// 1-MÉTODO PARA CRIAR ADMINISTRADOR
	public void cadastrarAdm(Administrador adm) throws ExcecaoCadastro{
		dao.criarAdm(adm);
	}
	
	// 2-MÉTODO PARA EXCLUIR ADMINISTRADOR
	public void excluirAdm(Administrador adm)throws ExcecaoExclusao {
		dao.excluirAdm(adm);
	} 
	
	// 3-FUNÇÃO, ATUALIZAR ADM
	public void atualizarAdm(Administrador adm) throws ExcecaoEdicao {
		dao.editarAdm(adm);
	}
	
	// 4-BUSCAR TODOS ADMS
	public void buscarAdms(Administrador adm) throws ExcecaoBusca {
		dao.buscarAdms(adm);
	}
	// 5-BUSCAS UM ADM
	public void buscarAdm(Administrador adm) throws ExcecaoBusca{
		dao.buscarAdm(adm);
	}
	// 6-MÉTODO PARA CRIAR FUNCIONÁRIO
	public void cadastrarFuncionario(Funcionario f) throws ExcecaoCadastro {
		dao.criarFuncionario(f);
	}
	// 7- FUNÇÃO QUE EDITA/ALTERA FUNCIONARIO
	public void alterarFuncionario(Funcionario f) throws ExcecaoEdicao {
		dao.editarFuncionario(f);
	}
	// 8-FUNÇÃO EXCLUIR FUNCIONÁRIO
	public void apagarFuncionario(Funcionario f) throws ExcecaoExclusao {
		dao.excluirFuncionario(f);
	}
	// 9-BUSCAR TODOS FUNCIONARIOS
	public void buscarFunc(Funcionario f) throws ExcecaoBusca {
		dao.buscarFuncionarios(f);
	}
	// 10-BUSCAR UM FUNCIONARIO
	public void buscarFuncs(Funcionario f) throws ExcecaoBusca{
		dao.buscarFuncionario(f);
	}
	
	public void gerenciarStatus(Funcionario f) throws ExcecaoEdicao {
		dao.gerenciarStatus(f);
	}

}
