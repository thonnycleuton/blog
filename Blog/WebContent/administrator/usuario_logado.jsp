<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${usuario == null}">
	Ol� Visitante! <a href="userlogin">Log In</a>
</c:if>
<c:if test="${usuario != null}">
	Ol� ${usuario} <a href="userlogout">Log Out</a>
</c:if>