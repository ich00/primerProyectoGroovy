package zoo

class ObtenerDatosService {

	def comunidadService
	/**
	 * listaDatos: [zoo, comunidad]
	 * 
	 * @param listaDatos
	 * @return
	 */
    def obtenerDatosComunes(def listaDatos) {
		
		def resultado = [:]
		
		listaDatos.each{dato->
			
			if(dato=='zoo'){
				def listaZoos =  zoo.Zoo.list()
				resultado.put('zoo',listaZoos)
			}else if(dato=="comunidad"){
				def listaCom = comunidadService.obtenerTodas()
				resultado.put('comunidad',listaCom)
			}else if (dato=='familia'){
				def listaFam = familiaService.obtenerTodas()
				resultado.put('comunidad',listaFam)
			}
			
			
		}
		
		
		return resultado

    }
}
