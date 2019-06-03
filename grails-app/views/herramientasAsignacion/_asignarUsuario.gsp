<div class="col-xs-6 col-md-6 ">
		<h3>Asignar los roles del usuario:</h3>
		<select id="usuarioAsig" onchange="mostrarUsuario()">
			<option value=""></option>
			<g:each in="${listaUsuarios}" var="usuarioRol">
				<option value="${usuarioRol.nombre}">
					${usuarioRol.nombre}
				</option>
			</g:each>
		</select>
	</div>
	
<script>
function mostrarUsuario() {
	var x = document.getElementById("usuarioAsig").value;
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

</script>