package zoo

class TestController {

	
	def rest(){
		
		def lista = zoo.Zoo.list()
		
		println lista
		
		render(contentType: 'text/json') {[
			'results': lista,
			'status': "OK"
			]}
		
	}
	
	
	def rest2(){
		 
		println params
		
		render(contentType: 'text/json') {[
			'status': "OK"
			]}
		
	}
	
    def crearTrabajadores() {
		
		def trabajadores =['patricia', 'alba', 'miriam', 'carlos', 'javier']
		trabajadores.eachWithIndex {trabajador, i->
			def newTrabajador = new zoo.Trabajador()
			newTrabajador.nombre = trabajador
			newTrabajador.apellidos = "mendez"
			newTrabajador.idEmpleado = i
			
			newTrabajador.save()
			
			println "trabajador: "+newTrabajador.nombre+" creado"
			
			def objetoZoo = zoo.Zoo.findByNombre("zooiland")
			
			println "zoo: "+objetoZoo.nombre
			
	//		objetoZoo.addToTrabajadores(newTrabajador)
			
			newTrabajador.addToZoos(objetoZoo)
		}
		
		
		
	}
}
