<optgroup label="Comunidades">
				
				
				<g:each in="${datosComunidad}" var="comunidad">
					
					<g:if test="${datosZoo.comunidad.nombre == comunidad.nombre}">
						<option value='${comunidad.nombre}' selected>${comunidad.nombre}</option>
					</g:if>
					<g:else>
						<option value='${comunidad.nombre}'>${comunidad.nombre}</option>
					</g:else>
				
				
				</g:each>
				
</optgroup>