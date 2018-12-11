<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="connection.ConexaoFactory"%>
<%@ page import="br.com.start.myhotel.model.Pessoa"%>
<%@ page import="br.com.start.myhotel.model.Funcionario"%>
<%@ page import="dao.FuncionarioDao"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>MyHotel - Perfil</title>

    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/css/waves.css" rel="stylesheet" />

    <link href="<%=request.getContextPath()%>/resources/css/animate.css" rel="stylesheet" />

    <link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/css/themes/all-themes.css" rel="stylesheet" />
</head>

<body class="theme-red">
    <!-- Page Loader -->
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
    <!-- #END# Page Loader -->
    <!-- Overlay For Sidebars -->
    <div class="overlay"></div>
    <!-- #END# Overlay For Sidebars -->
    <!-- Search Bar -->
    <div class="search-bar">
        <div class="search-icon">
            <i class="material-icons">search</i>
        </div>
        <input type="text" placeholder="O QUE DESEJA?">
        <div class="close-search">
            <i class="material-icons">close</i>
        </div>
    </div>
    <!-- #END# Search Bar -->
    <!-- Top Bar -->
    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse"
                    aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars"></a>
                <a class="navbar-brand" href="index.html">MyHotel - Gerencie seu negócio!</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <!-- Call Search -->
                    <li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
                    <!-- #END# Call Search -->
                </ul>
            </div>
        </div>
    </nav>
    <!-- #Top Bar -->
    <section>
        <!-- Left Sidebar -->
        <aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info">
                <div class="image">
                    <img src="<%=request.getContextPath()%>/resources/images/user.png" width="48" height="48" alt="User" />
                </div>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Saulo Lessa</div>
                    <div class="email">exemplo@exemplo.com</div>
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);"><i class="material-icons active">person</i>Perfil</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="../index.jsp"><i class="material-icons">input</i>Sair</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- #User Info -->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                    <li class="header">GERENCIAR HOSPEDAGENS</li>
                    <li>
                        <a href="painelfunc.jsp">
                            <i class="material-icons">home</i>
                            <span>Início</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">hotel</i>
                            <span>Hospedagem</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="<%=request.getContextPath()%>/view/funcionario/gerenciarclientes.jsp">
                                    <span>Clientes</span>
                                </a>

                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/view/funcionario/gerenciarreservas.jsp">
                                    <span>Reservas</span>
                                </a>

                            </li>
                        </ul>
                    </li>
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

    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-xs-12 col-sm-3">
                    <div class="card profile-card">
                        <div class="profile-header">&nbsp;</div>
                        <div class="profile-body">
                            <div class="image-area">
                                <img src="<%=request.getContextPath()%>/resources/images/user-lg.jpg" alt="AdminBSB - Profile Image" />
                            </div>
                            <div class="content-area">
                                <h3>Saulo Lessa</h3>
                                <p>MyHotel - Painel Administrativo</p>
                                <p>Administrador</p>
                            </div>
                            <div class="profile-footer">
                                <ul>
                                    <li>
                                        <span>Cadastros realizados</span>
                                        <span>4</span>
                                    </li>
                                    <li>
                                        <span>Data de criação</span>
                                        <span>05/12/2018</span>
                                    </li>
                                    <li>
                                        <span>Coe</span>
                                        <span>123</span>
                                    </li>
                                    <li>
                                        <span>Cor sim</span>
                                        <span>Cor não</span>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>


                </div>
                <div class="col-xs-12 col-sm-9">
                    <div class="card">
                        <div class="body">
                            <div>
                                <ul class="nav nav-tabs" role="tablist">
                                    <li role="presentation" class="active"><a href="#profile_settings" aria-controls="settings"
                                            role="tab" data-toggle="tab">Configurações de perfil</a></li>
                                    <li role="presentation"><a href="#change_password_settings" aria-controls="settings"
                                            role="tab" data-toggle="tab">Mudar senha</a></li>
                                </ul>

                                <div class="tab-content">

                                    <div role="tabpanel" class="tab-pane fade in active" id="profile_settings">
                                        <form class="form-horizontal">
                                            <div class="form-group">
                                                <label for="NameSurname" class="col-sm-2 control-label">Nome</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="NameSurname" name="NameSurname"
                                                            placeholder="Nome" value="Saulo Lessa" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="Email" class="col-sm-2 control-label">Email</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="email" class="form-control" id="Email" name="Email"
                                                            placeholder="Email" value="exemplo@examplo.com" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="NameSurname" class="col-sm-2 control-label">CPF</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="NameSurname" name="NameSurname"
                                                            placeholder="Nome" value="114.094.084-85" disabled>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-danger">ALTERAR</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div role="tabpanel" class="tab-pane fade in" id="change_password_settings">
                                        <form class="form-horizontal">
                                            <div class="form-group">
                                                <label for="OldPassword" class="col-sm-3 control-label">Senha atual</label>
                                                <div class="col-sm-9">
                                                    <div class="form-line">
                                                        <input type="password" class="form-control" id="OldPassword"
                                                            name="OldPassword" placeholder="Digite a senha atual"
                                                            required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="NewPassword" class="col-sm-3 control-label">Nova senha</label>
                                                <div class="col-sm-9">
                                                    <div class="form-line">
                                                        <input type="password" class="form-control" id="NewPassword"
                                                            name="NewPassword" placeholder="Nova senha" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="NewPasswordConfirm" class="col-sm-3 control-label">Confirme
                                                    a senha</label>
                                                <div class="col-sm-9">
                                                    <div class="form-line">
                                                        <input type="password" class="form-control" id="NewPasswordConfirm"
                                                            name="NewPasswordConfirm" placeholder="Nova senha (confirmação)"
                                                            required>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-offset-3 col-sm-9">
                                                    <button type="submit" class="btn btn-danger">ALTERAR</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/jquery.slimscroll.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/waves.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
    
    <script src="<%=request.getContextPath()%>/resources/js/profile.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/demo.js"></script>
</body>

</html>