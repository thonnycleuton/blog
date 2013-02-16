<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="usuario?acao=save" method="POST">
	<fieldset>
		<div id="legend">
			<legend class="">Cadastro</legend>
		</div>
		<div class="control-group">
			<!-- Username -->
			<label class="control-label" for="username">Nome de Usuario</label>
			<div class="controls">
				<input type="text" id="username" name="nome" placeholder=""
					class="input-xlarge">
			</div>
		</div>

		<div class="control-group">
			<!-- E-mail -->
			<label class="control-label" for="email">E-mail</label>
			<div class="controls">
				<input type="text" id="email" name="email" placeholder=""
					class="input-xlarge">
			</div>
		</div>

		<div class="control-group">
			<!-- Password-->
			<label class="control-label" for="password">Senha</label>
			<div class="controls">
				<input type="password" id="password" name="password" placeholder=""
					class="input-xlarge">
				<p class="help-block">Use letras e numeros</p>
			</div>
		</div>

		<div class="control-group">
			<!-- Password -->
			<label class="control-label" for="password_confirm">Password
				(Confirm)</label>
			<div class="controls">
				<input type="password" id="password_confirm" name="password_confirm"
					placeholder="" class="input-xlarge">
				<p class="help-block">Confirme sua senha</p>
			</div>
		</div>

		<div class="control-group">
			<!-- Button -->
			<div class="controls">
				<button class="btn btn-success">Register</button>
			</div>
		</div>
	</fieldset>
</form>