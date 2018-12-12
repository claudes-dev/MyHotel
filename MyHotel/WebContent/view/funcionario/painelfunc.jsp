<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="connection.ConexaoFactory"%>
<%@ page import="br.com.start.myhotel.model.Pessoa"%>
<%@ page import="br.com.start.myhotel.model.Cliente"%>
<%@ page import="dao.FuncionarioDao"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>MyHotel - Painel de Funcionários</title>

<link rel="icon" href="favicon.ico" type="image/x-icon">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/waves.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/animate.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/dropzone.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/sweetalert.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/themes/all-themes.css"
	rel="stylesheet" />
</head>

<body class="theme-red">
	<!-- Pré-carregamento -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-red">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Aguarde...</p>
		</div>
	</div>
	<!-- #FIM# Pré-carregamento -->
	<!-- Overlay -->
	<div class="overlay"></div>
	<!-- #FIM# Overlay -->
	<!-- Barra de pesquisa -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="O QUE DESEJA?">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #FIM# Barra de pesquisa -->
	<!-- Top Bar -->
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="javascript:void(0);" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse"
					aria-expanded="false"></a> <a href="javascript:void(0);"
					class="bars"></a> <a class="navbar-brand" href="index.html">MyHotel
					- Gerencie seu negócio!</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<!-- Procurar -->
					<li><a href="javascript:void(0);" class="js-search"
						data-close="true"><i class="material-icons">search</i></a></li>
					<!-- #FIM# Procurar -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- #Top Bar -->
	<section>
		<!-- Sidebar esquerda -->
		<aside id="leftsidebar" class="sidebar">
			<!-- User Info -->
			<div class="user-info">
				<div class="image">
					<img src="<%=request.getContextPath()%>/resources/images/user.png"
						width="48" height="48" alt="User" />
				</div>
				<div class="info-container">
					<div class="name" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><%=request.getSession().getAttribute("nome")%></div>
					<div class="email"><%=session.getAttribute("email")%>
					</div>
					<div class="btn-group user-helper-dropdown">
						<i class="material-icons" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
						<ul class="dropdown-menu pull-right">
							<li><a
								href="<%=request.getContextPath()%>/view/administrador/perfil.jsp"><i
									class="material-icons">person</i>Perfil</a></li>
							<li role="separator" class="divider"></li>

							<form id="meuform" action="<%=request.getContextPath()%>/sistemaController"">
								<input type="hidden" name="tipo" value="FAZER_LOGOUT"></form>
						  	<li><a href="javascript:void(0);" onclick="document.getElementById('meuform').submit()">Sair</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- #User Info -->
			<!-- Menu -->
			<div class="menu">
				<ul class="list">
					<li class="header">GERENCIAR HOSPEDAGENS</li>
					<li class="active"><a href="javascript:void(0);"> <i
							class="material-icons">home</i> <span>Início</span>
					</a></li>
					<li><a href="javascript:void(0);" class="menu-toggle"> <i
							class="material-icons">hotel</i> <span>Hospedagem</span>
					</a>
						<ul class="ml-menu">
							<li><a
								href="<%=request.getContextPath()%>/view/funcionario/gerenciarclientes.jsp">
									<span>Clientes</span>
							</a></li>
							<li><a
								href="<%=request.getContextPath()%>/view/funcionario/gerenciarreservas.jsp">
									<span>Reservas</span>
							</a></li>
						</ul></li>
					<li class="header">GERENCIAR HOSPEDAGENS</li>
				</ul>
			</div>
			<!-- #Menu -->

			<!-- Footer -->
			<div class="legal">
				<div class="copyright">
					&copy; 2018 <a href="javascript:void(0);">HyHotel</a>.
				</div>
				<div class="version">
					<b>Versão: </b> 1.0.0
				</div>
			</div>
			<!-- #Footer -->

		</aside>

		<!-- #FIM# Right Sidebar -->

	</section>


	<section class="content">
		<div class="container-fluid">
			<div class="block-header">
				<h2>RESUMO DAS ATIVIDADES</h2>
			</div>

			<!-- Widgets -->

			<div class="row clearfix">
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-pink hover-expand-effect">
						<div class="icon">
							<i class="material-icons">room_service</i>
						</div>
						<div class="content">
							<div class="text">SERVIÇOS</div>
							<div class="number count-to" data-from="0" data-to="16"
								data-speed="1000" data-fresh-interval="20"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-cyan hover-expand-effect">
						<div class="icon">
							<i class="material-icons">hotel</i>
						</div>
						<div class="content">
							<div class="text">QUARTOS</div>
							<div class="number count-to" data-from="0" data-to="100"
								data-speed="1000" data-fresh-interval="20"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-light-green hover-expand-effect">
						<div class="icon">
							<i class="material-icons">person</i>
						</div>
						<div class="content">
							<div class="text">FUNCIONÁRIOS</div>
							<div class="number count-to" data-from="0" data-to="19"
								data-speed="1000" data-fresh-interval="20"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-orange hover-expand-effect">
						<div class="icon">
							<i class="material-icons">people</i>
						</div>
						<div class="content">
							<div class="text">HÓSPEDES</div>
							<div class="number count-to" data-from="0" data-to="87"
								data-speed="1000" data-fresh-interval="20"></div>
						</div>
					</div>
				</div>
			</div>

			<!-- #FIM# Widgets -->


			<div class="row clearfix">

				<!-- Tabela de usu�rios -->
				<div class="row clearfix">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="card">
							<div class="header">
								<h2>ÚLTIMOS HÓSPEDES</h2>
								<ul class="header-dropdown">
									<button onclick="location.href='<%=request.getContextPath()%>/view/funcionario/gerenciarclientes.jsp'"
										type="button" class="btn btn-primary waves-effect m-r-20">ADICIONAR</button>
								</ul>
							</div>
							<div class="body">
								<div class="table-responsive">
									<table
										class="table table-bordered table-striped table-hover js-basic-example dataTable">
										<thead>
											<tr>
												<th>Nome Completo</th>
												<th>CPF</th>
												<th>E-mail</th>

											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>Nome Completo</th>
												<th>CPF</th>
												<th>E-mail</th>
											</tr>
										</tfoot>
										<tbody>
								<%-- 			<%
												FuncionarioDao dao = new FuncionarioDao();

												List<Cliente> lista = new ArrayList<Cliente>();

												lista = dao.listarCliente();

												for (Cliente cliente : lista) {
													System.out.println(lista);
											%>



											<tr>
												<td><%=cliente.getNome()%></td>
												<td><%=cliente.getCpf()%></td>
												<td><%=cliente.getEmail()%></td>
											</tr>

											<%
												}
											%> --%>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- #FIM# Tabela de usu�rios -->

			</div>
		</div>
	</section>


	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.slimscroll.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/waves.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.inputmask.bundle.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/tabelas/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/tabelas/dataTables.bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.countTo.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-datatable.js"></script>
	<script src="js/demo.js"></script>

</body>

</html>