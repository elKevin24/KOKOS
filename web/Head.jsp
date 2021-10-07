<%-- 
    Document   : Head
    Created on : 30/07/2021, 22:59:28
    Author     : busqu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Kokos Boutique</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->

        <link rel="shortcut icon" href="img/96373814_3099854576704202_3819088845203308544_n.ico">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
    </head>
    <body>
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss"><i class="icon-close"></i></button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..." class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand --><a href="Menu.jsp" class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block"><span>KOKOS  </span><strong>BOUTIQUE</strong></div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>KB</strong></div></a>
                                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                                <!-- Search-->
                               
                                <!-- Logout    -->
                                <li class="nav-item"><a href="Login.jsp" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch"> 
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar"><img src="img/t1.png" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="title">
                            <h1 class="h4">KOKOS BOUTIQUE</h1>
                            <p>ZACAPA</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
                    <ul class="list-unstyled">


                        <li><a href="#Articulos" aria-expanded="false" data-toggle="collapse"> <i class="icon-grid"></i>Inventario</a>
                            <ul id="Articulos" class="collapse list-unstyled ">
                                <li><a href="Agregar_Articulo.jsp">Agregar</a></li>
                                <li><a href="Consultar_Inventario.jsp">Consulta</a></li>
                            </ul>
                        </li><!-- comment -->
                        
                        <li><a href="#Envios" aria-expanded="false" data-toggle="collapse"> <i class="fa fa-bar-chart"></i>Envios</a>
                            <ul id="Envios" class="collapse list-unstyled ">
                                <li><a href="Agregar_Envio.jsp">Agregar Envio</a></li>
                                <li><a href="Consultar_Envio.jsp">Consulta Envio</a></li>
                            </ul>
                        </li><li><a href="#Cheques" aria-expanded="false" data-toggle="collapse"> <i class="icon-check"></i>Poliza</a>
                            <ul id="Cheques" class="collapse list-unstyled ">
                                <li><a href="Agregar_Poliza.jsp">Agregar Poliza</a></li>
                                <li><a href="Consultar_Poliza.jsp">Consultar Polizas</a></li>
                            </ul>
                        </li>
                        
                </nav>
               
                    <!-- Dashboard Counts Section-->
