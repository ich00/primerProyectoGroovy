<html>
	<!-- LA CABECERA ESTÁ EN UN TEMPLATE -->
	<g:render template='headTablas' model="[datosAnimal:datosAnimal]"/>
	<body>
		<g:render template='navbar' />
		<div class='row'>
			
				<g:render template='../animal/listar' model="[mensaje:mensaje, datosAnimal:datosAnimal, datosFamilia:datosFamilia, nombreZooActual:nombreZooActual]"/>
		
		</div>
		<div class='row'>
			
				<g:render template='../trabajador/todo' model="[mensaje:mensaje, relacionTrabajadorZoo:relacionTrabajadorZoo, nombreZooActual:nombreZooActual]"/>
			
		</div>
		
	</body>
	<g:render template='footer' />
</html>