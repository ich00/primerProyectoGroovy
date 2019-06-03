<div class="col-md-6">
	<h4>Borrar Perfil</h4>
	<g:formRemote name="borrarPerfil" url="[controller:'AdminRoles', action: 'borrarPerfil']" update="pantalla">
		<input type='hidden' value=${nombreUsuario} name='nombreUsuario'>
		<select name="nombrePerfil">
			<option></option>
			<g:each in="${listaPerfiles}" var="perfil">
				<option value="${perfil.nombre}">${perfil.nombre}</option>
			</g:each>
		</select>
		<input type='submit' value='Eliminar' class="btn btn-danger">
	</g:formRemote>

</div>