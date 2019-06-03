package zoo

class AdministracionController {

	
	def administracionService
	def comunidadService
	def familiaService
	
    def index() {
		
		def listaComunidades=comunidadService.obtenerTodas()
		def listaFamilias= familiaService.obtenerTodas()
		render(view:'inicio', model:[listaComunidades:listaComunidades, listaFamilias:listaFamilias])
	}
	def cargaComunidades(){
		
		//Listamos las comunidades
		def listaComunidades=comunidadService.obtenerTodas()
		
		//Crear comunidad
		def crearComunidad= administracionService.crearComunidad(params.comunidad)
		
		if(crearComunidad){
			flash.message = "Comunidad creada correctamente"
		}else{
			flash.message = "Error al crear la comunidad. Ya existe."
		}
		
//	render(view: 'inicio', model:[error:error, mensaje: crearComunidad])
		 
		 redirect(action:'index')
	}
	
	def cargaFamilias(){
		
		def listaFamilias= familiaService.obtenerTodas()
		def crearFamilia= administracionService.crearFamilia(params.familia)
		
		if(crearFamilia){
			flash.message = "Familia creada correctamente"
		}else{
			flash.message = "Error al crear la familia. Ya existe."
		}
		
		redirect(action:'index')
//		 render(view: 'inicio', model:[listaFamilias:listaFamilias])
	}
}
