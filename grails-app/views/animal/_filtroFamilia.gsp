<div class='col-sm-6 col-md-2 text-center'>
	<h2>Filtro por Familias</h2>
	<g:formRemote name='filtroFamilias'  url="[controller: 'PrincipalZoo', action:'filtrarAnimalByFamilia']" update='templateTablaAnimal' >
		<input type="hidden" name="nombreZooActual" value="${nombreZooActual}">
		<select name='familia'>
			<optgroup label="General">
				<option value='todos'>Listar TODOS</option>
			</optgroup>
			<g:render template='../animal/selectFamilia' model="[datosAnimal:datosAnimal, datosFamilia:datosFamilia]"/>
		</select>
		<br><br>
		<input type='submit' value='Filtrar'>
	</g:formRemote>
</div>
