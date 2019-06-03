<html>
<g:render template='headTablas' model="[datosZoo:datosZoo]" />
<body>
	<g:render template='navbar' />
	<g:render template='../zoo/mensaje' />
	<div class='container'>
		<div class='row'>

			<div id="templateTablaZoo">
				<g:render template="../zoo/tabla" model="[datosZoo:datosZoo]" />
			</div>


			<g:render template='../comunidad/filtro'
				model="[datosZoo:datosZoo, datosComunidad:datosComunidad]" />



			<g:render template='../zoo/crear' model="[datosZoo:datosZoo]" />
		</div>
	</div>


</body>
<g:render template='footer' />
</html>
