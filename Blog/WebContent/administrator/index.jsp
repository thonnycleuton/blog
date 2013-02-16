<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo de Listagem</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/style2.css'/>" />
</head>
<body>
	<div id="body">
		<header>
		<div id="logo">
			<h2>
				<a href="#">Blog do Thonny</a>
			</h2>
		</div>
		<nav>
			<c:import url="menu.jsp"></c:import>
		</nav> </header>
		<div id="center">
			<div class="breadcrumb">
				<c:import url="usuario_logado.jsp"></c:import>
			</div>
			<aside>
				<c:import url="loginForm.jsp"></c:import>
			</aside>
			<article>
			<div id="content-top">
				<c:import url="artigoList.jsp"></c:import>
				<c:import url="usuarioList.jsp"></c:import>
				<c:import url="novoArtigo.jsp"></c:import>
				<c:import url="novoUsuario.jsp"></c:import>
			</div>
			<br />
			</article>
			<section>
			</section>
		</div>
		<footer>
		<p>
			Copyright (c) 2012 <a href="http://www.thonnycleuton.com">thonnycleuton.com</a>.
			All rights reserved. Design by Thonny Cleuton
		</p>
		</footer>
	</div>
	</div>
</body>
</html>