<div class='col-md-7 text-center'>

	<g:render template="../zoo/tituloTabla" model="[datosZoo:datosZoo, titulo:titulo]"/>
	<g:if test="${datosZoo.size()==0}">
		<div class="alert alert-warning" role="alert">NO HAY ZOOS EN
			ESTA COMUNIDAD</div>

	</g:if>

	<g:else>
		<table class='table-bordered'>

			<thead>
				<tr>
					<th>Nombre</th>
					<th>Provincia</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>

			</thead>

			<tbody>
				<g:each in="${datosZoo}" var="datos">
					<tr>
						<td>
							${datos.nombre}
						</td>
						<td>
							${datos.comunidad?.nombre}
						</td>
						<td><g:link id='enlace' controller="PrincipalZoo"
								action="editarZoo" params="[nombreZooActual:datos.nombre]">
								<g:img dir="images" file="edit.png" width="30" height="30" />
							</g:link></td>
						<td><g:link controller="PrincipalZoo" action="borrarZoo"
								params="[nombreZooActual:datos.nombre]">
								<g:img dir="images" file="delete.png" width="30" height="30" />
							</g:link></td>
						<td><g:link controller="PrincipalZoo"
								action="mostrarAnimalesTrabajadores"
								params="[nombreZooActual:datos.nombre]">
								<g:img dir="images" file="view.png" width="30" height="30" />
							</g:link></td>

					</tr>

				</g:each>
			</tbody>
		</table>
	</g:else>


</div>