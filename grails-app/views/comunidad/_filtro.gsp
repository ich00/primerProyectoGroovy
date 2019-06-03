<div class='col-md-3'>
	<h2>Filtro por Comunidades</h2>
	<g:formRemote name='filtroComunidades'  url="[controller: 'PrincipalZoo', action:'filtrarZooByComunidad']" update='templateTablaZoo' >
		<select name='provincia'>
			<optgroup label="General">
				<option value='todos'>Listar TODOS</option>
			</optgroup>
			<g:render template='../comunidad/opciones' model="[datosZoo:datosZoo, datosComunidad:datosComunidad]"/>
		</select>
		<input type='submit' value='Filtrar'>
	</g:formRemote>
</div>