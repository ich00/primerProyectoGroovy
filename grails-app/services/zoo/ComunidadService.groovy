package zoo

class ComunidadService {

    def obtenerTodas() {
		def resultado = []
		
		resultado = zoo.Comunidad.list()
		
		return resultado
    }
}
