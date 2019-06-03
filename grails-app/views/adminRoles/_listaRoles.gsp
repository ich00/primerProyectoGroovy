
<div class="row" >

	<div class="col-xs-12 col-md-12" id="listaRoles">
		<g:render template='../adminRoles/mensaje'
			model="[eliminaRoles:eliminaRoles]" />
		<g:formRemote name="eliminacion"
			url="[controller: 'AdminRoles', action:'eliminarRoles']"
			update="pantalla">

			<input type="hidden" name="nombreUsuario" value="${nombreUsuario}">
			<h2>
				Listado de Roles Activos del Usuario
				${nombreUsuario.toUpperCase()}
			</h2>
			<table class="table-bordered">
				<tr>
					<th></th>
					<th>Roles Activos</th>

				</tr>
				<g:each in="${rolesUsuario}" var="rol">
					<tr>
						<td width="20%"><input type="checkbox" name="rol"
							value="${rol.rol.nombre}" /></td>
						<td width="80%">
							${rol.rol.nombre}
						</td>

					</tr>
				</g:each>
			</table>
			<input type="submit" value="Eliminar" class="btn btn-danger">
		</g:formRemote>

		<g:formRemote name="añadir"
			url="[controller: 'AdminRoles', action:'añadirRoles']"
			update="pantalla">

			<input type="hidden" name="nombreUsuario" value="${nombreUsuario}" id="nombreUsuario">
			<h2>
				Listado de Roles Disponibles para el Usuario
				${nombreUsuario.toUpperCase()}
			</h2>
			<table class="table-bordered">
				<tr>
					<th></th>
					<th>Roles Disponibles</th>

				</tr>
				<g:each in="${rolesRestantes}" var="rolUsuario">
					<tr>
						<td width="20%"><input type="checkbox" name="rol"
							value="${rolUsuario}" /></td>
						<td width="80%">
							${rolUsuario}
						</td>

					</tr>
				</g:each>
			</table>
			<input type="submit" value="Añadir" class="btn btn-success">
		</g:formRemote>

	</div>
</div><%--


<div class="row" id="row2">

	<div class="col-xs-3 col-md-3 ">
		<h3>Asignar Perfil</h3>
		<select id="perfil" onchange="mostrarPerfil()">
			<option value=""></option>
				<g:each in="${listaPerfiles }" var="perfil">
					<option value="${perfil.nombre}">
						${perfil.nombre}
					</option>
				</g:each>
		</select>
	</div>

	<script>
		function mostrarPerfil() {
			var x = document.getElementById("perfil").value;
			var y= document.getElementById("nombreUsuario").value;
			//document.getElementById("listaRoles").innerHTML = "<h2 class='text-center'>Perfil seleccionado: " + x+"</h2>";
			
			$.ajax({
				type: "GET",
				url:'/zoo/adminRoles/mostrarPerfil',
				data : {
					'nombreUsuario' : y,
					'perfil' : x
					},
					success: function(data) {
						$('#listaRoles').html(data);
						}

			});
				

		}
		
		function mostrarUsuario() {
			var x = document.getElementById("usuario").value;
			var y = document.getElementById("nombreUsuario").value;
			//document.getElementById("listaRoles").innerHTML = "<h2 class='text-center'>Usuario seleccionado: " + x+"</h2>";

			// alert("elemento: "+x)

			$.ajax({
				type : "GET",
				url : '/zoo/adminRoles/modificarUserToUser',
				data : {
					'usuarioBase' : x,
					'usuarioFinal': y
				},
				success : function(data) {

					$('#pantalla').html(data);

				}
			});
		}

		function modificarPerfil() {
			var x = document.getElementById("perfil1").value;
			//document.getElementById("listaRoles").innerHTML = "<h2 class='text-center'>Usuario seleccionado: " + x+"</h2>";
			// alert("elemento: "+x)

			$.ajax({
				type : "GET",
				url : '/zoo/adminRoles/modificarPerfil',
				data : {
					'nombrePerfil' : x
					
				},
				success : function(data) {

					$('#pantalla').html(data);

				}
			});
		}
	</script>

	<div class="col-xs-3 col-md-3 ">
		<h3>Asignar los roles del usuario:</h3>
		<select id="usuario" onchange="mostrarUsuario()">
			<option value=""></option>
			<g:each in="${listaUsuarios}" var="usuarioRol">
				<option value="${usuarioRol.nombre}">
					${usuarioRol.nombre}
				</option>
			</g:each>
		</select>
	</div>



	<div class="col-md-3 col-xs-3">

		<g:render template='../adminRoles/crearPerfil'
			model="[listaRoles:listaRoles, nombreUsuario:nombreUsuario]" />
	</div>


	<div class="col-md-3 col-xs-3">
		<g:render template='../adminRoles/borrarPerfil'
			model="[listaPerfiles:listaPerfiles, nombreUsuario:nombreUsuario]" />
	</div>
</div>

<div class="row col-md-12 col-xs-12" id="actualizar">
	<h3>Actualizar Perfil</h3>
		<select id="perfil1" onchange="modificarPerfil()">
			<option value=""></option>
				<g:each in="${listaPerfiles}" var="perfil">
					<option value="${perfil.nombre}">
						${perfil.nombre}
					</option>
				</g:each>
		</select>
	
</div>

--%>
<g:render template="herramientas" model="[nombreUsuario:nombreUsuario]"></g:render>
<br><br>
<g:remoteLink controller="AdminRoles" action="listarUsuarios"
			update="pantalla">
			<g:img dir="images" file="atras.png" width="60" height="60" />
		</g:remoteLink>
		
<br><br>

		