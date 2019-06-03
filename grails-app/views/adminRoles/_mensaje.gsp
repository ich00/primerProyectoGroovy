<g:if test="${flash.message}">
		<div class="alert alert-info">

			<strong>Info! </strong>
			${flash.message}
			<ul>
				<g:each in="${eliminaRoles}" var="rol">
					<li>${rol}</li>
				</g:each>
			</ul>
			

		</div>
	</g:if>