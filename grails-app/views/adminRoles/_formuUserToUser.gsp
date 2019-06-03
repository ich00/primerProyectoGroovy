<div class="text-center">
<g:formRemote name="asignarUserToUser" url="[action:'asignarUserToUser', controller:'AdminRoles']" update="pantalla">
	<input type='hidden' value=${nombreUsuario} name='nombreUsuario'>
	<input type='hidden' value=${userBase} name='userBase'>
	<h4>Roles para el usuario ${nombreUsuario.toUpperCase()} heredados de ${userBase.toUpperCase()}</h4>
	<g:each in="${nombreRolesFinales}" var="rol">
		<input type="checkbox" value="${rol}" name="rol" checked>${rol}<br>
	</g:each>
	<g:each in="${listaDisponibles}" var="rol">
		<input type="checkbox" value="${rol}" name="rol" >${rol}<br>
	</g:each>
	<input type="submit" value="actualizar">
</g:formRemote>
</div>