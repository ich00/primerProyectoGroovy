
	
<div class='col-md-2 crear'>
		<h2>Crear Zoo</h2>
		<g:form action= 'crearZoo' controller='principalZoo'>
		
			<h4>Nombre</h4>
			<input type='text' value='' name='nombre' placeholder='Nombre'>
			<h4>Comunidad</h4>
			<select name='provincia' value='provincia'>
				<g:render template='../comunidad/opciones' model="[datosZoo:datosZoo]"/>
			</select>
			<br><br>
			<input type='submit' value='Crear'>
		
		</g:form>	
</div>	
