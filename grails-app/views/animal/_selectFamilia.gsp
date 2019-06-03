
<optgroup label="Familias">
				
				
				<g:each in="${datosFamilia}" var="familia">
				
					<g:if test="${datosAnimal.familia.nombre == familia}">
						<option value='${familia.nombre}' selected>${familia.nombre}</option>
					</g:if>
					<g:else>
						<option value='${familia.nombre}'>${familia.nombre}</option>
					</g:else>
				</g:each>
</optgroup>
