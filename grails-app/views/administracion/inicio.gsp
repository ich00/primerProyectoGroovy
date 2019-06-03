<html>
<g:render template='../principalZoo/headTablas'
	model="[datosZoo:datosZoo]" />
<body>
	<g:render template='../principalZoo/navbar' />
	<div class='text-center admin'>
		<h3>CONSOLA DE ADMINISTRACIÓN</h3>
	</div>
	
	<div class='text-center'>
		<g:if test="${flash.message}">
		<div class='row alert alert-info' role="info">
			${flash.message}
		</div>
		</g:if>
	</div>
	
	<div class='row'>
		<div class='container'>
		
			<div class='col-md-6'>
			
				<g:render template='listaFamilias' model="[listaFamilias:listaFamilias]" />
				<g:render template='crearFamilia' />
				
			</div>

			<div class='col-md-6'>
				
				<g:render template='listaComunidades' model="[listaComunidades:listaComunidades]" />
				<g:render template='crearComunidad'/>
				
			</div>
		</div>
	</div>
</body>

<g:render template='../principalZoo/footer' />

</html>