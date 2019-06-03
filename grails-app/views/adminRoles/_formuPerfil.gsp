<div class="text-center">
<g:formRemote name="modPerfil" url="[action:'actualizarPerfil', controller:'AdminRoles']" update="pantalla">
	<h4>Modificación del Perfil ${nombrePerfil.toUpperCase()}</h4>
	<input type="hidden" value="${nombrePerfil}" name='nombrePerfil'>
	Nombre: <input type="text" value="${nombrePerfil}" name='nombrePerfilNuevo' ><br>
	Roles:<br>
	<g:each in="${listaRolesPerfil}" var="rol">
	
		<input type="checkbox" value="${rol.rol.nombre}" name="rol" checked>${rol.rol.nombre}<br>
	</g:each>
	<g:each in="${listaDisponibles}" var="rol">
		<input type="checkbox" value="${rol}" name="rol" >${rol}<br>
	</g:each>
	<input type="submit" value="actualizar" class="btn btn-success">
</g:formRemote>
</div>