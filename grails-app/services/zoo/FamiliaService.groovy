package zoo

class FamiliaService {

    def obtenerTodas() {
		def resultado = []
		
		resultado = zoo.Familia.list()
		
		return resultado
    }
}
