<html>
	<!-- LA CABECERA ESTÁ EN UN TEMPLATE -->
	<g:render template='headTablas' model="[datosAnimal:datosAnimal]"/>
	
	<body>
		<g:render template='navbar' />
		<div class='text-center'>
			<h2>Formulario editar Trabajador</h2>
			<g:form action= 'actualizarTrabajador' controller='principalZoo'>
				<input type="hidden" name="nombreActualBBDD" value="${datosTrabajador.nombre}">
				<input type="hidden" name="nombreZooActual" value="${nombreZooActual}">
				
				<h3>Nombre del Trabajador</h3>
				<input type='text' value='${datosTrabajador.nombre}' name='nombre' >
				<h3>Apellidos</h3>
				<input type='text' value='${datosTrabajador.apellidos}' name='apellidos' >
				<h3>ID Empleado</h3>
				<input type='text' value='${idEmpleado}' disabled >
				<br><br>
				<input type='submit' value='modificar'>
		
			</g:form>	
		</div>
	</body>
	<g:render template='footer' />
</html>