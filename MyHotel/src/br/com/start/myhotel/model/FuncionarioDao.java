package br.com.start.myhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		
	}
	
	
//	teste de inserção no banco
//	public static void main(String[] args) {
//		Funcionario f1 = new Funcionario("Claudes", "025.482.640-40","123");
//		
//		FuncionarioDao fdao = new FuncionarioDao();
//		
//		fdao.salvar(f1);
//		
//		
//	}
	
	
}
