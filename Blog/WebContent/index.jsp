<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo de Listagem</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" />
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
		<ul>
			<li class="current_page_item"><a href="#" accesskey="1" title="">home</a>
			</li>
			<li><a href="error.jsp" accesskey="2" title="">error</a></li>
			<li><a href="dummy.jsp" accesskey="4" title="">dummy</a></li>
			<li><a href="loginForm.jsp" accesskey="5" title="">login Form</a></li>
			<li><a href="userlogout.action" accesskey="5" title="">Logout</a></li>
		</ul>
		</nav> </header>
		<div id="center">
			<aside>
			</aside>
			<article>
			<div id="content-top">
				<c:forEach var="artigo" items="${artigos}">
					<div class="span8">
						<h1>${artigo.titulo }</h1>
						<p>${artigo.conteudo}</p>
						<div>
							<span class="badge badge-success">Postado em <fmt:formatDate
									type="both" dateStyle="long" timeStyle="short"
									value="${artigo.data}" />
							</span>
							<div class="pull-right">
								<span class="label">alice</span> <span class="label">story</span>
								<span class="label">blog</span> <span class="label">personal</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<br />
			</article>
			<section> </section>
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