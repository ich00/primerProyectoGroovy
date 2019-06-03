<div class="text-center">
	<h3>
		Asignar al usuario
		${nombreUsuario}
		el perfil
		${nombrePerfil}
	</h3>
	<p>Con los siguientes roles predeterminados</p>

	<g:formRemote name="asignarPerfil"
		url="[action:'asignarPerfil', controller:'AdminRoles']"
		update="pantalla">
		<input type='hidden' value=${nombreUsuario} name='nombreUsuario'>
		<input type='hidden' value=${nombrePerfil} name='nombrePerfil'>
		<g:each in="${listaRolesPerfil}" var="rol">
			<input type="text" value=${rol.rol.nombre} name="rol" readonly>
		</g:each>
		<input  type='submit' value="Asignar">
	</g:formRemote>

</div>