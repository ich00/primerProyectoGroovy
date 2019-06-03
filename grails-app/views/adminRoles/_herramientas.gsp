<div class="row">
<div id='pruebita' class="col-md-6 col-xs-6">
<h3>Herramientas Perfil</h3><br>
<g:remoteLink controller="AdminRoles" action="formuCrearPerfil"  update="pruebita2">
<span class="fa-stack fa-lg">
  <i class="fa fa-square-o fa-stack-2x"></i>
  <i class="fa fa fa-plus fa-stack-1x"></i>
</span>
Crear Perfil<br>
</g:remoteLink>

<g:remoteLink controller="AdminRoles" action="selectModPerfil"  params="[nombreUsuario:nombreUsuario]" update="pruebita2">
<span class="fa-stack fa-lg">
  <i class="fa fa-square-o fa-stack-2x"></i>
  <i class="fa fa fa-pencil fa-stack-1x"></i>
</span>
Modificar Perfil<br>
</g:remoteLink>

<g:remoteLink controller="AdminRoles" action="formuBorrarPerfil"  update="pruebita2">
<span class="fa-stack fa-lg">
  <i class="fa fa-square-o fa-stack-2x"></i>
  <i class="fa fa fa-eraser fa-stack-1x"></i>
</span>
Borrar Perfil<br>
</g:remoteLink>

<g:remoteLink controller="AdminRoles" action="borrarPerfilUser" params="[nombreUsuario:nombreUsuario]" update="pantalla">
<span class="fa-stack fa-lg">
  <i class="fa fa fa-id-card-o fa-stack-1x"></i>
  <i class="fa fa-ban fa-stack-2x text-danger"></i>
</span>
Borrar el perfil/roles del usuario actual<br>
</g:remoteLink>

</div>

<div id="pruebita2" class="col-md-6 col-xs-6">
<h3>Herramientas de Asignacion</h3><br>
<g:remoteLink controller="AdminRoles" action="asigPerfil" params="[nombreUsuario:nombreUsuario]" update="pruebita">
<span class="fa-stack fa-lg">
  <i class="fa fa-square-o fa-stack-2x"></i>
  <i class="fa fa fa-id-card-o fa-stack-1x"></i>
</span>
Asignar Perfil<br>
</g:remoteLink>

<g:remoteLink controller="AdminRoles" action="asigUsuario" params="[nombreUsuario:nombreUsuario]" update="pruebita">
<span class="fa-stack fa-lg">
  <i class="fa fa-square-o fa-stack-2x"></i>
  <i class="fa fa fa-user-o fa-stack-1x"></i>
</span>
Asignar roles de otro usuario<br>
</g:remoteLink>



</div>


</div>