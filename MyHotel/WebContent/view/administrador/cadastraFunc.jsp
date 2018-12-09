<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.sql.*"%>

<%@ page language="java" import="connection.ConexaoFactory"%>
<%@ page language="java"
	import="br.com.start.myhotel.model.AdministradorBO"%>
<%@ page language="java" import="br.com.start.myhotel.model.Funcionario"%>


<%
	String nome = request.getParameter("nome");
	String cpf = request.getParameter("cpf");
	String senha = request.getParameter("senha");
	String email = request.getParameter("email");

	Funcionario f = new Funcionario(nome, cpf, senha, email);

	try {

		Connection con = ConexaoFactory.getConnection();

		AdministradorBO adm = new AdministradorBO();

		adm.cadastrarFuncionario(f);

	} catch (Exception e) {
		out.println("deu erro boy" + e);
	} finally {

	}
%>
