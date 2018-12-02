package br.com.start.myhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConexaoFactory;

public class FuncionarioDao {

	public void salvar(Funcionario f) {

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

	public void excluir(Funcionario f) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from funcionario ");
		sql.append("where cpf_func = ? ");

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

	public void editar(Funcionario f) {
		StringBuilder sql = new StringBuilder();
		sql.append("update funcionario ");
		sql.append("set senha = ? ");
		sql.append("where nome_func = ? ");

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

	public Funcionario buscarTudo(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_func, nome_func ");
		sql.append("from funcionario ");
		sql.append("where cpf_func = ? ");

		Connection conexao = ConexaoFactory.getConnection();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getCpf());

		ResultSet resultado = comando.executeQuery();

		Funcionario retorno = null;
		// tras apenas um
		if (resultado.next()) {
			retorno = new Funcionario();
			retorno.setCpf(resultado.getString("cpf_func"));
			retorno.setNome(resultado.getString("nome_func"));

		}
		return retorno;

	}

//	teste de inserção no banco
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		FuncionarioDao fdao = new FuncionarioDao();
		
		f2.setCpf("025.482.640-40");
		try {
			f1 = fdao.buscarTudo(f2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f1.toString());
	}

}
