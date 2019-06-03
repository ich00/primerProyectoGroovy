<html>
	<g:render template='../principalZoo/headTablas' />
	<body>
		<g:render template='../principalZoo/navbar' />
		
		<div  id="pantalla" >
			<div class=" col-lg-6 col-md-6 col-xs-6 text-center" id="prueba">
				<h2>Administración de Datos</h2>
				<h4>Provincias y Familias de Animales</h4>
				<a class="btn btn-default"  href="/zoo/administracion/index">Ir a datos</a>
			</div>
			
			<div class="col-lg-6 col-md-6 col-xs-6 text-center" id="prueba2">
				<h2>Administración de Roles</h2>
				<h4>Administrar roles de usuarios</h4>
				<div class="btn btn-default">
					<g:remoteLink action="listarUsuarios" controller="AdminRoles" update="pantalla">Ir a roles</g:remoteLink>
				</div>
			</div>
		</div>
	</body>
</html>