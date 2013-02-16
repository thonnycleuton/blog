<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<span class="label">alice</span> <span class="label">story</span> <span
					class="label">blog</span> <span class="label">personal</span>
			</div>
		</div>
	</div>
</c:forEach>