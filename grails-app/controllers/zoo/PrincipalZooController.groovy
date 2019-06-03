package zoo

class PrincipalZooController {

	def principalZooService
	def comunidadService
	def familiaService
//	def obtenerDatosService
	
		def beforeInterceptor ={
//		if(params.action=='listar' && params.action!='borrar'){
//			def comunidades = ["Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla y León", "Castilla-La Mancha", "Cataluña", "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura", "Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", "País Vasco", "Principado de Asturias", "Región de Murcia"]
//			comunidades.each{comunidad->
//				
//				def nuevaComunidad = new zoo.Comunidad()
//				nuevaComunidad.nombre= comunidad
//				
//				if(nuevaComunidad.validate()){
//					nuevaComunidad.save(flush:true)
//				}else{
//					println nuevaComunidad.errors
//				}
//			}
//		} //cierre creación comunidades
			
//		if(params.action=='listar' && params.action!='borrar'){
//			def zoos =['zoo1','zoo2', 'zoo3', 'zoo4', 'zoo5', 'zoo6', 'zoo7', 'zoo8', 'zoo9', 'zoo10', 'zoo11', 'zoo12', 'zoo13']
//			zoos.each {zoo->
//				
//				def newZoo = new zoo.Zoo()
//				newZoo.nombre = zoo
//				
//				newZoo.comunidad = zoo.Comunidad.findByNombre('Canarias')
//				
//				if(newZoo.validate()){
//					newZoo.save(flush:true)
//				}else{
//					println newZoo.errors
//				}
//			}
//		}//cierre primer if (creacion zoos)
		
		
//			if(params.action=='listar' && params.action!='borrar'){
//				def familias =['terrestres', 'acuáticos', 'aéreos']
//				familias.each {familia->
//					
//					def newFamilia = new zoo.Familia()
//					newFamilia.nombre = familia
//					
//					
//					if(newFamilia.validate()){
//						newFamilia.save(flush:true)
//					}else{
//						println newFamilia.errors
//					}
//				}
//			}//cierre if creación familias
			
//			if(params.action=='listar' && params.action!='borrar'){
//			def animales =['animal', 'animal2', 'animal3', 'animal4', 'animal5']
//			animales.each {animal->
//				
//				def newAnimal = new zoo.Animal()
//				newAnimal.nombre = animal
//				newAnimal.alias = 'animal'
//				newAnimal.cantidad = 35
//				newAnimal.zoo = zoo.Zoo.findByNombre('zoo10')
//				newAnimal.familia = zoo.Familia.findByNombre('aéreos')
//				
//				
//				if(newAnimal.validate()){
//					newAnimal.save(flush:true)
//				}else{
//					println newAnimal.errors
//				}
//			}
//		}//cierre  if (creacion animal)
		
//		if(params.action=='listar' && params.action!='borrar'){
//			def trabajadoresZoo = [:]
//			
//			def trabajadoresZoo1 =['juan', 'lucas', 'maria', 'patricia']
//			def trabajadoresZoo2 = ['marta', 'irene', 'jose']
//			def trabajadoresZoo3= ['lucia','pedro', 'fernando', 'miriam']
//			def trabajadoresZoo4= ['raul','rita', 'roman', 'fran']
//			
//			
//			trabajadoresZoo.put('zoo1', trabajadoresZoo1)
//			trabajadoresZoo.put('zoo2', trabajadoresZoo2)
//			trabajadoresZoo.put('zoo3', trabajadoresZoo3)
//			trabajadoresZoo.put('zoo4', trabajadoresZoo4)
//			
//			
//			trabajadoresZoo.each{trabZoo->
//				
//				def trabajadorZooCorresponde = zoo.Zoo.findByNombre(trabZoo.key)
//				
//				
//				if(trabajadorZooCorresponde){
//					trabZoo.value.each{trabajador->
//						def newTrabajador = new zoo.Trabajador()
//						 newTrabajador.nombre=trabajador
//						 newTrabajador.apellidos= 'perez'
//						 newTrabajador.zoo= trabajadorZooCorresponde
//						
//						
//						
//						if(newTrabajador.validate()){
//							newTrabajador.save(flush:true)
//						}else{
//							println newTrabajador.errors
//						}
//						
//						
//					}
//				}
//				
//				
//			}
//		}
//		
//			
//			
//			if(params.action=='listar' && params.action!='borrar'){
//				def trabajadores =['jesus', 'iland', 'rafa', 'nerea']
//				trabajadores.each {trabajador->
//					
//					def newTrabajador = new zoo.Trabajador()
//					newTrabajador.nombre = trabajador
//					newTrabajador.apellidos = 'perez'
//					newTrabajador.addToZoo(zoo(nombre: 'zooiland'))
//					
//					
//					
//					if(newTrabajador.validate()){
//						newTrabajador.save(flush:true)
//					}else{
//						println newTrabajador.errors
//					}
//				}
//			}//cierre  if creacion trabajadores
			
	}
			
			
	
    def index() { 
		render(view:'paginaInicial')
	
	}
	
	def listar(){
		
		def zoo = principalZooService.obtenerZoos()
		def datosComunidad = comunidadService.obtenerTodas()
		
		
//		def datosSolicitar =  
//		def resultadoDatos = obtenerDatosService.obtenerDatosComunes(datosSolicitar)
//		def zoo = resultadoDatos.zoo
//		def datosComunidad = resultadoDatos.comunidad
		
		render(view:'../zoo/listar',model:[datosZoo:zoo, titulo: "titulo1", datosComunidad:datosComunidad])
		
	}
	
//	def mostrarAnimales(){
//		println"mostrarAnimales: "+params
//		def animalMostrar= principalZooService.obtenerAnimalesByZoo(params.nombreZooActual )
//		def zoo = principalZooService.obtenerZoos()
//		def datosFamilia=familiaService.obtenerTodas()
//		println "nn:"+params.nombreZooActual
//		
//		render(view:'../animal/listar', model:[datosAnimal: animalMostrar, nombreZooActual:params.nombreZooActual, listaZoo:zoo, datosFamilia:datosFamilia])
//		
//	}

	
	def filtrarZooByComunidad(){
		println"yanose: "+params
		def mensaje =0
		def filtrarByComunidad = principalZooService.obtenerZooPorComunidad(params.provincia)
		println"yanose121212: "+filtrarByComunidad
		
		render(template:'../zoo/tabla', model:[datosZoo:filtrarByComunidad, provincia:params.provincia, titulo:"titulo2" ])
	
	}
	
	
	def editarZoo(){
		def editarZoo= principalZooService.buscarPorNombreZoo(params.nombreZooActual)
		def datosComunidad = comunidadService.obtenerTodas()
		
		render(view:'../zoo/mostrarFormularioEditar', model:[datosZoo:editarZoo, datosComunidad:datosComunidad])
	}
	
	
	def actualizarZoo(){
		println "123: "+params
		def actualizarZoo=principalZooService.buscarPorNombreZoo(params.nombreActualBBDD)
		println"jijij:"+ actualizarZoo
		actualizarZoo.nombre = params.nombre
		actualizarZoo.comunidad= zoo.Comunidad.findByNombre(params.comunidad)
		actualizarZoo.save()
		redirect(action:'listar')
	}
	
	def borrarZoo(){
		
		def borrarZoo=principalZooService.buscarPorNombreZoo(params.nombreZooActual)
		
		//Obtenemos listas
		def listaTrabajadoresZoo= principalZooService.obtenerTrabajadoresByZoo(params.nombreZooActual)
		def listaAnimalesZoo = principalZooService.obtenerAnimalesByZoo(params.nombreZooActual)
		
		
		//Comprobar
		def sizeListaTrabajadoresZoo = listaTrabajadoresZoo.size()
		def sizeListaAnimalesZoo = listaAnimalesZoo.size()
		def borrar = false
		
		if(sizeListaTrabajadoresZoo==0 && sizeListaAnimalesZoo==0){
			borrar = true
		}
		
		
		if(borrar){
			flash.message = "Borrado con éxito"
			borrarZoo.delete()
		}else{
			flash.message = "El Zoo que quiere borrar tiene animales y/o trabajadores, borrelos primero. Gracias"
		}
		
		
		redirect(action:'listar')
	}
	
	def crearZoo(){
		println"creando..."+params
		def crearZoo=principalZooService.crearZooNuevo(params)
		println"que viene aqui: "+params
		redirect(action:'listar')
	}
	
	def filtrarAnimalByFamilia(){
		println "y aqui que: "+params
		def mensaje=0
		def filtrarByFamilia = principalZooService.obtenerAnimalPorFamilia(params.familia, params.nombreZooActual)
		println "tururu que: "+filtrarByFamilia
		
		render(template:'../animal/tabla', model:[datosAnimal:filtrarByFamilia,nombreZooActual:params.nombreZooActual, mensaje:mensaje])
	}
	
	def editarAnimal(){ 
		println "dame params: "+params
		def editarAnimal= principalZooService.buscarPorNombreAnimal(params.nombreAnimal)
		def datosFamilia= familiaService.obtenerTodas()
		
		render(view:'../animal/mostrarFormularioEditar', model:[datosAnimal:editarAnimal,nombreZooActual:params.nombreZooActual, datosFamilia:datosFamilia])
	}
	
	def actualizarAnimal(){
		println "parametrito_ "+params.cantidad
	
		def actualizarAnimal=principalZooService.buscarPorNombreAnimal(params.nombreActualBBDD)
		actualizarAnimal.nombre = params.nombre
		actualizarAnimal.alias= params.alias
		actualizarAnimal.cantidad= params.cantidad
		println "parametritorrrrrr_ "+actualizarAnimal.cantidad
		actualizarAnimal.familia= zoo.Familia.findByNombre(params.familia)
		actualizarAnimal.save()
		
		redirect(action:'mostrarAnimalesTrabajadores',params:[nombreZooActual:params.nombreZooActual])
//		render(view:'listarAnimales', model:[datosAnimal: actualizarAnimal, nombreZooActual:params.nombreZoo])
	}
	
	
	def crearAnimal(){
		def crearAnimal=principalZooService.crearAnimalNuevo(params)
		println"que viene aqui: "+params
		redirect(action:'mostrarAnimalesTrabajadores', params:[nombreZooActual:params.nombreZooActual])
	}
	
	def mostrarFormularioBorrarAnimal(){
		def borrarAnimal=principalZooService.buscarPorNombreAnimal(params.nombreAnimal)
		
		render(view:'../animal/formularioBorrar',model:[nombreZooActual:params.nombreZooActual, datosAnimal:borrarAnimal])
	}
	
	def borrarNumeroAnimales(){
		def actualizarAnimal=principalZooService.buscarPorNombreAnimal(params.nombreActualBBDD)
//		 actualizarAnimal.nombre= params.nombre
//		 actualizarAnimal.alias= params.alias
		def aLongActuAnimal= Long.parseLong(actualizarAnimal.cantidad)
		 println "actuaCantidad: "+ actualizarAnimal.cantidad.getClass()
		 def aLongParams= Long.parseLong(params.cantidad)
		 println "paramsCANTIDAD: "+aLongParams.getClass()
		 
		 def resta= aLongActuAnimal- aLongParams
		 resta= resta.toString()
		 actualizarAnimal.cantidad= resta
		 
		 if(actualizarAnimal.cantidad=='0'){
			 actualizarAnimal.delete()
		 }else{
			 if(actualizarAnimal.validate()){
				 actualizarAnimal.save()
			 }else{
				 println actualizarAnimal.errors
			 }
		 }
		
		 redirect(action:'mostrarAnimalesTrabajadores',params:[nombreZooActual:params.nombreZooActual])
		 
	}
	
	def mostrarAnimalesTrabajadores(){
		println "ririririr: "+params.nombreZooActual
		def animalMostrar= principalZooService.obtenerAnimalesByZoo(params.nombreZooActual)
		def zoo = principalZooService.obtenerZoos()
		def relacionTrabajadorZoo= principalZooService.obtenerTrabajadoresByZoo(params.nombreZooActual)
		def datosFamilia=familiaService.obtenerTodas()
		def mensaje
		
		def sizeTrabajadores= relacionTrabajadorZoo.size()
		def sizeAnimales = animalMostrar.size()
		
		if(sizeTrabajadores == 0){
			mensaje=1
		}
		if (sizeAnimales == 0){
			mensaje=2
		}
		if(sizeAnimales ==0 && sizeTrabajadores==0){
			mensaje=3
		}
		
		
		render(view:'listaAnimalesTrabajadores', model:[mensaje: mensaje, datosAnimal: animalMostrar, nombreZooActual:params.nombreZooActual, listaZoo:zoo, datosFamilia:datosFamilia, relacionTrabajadorZoo: relacionTrabajadorZoo])
	}
	
	def editarTrabajador(){
		def trabajador = principalZooService.buscarPorNombreTrabajador(params.nombreTrabajador)
		
		render(view:'../trabajador/mostrarFormularioEditar', model:[datosTrabajador:trabajador,nombreZooActual:params.nombreZooActual])
	}
	
	def actualizarTrabajador (){
		
		def actualizarTrabajador=principalZooService.buscarPorNombreTrabajador(params.nombreActualBBDD)
		println "nombre: "+actualizarTrabajador
		actualizarTrabajador.nombre = params.nombre
		actualizarTrabajador.apellidos= params.apellidos
		
		actualizarTrabajador.save(flush:true)
		
		redirect(action:'mostrarAnimalesTrabajadores',params:[nombreZooActual:params.nombreZooActual])
	}
	
	def borrarTrabajador(){
		println "222222: "+params
		def objetoTrabajador=principalZooService.obtenerObjetoTrabajador(params.nombreTrabajador)
		println "remrem: "+objetoTrabajador.getClass()
		def objetoRelacion= principalZooService.buscarObjetoTrabajadorRelacion(objetoTrabajador)
		println "crocro: "+objetoRelacion.getClass()
		
		objetoRelacion.delete()
		objetoTrabajador.delete()
	
		
	
//		println "prope: "+params
//		def obtenerObjetoTrabajador=principalZooService.obtenerObjetoTrabajador(params.nombreTrabajador)
//		println "cromcrom: "+obtenerObjetoTrabajador
//		println "rimrim: "+obtenerObjetoTrabajador.properties
//		def obtenerObjetoTrabajadorRelacion= principalZooService.obtenerObjetoRelacionTrabajador(obtenerObjetoTrabajador)
//		println "crocro: "+borrarTrabajadorRelacion
//		
		
		redirect(action:'mostrarAnimalesTrabajadores',params:[nombreZooActual:params.nombreZooActual])
	}
	
	
	
	
	def crearTrabajador(){
		
		println params
		def crearTrabajador=principalZooService.crearTrabajadorNuevo(params.datosTrabajador)
		
		//crear relacion
		
		def crearRelacion= principalZooService.crearRelacionZooTrabajador(params.datosZoo.nombre, params.datosTrabajador.nombre)
		
		redirect(action:'mostrarAnimalesTrabajadores', params:[nombreZooActual:params.datosZoo.nombre])
	}
	
	def crearRelacionZooTrabajador(){
//		println"nombrezoo: "+params.nombreZooActual+"nombretrabajador: "+params.nombreTrabajador
		def crear= principalZooService.crearRelacionZooTrabajador(params.nombreZooActual, params.nombreTrabajador)
		println"hemos llegado aqui..."
		redirect(action:'mostrarAnimalesTrabajadores', params:[nombreZooActual:params.nombreZooActual])
	}
	
	
}
