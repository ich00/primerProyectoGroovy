<h4>Selecciona el Perfil a modificar</h4>
<select id="perfilSelect" onchange="modificarPerfil()">
	<option value=""></option>
	<g:each in="${listaPerfiles}" var="perfil">
		<option value="${perfil.nombre}">
			${perfil.nombre}
		</option>
	</g:each>
</select>

<script>
	function modificarPerfil() {
		var x = document.getElementById("perfilSelect").value;
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