package br.com.start.myhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Funcionario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_func,senha, nome_func ");
		sql.append("from funcionario");
		

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = null;
		ResultSet resultado = null;
		
	 comando = conexao.prepareStatement(sql.toString());
		
	 resultado = comando.executeQuery();

//		Funcionario retorno = null;
// tras apenas  um
//		if (resultado.next()) {
//			retorno = new Funcionario();
//			retorno.setCpf(resultado.getString("cpf_func"));
//			retorno.setNome(resultado.getString("nome_func"));
//			
//		}
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
//		 List a1 = new ArrayList();
		while(resultado.next()) {
			Funcionario f = new Funcionario();
			f.setCpf(resultado.getString("cpf_func"));
			f.setSenha(resultado.getString("senha"));
			f.setNome(resultado.getString("nome_func"));
			
			lista.add(f);
		}
		return lista;

	}

//	teste de inserção no banco
//	public static void main(String[] args) {
//		Funcionario f1 = new Funcionario();
//		Funcionario f2 = new Funcionario();
//		FuncionarioDao fdao = new FuncionarioDao();
//		
//		try {
//			ArrayList<Funcionario> f = fdao.listar();
//			
//			for (Funcionario funcionario : f) {
//				System.out.println("Resultado: " + funcionario);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Ocorreu um erro!");
//			e.printStackTrace();
//		}
//		
//		
//		
//	}

}
