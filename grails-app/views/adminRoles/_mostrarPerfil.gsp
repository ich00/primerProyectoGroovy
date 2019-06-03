<div id="listaRoles">
<g:formRemote name="perfil" url="[action:'listarUsuarios', controller:'AdminRoles']" update="pantalla">
	<input type="hidden" value="${nombreUsuario}" name="nombreUsuario" id="nombreUsuario">
	
	<h3>El usuario "${nombreUsuario}" tiene el perfil "${perfilUsuario}" </h3>
	<p>El perfil de este usuario tiene los siguientes roles incluidos:</p>
	<ul class="fa-ul">
		<g:each in="${rolesPerfil}" var="rol">
			<li><i class="fa-li fa fa-check-square"></i>${rol.rol.nombre}</li>
		</g:each>
	</ul>
	<input type="submit" value="Listo">
</g:formRemote>

<g:render template="herramientas" model="[nombreUsuario:nombreUsuario]"></g:render>
</div>