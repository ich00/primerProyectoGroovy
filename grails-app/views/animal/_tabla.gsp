<div class ='col-md-7 text-center'>

	<g:if test="${datosAnimal.size()==0}">
		<div class="alert alert-warning" role="alert">
			NO HAY ANIMALES EN LA FAMILIA INDICADA
		</div>

	</g:if>

	<g:else>
	<h3>Listado de Animales</h3>
	<table align=center class='table-bordered'>

	<thead>
		<tr>
			<th>Nombre</th>
			<th>Alias</th>
			<th>Cantidad</th>
			<th>Familia</th>
			<th></th>
			<th></th>
			
		</tr>
		
	</thead>
	
	<tbody>
		<g:each in ="${datosAnimal}" var="datos">
			<tr >
				<td>${datos.nombre}</td> 
				<td>${datos.alias}</td> 
				<td>${datos.cantidad}</td>
				<td>${datos.familia.nombre}</td>
				<td>
					<g:link controller="PrincipalZoo" action="editarAnimal" params="[nombreAnimal:datos.nombre,nombreZooActual:nombreZooActual]">
						<g:img dir="images" file="edit.png" width="30" height="30"/>
					</g:link>	
				</td>
				<td>
					<g:link controller="PrincipalZoo" action="mostrarFormularioBorrarAnimal" params="[nombreAnimal:datos.nombre, nombreZooActual:nombreZooActual]">
						<g:img dir="images" file="delete.png" width="30" height="30"/>
					</g:link>	
				</td>
				
			</tr>
			
		</g:each>
	</tbody>
	</table>
	</g:else>
</div>