package zoo

class PrincipalZooService {

	def obtenerZoos(){
		def resultado= Zoo.list()
		
		return resultado
	}
	
	def obtenerObjetoZoo(def nombreZoo){
		
		def resultado = Zoo.findByNombre(nombreZoo)
		
		return resultado
	}
	
	def obtenerAnimalesByZoo(def nombreZoo){
		
		def objetoZoo = this.obtenerObjetoZoo(nombreZoo)
		
		def animales = Animal.findAllByZoo(objetoZoo)
		def resultado = animales
		return resultado
	}
	
//	def todosOProvincia(def provincia){
//		def resultado
//		
//		if(provincia=='todos'){
//			resultado='todos'
//			
//		}
//		else{
//			resultado= provincia
//		}
//		return resultado
//	}
	def obtenerObjetoComunidad(def provincia){
		def resultado = Comunidad.findByNombre(provincia)
		
		return resultado
	}
	def obtenerZooPorComunidad(def provincia){
		
		def objetoComunidad = this.obtenerObjetoComunidad(provincia)
//		
//		def animales = Animal.findAllByZoo(objetoZoo)
//		def resultado = animales
		
		println "provincia llega: "+provincia
		def resultado
		
		if(provincia!='todos'){
			resultado = Zoo.findAllByComunidad(objetoComunidad)
		}
		else{
			resultado=  this.obtenerZoos()
		}
		
//		resultado.each{
//			
//			println it.getClass()
//		}
		println "dime esa provincia: "+resultado
		return resultado
	}
	
	def buscarPorNombreZoo(def nombreZoo){
		Zoo resultado = Zoo.findByNombre(nombreZoo)
		println"---------: "+resultado
		return resultado
	}
	
	
	
	def crearZooNuevo(def mapaZoo){
		
		def nuevoZoo= new zoo.Zoo()
		nuevoZoo.nombre= mapaZoo.nombre
		nuevoZoo.comunidad= zoo.Comunidad.findByNombre(mapaZoo.provincia)
		nuevoZoo.save(flush:true)
	}
	
	def obtenerAnimalPorFamilia(def familia, def nombreZoo){
		println"familia: "+familia
		
		def resultado
		def objetoZoo= Zoo.findByNombre(nombreZoo)
		def objetoFamilia= Familia.findByNombre(familia)
		
		if(familia!='todos'){
			resultado= Animal.findAllByFamiliaAndZoo(objetoFamilia,objetoZoo)
		}
		else{
			resultado=  this.obtenerAnimalesByZoo(nombreZoo)
		}
		
		
//		def objetoZoo= Zoo.findByNombre(nombreZoo)
//		def objetoFamilia= Familia.findByNombre(familia)
//		def resultado= Animal.findAllByFamiliaAndZoo(objetoFamilia,objetoZoo)
//		println "familiaresul: "+resultado
	
		return resultado
		
	}
	
	def buscarPorNombreAnimal(def nombreAnimal){
		def resultado = Animal.findByNombre(nombreAnimal)
		println"zoo: "+resultado
		return resultado
	}
	
	def crearAnimalNuevo(def mapaAnimal){
		
		def nuevoAnimal= new zoo.Animal()
		nuevoAnimal.nombre= mapaAnimal.nombre
		nuevoAnimal.alias = mapaAnimal.alias
		nuevoAnimal.cantidad = mapaAnimal.cantidad
		nuevoAnimal.familia = zoo.Familia.findByNombre(mapaAnimal.familia)
		nuevoAnimal.zoo= zoo.Zoo.findByNombre(mapaAnimal.nombreZooActual)
		
		
		nuevoAnimal.save(flush:true)
	}
	
//	def zoosBBDD(){
//		println "entramos: "+params
//		def resultados= Zoo.list() 
//		println"que sale por aqui ahora: "+resultados
//			
//		return resultados
//	}
	
	def obtenerTrabajadoresByZoo(def nombreZoo){
		
		Zoo objetoZoo = this.obtenerObjetoZoo(nombreZoo)
		
		def resultado = zoo.RelacionTrabajadorZoo.findAllByZoo(objetoZoo)
//		def trabajadores = objetoZoo.trabajadores
//		def resultado = trabajadores
		return resultado
	}
	
	def buscarPorNombreTrabajador(def nombre){
		def resultado = Trabajador.findByNombre(nombre)
		return resultado
	}
	
//	def objetoBorrarRelacionTrabajadorZoo(def mapaTrabajador){
//		def resultado = zoo.RelacionTrabajadorZoo.findAllByTrabajador(mapaTrabajador)
//		return resultado
//	}
	def buscarObjetoTrabajadorRelacion(def mapaTrabajador){
		def resultado= zoo.RelacionTrabajadorZoo.findByTrabajador(mapaTrabajador)
		return resultado
	}
	
	
	
	def crearTrabajadorNuevo(def mapaTrabajador){
		def nuevoTrabajador= new zoo.Trabajador()
		nuevoTrabajador.nombre= mapaTrabajador.nombre
		nuevoTrabajador.apellidos = mapaTrabajador.apellidos
		
		nuevoTrabajador.save(flush:true)
	}
	
	

	
	
	def obtenerIdEmpleado(def objetoZoo){
		println "objetozooid: "+objetoZoo.getClass()
		def resultado = 0
		//CRITERIA
		//1º - Consulta
		def RelacionTrabajadorZooCriteria= RelacionTrabajadorZoo.createCriteria()
		def resultadoCriteria = RelacionTrabajadorZooCriteria{
			eq ("zoo", objetoZoo)
			order ("idEmpleado", "desc")
			maxResults(1)
		}
		
		
		if(resultadoCriteria.size()>0){
			
			def objeto = resultadoCriteria[0]
			def idEmpleadoActual = objeto.idEmpleado
			
			resultado = Integer.parseInt(idEmpleadoActual) + 1			
		}else{
			resultado = 1
		}
		
		
//		//2º - incrementamos valor IdEmpleado
//		def resultado= objetoResultado.idEmpleado
//		
//		resultado= resultado+1
//		
		
		return resultado.toString()
	}
	
	def crearRelacionZooTrabajador(def nombreZoo, def nombreTrabajador){
		
		def objetoZoo= this.obtenerObjetoZoo(nombreZoo)
		def objetoTrabajador= this.obtenerObjetoTrabajador(nombreTrabajador)
		
		def newRelacion = new zoo.RelacionTrabajadorZoo()
		
		newRelacion.zoo = objetoZoo
		newRelacion.trabajador = objetoTrabajador
		newRelacion.idEmpleado = this.obtenerIdEmpleado(objetoZoo)
		
		newRelacion.save()
		
	}
	
	def obtenerObjetoTrabajador(def nombre){
		def resultado = Trabajador.findByNombre(nombre)
		
		return resultado
	}
	
	
}
