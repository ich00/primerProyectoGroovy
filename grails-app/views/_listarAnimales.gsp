<div class= 'text-center col-md-9'>
		<h2>${nombreZooActual.toUpperCase()}</h2>
</div>
	
<div id="templateTablaAnimal">
		<g:render template='tablaAnimales' model="[datosAnimal:datosAnimal, nombreZoo:nombreZooActual]"/>
</div>
	<g:render template='filtroFamiliaAnimal' model="[datosAnimal:datosAnimal, nombreZooActual:nombreZooActual, datosFamilia:datosFamilia]"/>
	<g:render template='crearAnimal' model="[datosAnimal:datosAnimal, nombreZoo:nombreZooActual]"/>