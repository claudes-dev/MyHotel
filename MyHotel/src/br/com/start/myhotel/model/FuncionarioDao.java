package br.com.start.myhotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.Conexao;

public class FuncionarioDao {
	
	
	private Connection conexao;
	
	Conexao con = new Conexao();
	
	
	
	PreparedStatement p = conexao.prepareStatement("INSERT INTO funcionario (cpf_func,senha,nome_func) VALUES (?,?,?) ");
	ResultSet resultado = p.executeQuery()if(resultado.next());
	{
		consultar(a);
		System.out.println("aluno ja cadastrado");
	}else
	{ PreparedStatement ps = conexao.prepareStatement("insert into aluno (nome,data_nascimento,naturalidade...) values (?,?,?...) "); ps.setString(1, a.getNome().trim()); ps.setString(2, a.getData_nascimento()); ps.setString(3, a.getNaturalidade().trim()); ... ps.executeUpdate(); }

}
