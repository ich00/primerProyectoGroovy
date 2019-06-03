<html>
	<!-- LA CABECERA ESTÁ EN UN TEMPLATE -->
	<g:render template='headTablas' model="[datosAnimal:datosAnimal]"/>
	
	<body>
		<div class='text-center'>
			<g:form action= 'actualizarAnimal' controller='principalZoo'>
				<input type="hidden" name="nombreActualBBDD" value="${datosAnimal.nombre}">
				<input type="hidden" name="nombreZooActual" value="${nombreZooActual}">
				<h3>Nombre del Animal</h3>
				<input type='text' value='${datosAnimal.nombre}' name='nombre' >
				<h3>Alias</h3>
				<input type='text' value='${datosAnimal.alias}' name='alias' >
				<h3>Cantidad</h3>
				<input type='number' min=0 value='${datosAnimal.cantidad}' name='cantidad' >
				<h3>Familia</h3>
				<select name='familia'>
					<g:render template='../animal/selectFamilia' model="[datosAnimal:datosAnimal]"/>
				</select>	
				<br><br>
				<input type='submit' value='modificar'>
		
			</g:form>	
		</div>
	</body>
	<g:render template='footer' />
</html>