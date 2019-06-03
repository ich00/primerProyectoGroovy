<div class='maestros'>
	<g:if test="${error==1}">
		<div class="alert alert-warning" role="alert">
			NO HAY COMUNIDADES PREVIAMENTE CREADAS
		</div>
	</g:if>
	<g:else>
		<div class="alert alert-warning" role="alert">
			${flash.message}
		</div>
		
		<g:form action='cargaComunidades' controller='principalZoo'>
			<label> Cargar Nueva Comunidad</label>
			<input type=text name='comunidad' value=''
				placeholder='nombre comunidad'>
			<input type='submit' value='Añadir'>
		</g:form>
	</g:else>

	<g:if test="${error==1}">
		<div class="alert alert-warning" role="alert">
			NO HAY FAMILIAS PREVIAMENTE CREADAS
		</div>
	</g:if>
	<g:else>
		<div class="alert alert-warning" role="alert">
			${flash.message}
		</div>
		<g:form action='cargaFamilias' controller='principalZoo'>
			<label> Cargar Nueva Familia</label>
			<input type=text name='familia' value='' placeholder='nombre familia'>
			<input type='submit' value='Añadir'>
		</g:form>
	</g:else>
</div>