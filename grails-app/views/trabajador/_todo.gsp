
<div class='col-sm-9 col-md-9 text-center'>
	
	<g:if test="${mensaje==1 || mensaje ==3}">
		<div class="alert alert-warning" role="alert">
			NO HAY TRABAJADORES EN ESTE ZOO
		</div>
	</g:if>
	<g:else>
		<h3>Listado de Trabajadores</h3>
		<table align=center class='table-bordered'>

			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Id empleado</th>
					<th>Id zoo</th>
					<th></th>
					<th></th>

				</tr>
			</thead>

			<tbody>
				<g:each in="${relacionTrabajadorZoo}" var="relacion">
					<tr>
						<td>
							${relacion.trabajador.nombre}
						</td>
						<td>
							${relacion.trabajador.apellidos}
						</td>
						<td>
							${relacion.idEmpleado}
						</td>
						<td>
							${relacion.zoo.nombre}
						</td>

						<td><g:link controller="PrincipalZoo"
								action="editarTrabajador"
								params="[idEmpleado: relacion.idEmpleado, nombreTrabajador:relacion.trabajador.nombre,nombreZooActual:nombreZooActual]">
								<g:img dir="images" file="edit.png" width="30" height="30" />
							</g:link></td>
						<td><g:link controller="PrincipalZoo"
								action="borrarTrabajador"
								params="[nombreTrabajador:relacion.trabajador.nombre, nombreZooActual:nombreZooActual]">
								<g:img dir="images" file="delete.png" width="30" height="30" />
							</g:link></td>

					</tr>

				</g:each>
			</tbody>
		</table>
	</g:else>
</div>

<div class=' col sm-3 col-md-3 text-center '>
		<h2>Crear trabajador en el zoo '${nombreZooActual}'</h2>
		<g:form action= 'crearTrabajador' controller='principalZoo'>
			
			<label>Nombre</label>
			<input type='text' value='' name='datosTrabajador.nombre' placeholder='Nombre'><br>
			<label>Apellidos</label>
			<input type='text' value='' name='datosTrabajador.apellidos' placeholder='Apellidos'><br>
		
			<br>
			
				<!--<g:render template='../zoo/listaBBDD' model="[listaZoo:listaZoo]"/>-->
			<input type='hidden' value=${nombreZooActual} name='datosZoo.nombre'>
				
			<input type='submit' value='Crear'>
		
		</g:form>	
</div>	