<div class='col-sm-6 col-md-3 text-center'>
		<h2>Crear animal en el zoo '${nombreZooActual }'</h2>
		<g:form action= 'crearAnimal' controller='principalZoo'>
			
			<label>Nombre</label>
			<input type='text' value='' name='nombre' placeholder='Nombre'><br>
			<label>Alias</label>
			<input type='text' value='' name='alias' placeholder='Alias'><br>
			<label>Cantidad</label>
			<input type='number' value='' name='cantidad' min=0 placeholder='Cantidad'>
			<br>
			<label>Familia</label>
				<select name='familia'>
					<g:render template='../animal/selectFamilia' model="[datosAnimal:datosAnimal]"/>
				</select>
				<!--<g:render template='../zoo/listaBBDD' model="[listaZoo:listaZoo]"/>-->
				<input type='hidden' value=${nombreZooActual} name='nombreZooActual'>
				
			<input type='submit' value='Crear'>
		
		</g:form>	
</div>	