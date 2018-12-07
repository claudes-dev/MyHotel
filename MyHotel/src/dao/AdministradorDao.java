package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.Funcionario;
import connection.ConexaoFactory;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoEdicao;

public class AdministradorDao {

	// 1-MÉTODO PARA CRIAR ADMINISTRADOR
	public void criarAdm(Administrador pessoa) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into administrador ");
		sql.append("(cpf_adm,senha,nome_adm) ");
		sql.append("values (?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, pessoa.getCpf());
			comando.setString(2, pessoa.getSenha());
			comando.setString(3, pessoa.getNome());

			comando.executeUpdate();

			System.out.println("Administrador criado com sucesso");
		} catch (SQLException excecao) {
			System.out.println("Falha ao inserir administrador");
			excecao.printStackTrace();
		}

	}
	
	// 2-MÉTODO PARA EXCLUIR ADMINISTRADOR
		public void excluirAdm(Administrador pessoa) {

			StringBuilder sql = new StringBuilder();
			sql.append("select * from administrador ");
			sql.append("(id_adm,nome_adm) ");
			sql.append("where cpf_adm = ?");

			Connection conexao = ConexaoFactory.getConnection();

			try {
				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, pessoa.getCpf());

				comando.executeUpdate();

				System.out.println("Administrador deletado com sucesso");
			} catch (SQLException excecao) {
				System.out.println("Falha ao excluir dministrador");
				excecao.printStackTrace();
			}

		}
		
	// 3-FUNÇÃO, ATUALIZAR ADM
		
		public void editarAdm(Administrador pessoa) {
			StringBuilder sql = new StringBuilder();
			sql.append("update administrador ");
			sql.append("set senha = ? ");
			sql.append("where nome_adm = ? ");

			Connection conexao = ConexaoFactory.getConnection();

			try {
				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, pessoa.getSenha());
				comando.setString(2, pessoa.getNome());

				comando.executeUpdate();

				System.out.println("Administrador alterado");
			} catch (SQLException excecao) {
				System.out.println("Falha ao alterado");
				excecao.printStackTrace();
			}

		}
		
		
		
		// 4-BUSCAR TODOS ADMS
		public Administrador buscarTudo(Administrador pessoa) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("select cpf_adm, nome_adm ");
			sql.append("from administrador ");
			sql.append("where cpf_func = ? ");

			Connection conexao = ConexaoFactory.getConnection();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, pessoa.getCpf());

			ResultSet resultado = comando.executeQuery();

			Administrador retorno = null;
			// 5-BUSCA UM ADM
			if (resultado.next()) {
				retorno = new Administrador();
				retorno.setCpf(resultado.getString("cpf_adm"));
				retorno.setNome(resultado.getString("nome_adm"));
			}
			return retorno;
		}

	// 6-MÉTODO PARA CRIAR FUNCIONÁRIO
	public void criarFuncionario(Funcionario pessoa) throws ExcecaoCadastro {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into funcionario ");
		sql.append("(cpf_func,senha,nome_func) ");
		sql.append("values (?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, pessoa.getCpf());
			comando.setString(2, pessoa.getSenha());
			comando.setString(3, pessoa.getNome());

			comando.executeUpdate();

			System.out.println("Funcionário criado com sucesso");
		} catch (SQLException e) {
			System.out.println("Falha, o sistema não conseguiu criar o funcionário");
			throw new ExcecaoCadastro("Erro ao cadastrar funcionanrio");
		}

	}
	
	// 7- FUNÇÃO QUE EDITA/ALTERA FUNCIONARIO
	public void editarFuncionario(Funcionario pessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("update funcionario ");
		sql.append("set senha = ? ");
		sql.append("where nome_func = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, pessoa.getSenha());
			comando.setString(2, pessoa.getNome());

			comando.executeUpdate();

			System.out.println("Funcionario alterado alterado");
		} catch (SQLException excecao) {
			System.out.println("Falha ao alter funcionario");
			excecao.printStackTrace();
		}

	}
	// 8-FUNÇÃO EXCLUIR FUNCIONÁRIO
	public void excluir(Funcionario pessoa) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from funcionario ");
		sql.append("where cpf_func = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, pessoa.getCpf());

			comando.executeUpdate();

			System.out.println("Funcionário deletado");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar funcionário");
			e.printStackTrace();
		}

	}
	
	
	// 9-BUSCAR TODOS FUNCIONARIOS
			public Funcionario buscarTudoFunc(Funcionario pessoa) throws SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("select cpf_func, nome_func ");
				sql.append("from funcionario ");
				sql.append("where cpf_func = ? ");

				Connection conexao = ConexaoFactory.getConnection();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, pessoa.getCpf());

				ResultSet resultado = comando.executeQuery();

				Funcionario retorno = null;
				// 10-BUSCA UM ADM
				if (resultado.next()) {
					retorno = new Funcionario();
					retorno.setCpf(resultado.getString("cpf_func"));
					retorno.setNome(resultado.getString("nome_func"));
				}
				return retorno;
			}

			public void gerenciarStatus(Funcionario f) throws ExcecaoEdicao {
				StringBuilder sql = new StringBuilder();
				sql.append("update funcionario ");
				sql.append("set status = ? ");
				sql.append("where cpf = ? ");

				Connection conexao = ConexaoFactory.getConnection();

				try {
					PreparedStatement comando = conexao.prepareStatement(sql.toString());
					comando.setInt(1, f.getStatus());
					comando.setString(2, f.getCpf());

					comando.executeUpdate();

					System.out.println("Funcionario alterado alterado");
				} catch (SQLException excecao) {
					throw new ExcecaoEdicao("Erro ao editar o status do funcionario");
				}
			}

	
}
