<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="usuario" items="${usuarios}">
	<tr>
		<td>${usuario.id}</td>
		<td><a href="usuario?acao=edit&id=${usuario.id}">${usuario.nome}</a></td>
	</tr>
</c:forEach>
