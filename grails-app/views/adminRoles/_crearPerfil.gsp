<div class="col-md-6">
	
	
	
	
	<h3>Crear Perfil</h3>
	<g:formRemote name="crearPerfil"
		url="[controller:'AdminRoles', action: 'crearPerfil']"
		update="pantalla">
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<div class="input-group-addon">Nombre</div>
			<input type="text" class="form-control"
				id="inlineFormInputGroupUsername2" name="nombre"
				placeholder="nombre">
		</div>
		<br>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<div class="input-group-addon">Roles incluidos</div>
			<select name="roles" id="prueb" multiple="multiple"
				class="custom-select mb-2 mr-sm-2 mb-sm-0"
				id="inlineFormCustomSelectPref">
				<g:each in="${listaRoles}" var="rol">
					<option value="${rol.nombre}">
						${rol.nombre}
					</option>
				</g:each>
			</select>
		</div>


		<script>
        $("prueb").multiselect({
            width: 460,
            multiple: true,
            multipleWidth: 55
        });
    </script>

		<br>
		<input type='submit' value='Crear' class=" btn btn-primary">
	</g:formRemote>



</div>