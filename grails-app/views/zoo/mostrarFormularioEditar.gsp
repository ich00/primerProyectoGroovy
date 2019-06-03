<html>
	<!-- LA CABECERA ESTÁ EN UN TEMPLATE -->
	<g:render template='headTablas' model="[datosAnimal:datosAnimal]"/>
	
	<body>
	
	<g:render template='navbar' />
		<div class="row text-center">
			<h2>Formulario Editar Zoo</h2>
			<g:form action= 'actualizarZoo' controller='principalZoo'>
			<input type="hidden" name="nombreActualBBDD" value="${datosZoo.nombre}">
			<h3>Nombre del Zoo</h3>
			<input type='text' value='${datosZoo.nombre}' name='nombre' >
			<h3>Provincia</h3>
				<select name='comunidad' >
					<g:render template='../comunidad/opciones' model="[datosZoo:datosZoo, datosComunidad:datosComunidad]"/>
				</select>
				
			<br><br>
			<input type='submit' value='modificar'>
		
			</g:form>	
		</div>
	</body>
	<g:render template='footer' />
</html>