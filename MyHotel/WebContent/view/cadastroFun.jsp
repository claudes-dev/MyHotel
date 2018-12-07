<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*,java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="connection.ConexaoFactory"%>
<%@ page import="br.com.start.myhotel.model.Pessoa"%>
<%@ page import="br.com.start.myhotel.model.Funcionario"%>
<%@ page import="dao.FuncionarioDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Funcionário</title>
</head>
<body>


	<%
		FuncionarioDao dao = new FuncionarioDao();

		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	
		listaFuncionario = dao.listar();
		for (Funcionario f : listaFuncionario) {
	%>
	<ul>
		<li><%=f.getNome()%> | <%= f.getSenha() %> | <%=f.getCpf()%></li>
	</ul>
	<%
		}
	%>


	<!--
<form action=" <%--<%=  request.getContextPath() + "/CadastroFuncionario" %>--%>" method="post">
CPF : <input type="text" name="cpf" placeholder="Digite seu cpf"/>
<br />

SENHA : <input type="password" name="senha" placeholder="sua senha"/>
<br/>

NOME : <input type="text" name="nome" placeholder="Digite seu nome"/>
<br/>

<input type="submit" value="Enviar" />



</form>-->
</body>
</html>