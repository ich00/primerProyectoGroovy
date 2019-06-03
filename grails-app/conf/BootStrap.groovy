class BootStrap {

	def init = { servletContext ->

		println "iniciando bootstrap"

		
		if(zoo.Comunidad.list().size()==0){
			def comunidades = [
				"Andalucía",
				"Aragón",
				"Canarias",
				"Cantabria",
				"Castilla y León",
				"Castilla-La Mancha",
				"Cataluña",
				"Ceuta",
				"Comunidad Valenciana",
				"Comunidad de Madrid",
				"Extremadura",
				"Galicia",
				"Islas Baleares",
				"La Rioja",
				"Melilla",
				"Navarra",
				"País Vasco",
				"Principado de Asturias",
				"Región de Murcia"
			]
			comunidades.each{comunidad->
	
				def nuevaComunidad = new zoo.Comunidad()
				nuevaComunidad.nombre= comunidad
	
				if(nuevaComunidad.validate()){
					nuevaComunidad.save(flush:true)
				}else{
					println nuevaComunidad.errors
				}
			}

		}




		println "finalizando bootstrap"
	}
	def destroy = {
	}
}
