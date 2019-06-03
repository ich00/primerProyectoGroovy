<div class= 'text-center col-md-9'>
		<h2>${nombreZooActual.toUpperCase()}</h2>
</div>
	
	<div id="templateTablaAnimal">
		<g:if test="${mensaje==2 || mensaje==3}">
			<div class="alert alert-warning  col-md-9 text-center" role="alert">
					NO HAY ANIMALES EN ESTE ZOO
			</div>
		</g:if>
		<g:else>
			<g:render template='../animal/tabla' model="[datosAnimal:datosAnimal, nombreZoo:nombreZooActual]"/>
			<g:render template='../animal/filtroFamilia' model="[datosAnimal:datosAnimal, nombreZooActual:nombreZooActual, datosFamilia:datosFamilia]"/>
		</g:else>
	</div>
	
	<g:render template='../animal/crear' model="[datosAnimal:datosAnimal, nombreZoo:nombreZooActual]"/>