<div class="container">
	<div class="row">
		<div class="span4 offset4 well">
			<form method="POST" action="userlogin">
				<input type="text" id="username" class="span4" name="username"
					placeholder="nome de usuario"> <input type="password"
					id="password" class="span4" name="password" placeholder="senha">
				<label class="checkbox"> <input type="checkbox"
					name="remember" value="1"> Lembrar-me
				</label>
				<%=(request.getAttribute("message") == null ? "&nbsp"
					: request.getAttribute("message"))%>
				<button type="submit" name="submit" class="btn btn-info btn-block">Logar</button>
			</form>
		</div>
	</div>
</div>