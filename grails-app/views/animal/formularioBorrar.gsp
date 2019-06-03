<html>
	<!-- LA CABECERA ESTÁ EN UN TEMPLATE -->
	<g:render template='headTablas' model="[datosAnimal:datosAnimal]"/>
	<body>
		<div class='row text-center'>
			<div class='container'>
				<h2>FORMULARIO PARA BORRAR ANIMALES</h2>
			</div>
		</div>
		<div class='row text-center'>
			<div class='container'>
				<g:form action= 'borrarNumeroAnimales' controller='principalZoo'>
					<input type="hidden" name="nombreActualBBDD" value="${datosAnimal.nombre}">
					<input type="hidden" name="nombreZooActual" value="${nombreZooActual}">
					<h4>Nombre del Animal</h4>
					<input type='text' value='${datosAnimal.nombre}' name='nombre' disabled>
					<h4>Alias</h4>
					<input type='text' value='${datosAnimal.alias}' name='alias' disabled >
					<h4>Cantidad a borrar</h4>
					<input type='number' max='${datosAnimal.cantidad}' value='${datosAnimal.cantidad}' name='cantidad' >
					<br><br>
					<input type='submit' value='Borrar'>
				</g:form>
			</div>
		</div>
	</body>
	<g:render template='footer' />
</html>