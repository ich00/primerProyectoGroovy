<h2>
	<!-- EL TITULO SEGÚN EL PARAMETRO QUE LE LLEGA LLAMADO TITULO DESDE CADA ACCIÓN -->
	<g:if test="${titulo=='titulo1'}">
	"Listado de Zoos"
	</g:if>
	<g:else>
	Listado de Zoos en Comunidad de ${provincia} : ${datosZoo.size()}
	</g:else>
</h2>