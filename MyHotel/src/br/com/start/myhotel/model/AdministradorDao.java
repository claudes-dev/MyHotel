package br.com.start.myhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConexaoFactory;

public class AdministradorDao {

	//MÉTODO PARA ADICIONAR ADMINISTRADOR
	public void salvarAdm(Administrador f) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into administrador ");
		sql.append("(cpf_adm,senha,nome_adm) ");
		sql.append("values (?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getCpf());
			comando.setString(2, f.getSenha());
			comando.setString(3, f.getNome());

			comando.executeUpdate();

			System.out.println("Inserido no banco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi inserido");
			e.printStackTrace();
		}

	}

	//MÉTODO PARA ADICIONAR FUNCIOÁRIO
	public void salvarFunc(Funcionario f) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into funcionario ");
		sql.append("(cpf_func,senha,nome_func) ");
		sql.append("values (?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getCpf());
			comando.setString(2, f.getSenha());
			comando.setString(3, f.getNome());

			comando.executeUpdate();

			System.out.println("Inserido no banco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi inserido");
			e.printStackTrace();
		}

	}
	// Função excluir

	public void excluir(Administrador f) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from administrador ");
		sql.append("where cpf_adm = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getCpf());

			comando.executeUpdate();

			System.out.println("usuário deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi deletado");
			e.printStackTrace();
		}

	}

//	Função de editar com base no nome

	public void editar(Administrador f) {
		StringBuilder sql = new StringBuilder();
		sql.append("update administrador ");
		sql.append("set senha = ? ");
		sql.append("where nome_adm = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getSenha());
			comando.setString(2, f.getNome());

			comando.executeUpdate();

			System.out.println("alterado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("alterado");
			e.printStackTrace();
		}

	}

	// Função pra buscar

	public Administrador buscarTudo(Administrador f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_adm, nome_adm ");
		sql.append("from administrador ");
		sql.append("where cpf_func = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getCpf());

		ResultSet resultado = comando.executeQuery();

		Administrador retorno = null;
		// tras apenas um
		if (resultado.next()) {
			retorno = new Administrador();
			retorno.setCpf(resultado.getString("cpf_adm"));
			retorno.setNome(resultado.getString("nome_adm"));

		}
		return retorno;

	}
}
