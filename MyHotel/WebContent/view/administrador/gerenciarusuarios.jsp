<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="connection.ConexaoFactory"%>
<%@ page import="br.com.start.myhotel.model.Pessoa"%>
<%@ page import="br.com.start.myhotel.model.Funcionario"%>
<%@ page import="br.com.start.myhotel.model.Administrador"%>
<%@ page import="dao.FuncionarioDao"%>
<%@ page import="dao.AdministradorDao"%>



<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>MyHotel - Gerenciar Usuários</title>

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
<link href="<%=request.getContextPath()%>/resources/css/dataTables.bootstrap.css"
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
	<!-- Pre-carregameto -->
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
	<!-- #FIM# pre-carregamento -->
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
					<!-- Busca -->
					<li><a href="javascript:void(0);" class="js-search"
						data-close="true"><i class="material-icons">search</i></a></li>
					<!-- #FIM# Busca -->
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
						aria-expanded="false">Saulo Lessa</div>
					<div class="email">exemplo@exemplo.com</div>
					<div class="btn-group user-helper-dropdown">
						<i class="material-icons" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
						<ul class="dropdown-menu pull-right">
							<li><a href="<%=request.getContextPath()%>view/administrador/perfil.jsp"><i class="material-icons">person</i>Perfil</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<%=request.getContextPath()%>view/index.jsp"><i class="material-icons">input</i>Sair</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- #User Info -->
			<!-- Menu -->
			<div class="menu">
				<ul class="list">
					<li class="header">GERENCIAR HOTEL</li>
					<li><a href="<%=request.getContextPath()%>view/administrador/paineladmin.jsp"> <i class="material-icons">home</i>
							<span>Início</span>
					</a></li>
					
					<li class="active"><a href="javascript:void(0);"> <i
							class="material-icons">person</i> <span>Usuários</span>
					</a></li>
					<li><a href="javascript:void(0);"> <i class="material-icons">attach_money</i>
							<span>Faturamento</span>
					</a></li>
					<li class="header">GERENCIAR CLIENTES</li>
					<li><a href="javascript:void(0);" class="menu-toggle"> <i
							class="material-icons">people</i> <span>Clientes</span>
					</a>
						<ul class="ml-menu">
							<li><a href="javascript:void(0);">Hospedados</a></li>
							<li><a href="javascript:void(0);">Histórico</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- #Menu -->
			<!-- Rodap� -->
			<div class="legal">
				<div class="copyright">
					&copy; 2018 <a href="javascript:void(0);">HyHotel</a>.
				</div>
				<div class="version">
					<b>Versão: </b> 1.0.0
				</div>
			</div>
			<!-- #Rodap� -->
		</aside>

	</section>

	<section class="content">
		<div class="container-fluid">

			<!-- Tabela de usu�rios -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>LISTAGEM DE USUÁRIOS CADASTRADOS</h2>
							<ul class="header-dropdown">
								<button type="button"
									class="btn btn-primary waves-effect m-r-20" data-toggle="modal"
									data-target="#adicionar">ADICIONAR</button>
								<button type="button"
									class="btn btn-default waves-effect m-r-20" data-toggle="modal"
									data-target="#gerenciar">GERENCIAR</button>
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
											<th>Função</th>
											<th>Status</th>
											
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Nome Completo</th>
											<th>CPF</th>
											<th>E-mail</th>
											<th>Função</th>
											<th>Status</th>
										</tr>
									</tfoot>
									<tbody>
										<%
											FuncionarioDao dao = new FuncionarioDao();

											List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

											listaFuncionario = dao.listarFunc();
											for (Funcionario f : listaFuncionario) {
										%>
										
										

										<tr>
											<td><%=f.getNome()%></td>
											<td><%=f.getCpf()%></td>
											<td><%=f.getEmail() %></td>
											<td><%=f.getTipoConta() %></td>
											<td><%=f.getStatus() %> </td>
										</tr>
										
										<%
											}
										%>
										
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- #FIM# Tabela de usu�rios -->
		</div>
	</section>


	<div class="modal fade" id="adicionar" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">


                <div class="card">
                    <div class="header">
                        <h2>ADICIONAR NOVO USUÁRIO AO SISTEMA</h2>
                        <ul class="header-dropdown">

                            <a style="margin-right: 5px;" data-dismiss="modal" role="button" aria-haspopup="true"
                                aria-expanded="false">
                                <i class="material-icons">close</i>
                            </a>

                        </ul>
                    </div>
                    <div class="body">
                        <form id="wizard_with_validation" action="<%=request.getContextPath()%>/administradorController" method="post">
                            <h3>Informações de login</h3>
                            <fieldset>
                            <div class="form-group">
                                    <input type="radio" name="operacao" id="op1" value="CADASTRAR_ADM" class="with-gap" required>
                                    <label for="op1">Esse usuário TERÁ permissões administrativas.</label>
                                    <input type="radio" name="operacao" id="op2" value="CADASTRAR_FUNCIONARIO" class="with-gap" required>
                                    <label for="op2">Esse usuário NÃO terá permissões
                                        administrativas.</label>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="email" class="form-control" name="email" required>
                                        <label class="form-label">E-mail*</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="password" minlength="6" class="form-control" name="senha" id="senha"
                                            required>
                                        <label class="form-label">Senha*</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="password" minlength="6" class="form-control" name="confirmar"
                                            required>
                                        <label class="form-label">Confirmar Senha*</label>
                                    </div>
                                </div>
                            </fieldset>

                            <h3>Informações de perfil</h3>
                            <fieldset>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" name="nome" class="form-control" required>
                                        <label class="form-label">Nome*</label>
                                    </div>
                                </div>
                                <div class="demo-masked-input">
                                        <div class="input-group">
                                            <div class="form-line">
                                                <input type="text" name="cpf" class="form-control cpf" placeholder="CPF*" required>
                                            </div>
                                            <div class="help-info">Ex.: 123.456.789-10</div>
                                        </div>
                                </div>
                                <input id="acceptTerms-2" name="acceptTerms" class="form-control" type="checkbox" required>
                                <label for="acceptTerms-2">Estou ciente que não poderei excluir o usuário criado caso
                                    ele realize ao menos uma alteração dentro do sistema.</label>
                            </fieldset>

                        </form>
                    </div>
                </div>


            </div>
        </div>
    </div>
	
	<div class="modal fade" id="gerenciar" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="defaultModalLabel">Gerenciar
						contas de usuários:</h4>
				</div>
				<div class="modal-body">
					<div class="body">
						<form id="form_validation" method="POST">
								<div class="form-group form-float">
									 <div class="form-line">
										<input minlength="11" type="number" maxlength="11" name="cpf"
											class="form-control" required> <label
											class="form-label">CPF*</label>
									 </div>
									  <div class="help-info">Digite apenas os números do seu CPF.</div>
								</div>
							<div class="form-group">
								<input type="radio" name="escolhaConta" id="desativarConta"
									class="with-gap" required> <label for="desativarConta">Desejo
									desativar a conta vinculada ao e-mail acima.</label> <input
									type="radio" name="escolhaConta" id="reativarConta"
									class="with-gap" required> <label for="reativarConta">Desejo
									reativar a conta vinculada ao e-mail acima.</label>
							</div>
							<div class="form-group">
								<input type="checkbox" id="checkbox" name="checkbox"> <label
									for="checkbox">Estou ciente que a conta poderá ser
									desativada/reativada a qualquer momento.</label>
							</div>
							<div class="modal-footer">
								<button class="btn btn-primary waves-effect"
									type="submit">CONFIRMAR</button>
								<button type="button" class="btn btn-default waves-effect"
									data-dismiss="modal">FECHAR</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script 
		src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script 
		src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.slimscroll.js"></script>
	<script 
		src="<%=request.getContextPath()%>/resources/js/waves.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/bootstrap-colorpicker.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/dropzone.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.steps.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.inputmask.bundle.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/tabelas/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/tabelas/dataTables.bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script>
	<script 
		src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-datatable.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/modals.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/dialogs.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/form-validation.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/form-wizard.js"></script>
	<script 
	    src="<%=request.getContextPath()%>/resources/js/advanced-form-elements.js"></script>
	<script 
	    src="js/demo.js"></script>
</body>

</html>