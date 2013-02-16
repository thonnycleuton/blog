<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="artigo?acao=save" method="post">
	<fieldset>
		<legend>Controls Bootstrap supports</legend>
		<div class="control-group">
			<input type="hidden" name="id" value="${artigo.id}"> <input
				type="hidden" name="autor" value="${usuario}"> <label
				class="control-label" for="input01">Título</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="titulo"
					value="${artigo.titulo}" required>
				<p class="help-block">Insira um título para a sua postagem</p>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="optionsCheckbox">Publicar</label>
			<div class="controls">
				<label class="checkbox"> <input type="checkbox"
					id="optionsCheckbox" value="option1"> Para que sua
					publicação apareça para o público marque esta opção
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="select01">Categoria</label>
			<div class="controls">
				<select id="select01">
					<option>Musica</option>
					<option>Pensamentos</option>
				</select>
			</div>
		</div>
		<!--           <div class="control-group"> -->
		<!--             <label class="control-label" for="fileInput">File input</label> -->
		<!--             <div class="controls"> -->
		<!--               <input class="input-file" id="fileInput" type="file"> -->
		<!--             </div> -->
		<!--           </div> -->
		<div class="control-group">
			<label class="control-label" for="textarea">Conteudo</label>
			<div class="controls">
				<textarea class="input-xlarge" id="textarea" name="conteudo"
					value="${artigo.conteudo} rows="3"></textarea>
			</div>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Salvar</button>
			<button class="btn">Cancelar</button>
		</div>
	</fieldset>
</form>