<g:render template='../adminRoles/mensaje' />

<div class="row">
<div class="col-xs-9 col-md-9">
	<h2 class="text-center">Listado de Usuarios</h2>


	<table class="table-bordered">

		<tr>
			<th>Usuario</th>
			<th>Ver Roles</th>
		</tr>
		<g:each in="${usuarios}" var="usuario">
			<tr>
				<td width="70%">
					${usuario.nombre}
				</td>
				<td width="30%">
				<g:if test="${usuario.perfil!=null}">
					<g:remoteLink  controller="AdminRoles" action="mostrarPerfilUsuario" params="[nombreUsuario:usuario.nombre]" update="pantalla">
						<g:img dir="images" file="perfil.png" width="120" height="25" />
					</g:remoteLink>
				</g:if>
				<g:else>
					<g:remoteLink  controller="AdminRoles" action="listarRoles" params="[nombreUsuario:usuario.nombre]" update="pantalla">
						<g:img dir="images" file="view.png" width="50" height="30" />
					</g:remoteLink>
				</g:else>
				</td>
			</tr>
		</g:each>
	</table>
	
</div>
</div>
<div class="col-xs-12 col-md-12 row">
	<g:link controller="AdminRoles" action="index" >
				<g:img dir="images" file="atras.png" width="30" height="30" />
		</g:link>
</div>


