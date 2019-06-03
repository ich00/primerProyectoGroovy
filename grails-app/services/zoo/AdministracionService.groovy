package zoo

class AdministracionService {

	def comprobarExisteComunidad(def comunidad){
		def buscar= Comunidad.findAllByNombre(comunidad)
		def tamaño= buscar.size()
		def resultado=0
		if(tamaño>0){
			resultado=1
		}
		return resultado
	}
		
    def crearComunidad(def comunidad){
		def resultado=0
		
		def comprobar = this.comprobarExisteComunidad(comunidad)
		
		if(comprobar==0){
			def nuevaComunidad= new zoo.Comunidad()
			nuevaComunidad.nombre= comunidad
			
			nuevaComunidad.save(flush:true)
			resultado=1
			
		}
		return  resultado
	}
	
	def comprobarExisteFamilia(def familia){
		def buscar= Familia.findAllByNombre(familia)
		def tamaño= buscar.size()
		def resultado=0
		if(tamaño>0){
			resultado=1
		}
		return resultado
	}
	
	
	def crearFamilia(def familia){
		
		def resultado=0
		
		
		def comprobar = this.comprobarExisteFamilia(familia)
		
		if(comprobar==0){
			def nuevaFamilia= new zoo.Familia()
			nuevaFamilia.nombre= familia
			
			nuevaFamilia.save(flush:true)
			resultado=1
		}	
		return  resultado
	}
	
	def sizeFamilia(){
		def listaFamilias = zoo.Familia.list()
		def resultado = listaFamilias.size()
	}
	
	def sizeComunidad(){
		def listaComunidad = zoo.Comunidad.list()
		def resultado = listaComunidad.size()
	}
}
