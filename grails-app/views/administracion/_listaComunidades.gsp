
<div class='row '>
	<h3>Listado de Comunidades</h3>
	<ul>
		<g:each in="${listaComunidades}" var="comunidad">
			<li>
				${comunidad.nombre}
			</li>
		</g:each>
	</ul>


</div>