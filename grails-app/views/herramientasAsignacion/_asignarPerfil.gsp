<div class="col-xs-6 col-md-6 ">
	<h3>Asignar Perfil</h3>
	<select id="perfilAsignar" onchange="mostrarPerfil()">
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
		var x = document.getElementById("perfilAsignar").value;
		var y = document.getElementById("nombreUsuario").value;
		//document.getElementById("listaRoles").innerHTML = "<h2 class='text-center'>Perfil seleccionado: " + x+"</h2>";

		$.ajax({
			type : "GET",
			url : '/zoo/adminRoles/mostrarPerfil',
			data : {
				'nombreUsuario' : y,
				'perfil' : x
			},
			success : function(data) {
				$('#pantalla').html(data);
			}

		});

	}
</script>