package zoo

class Zoo {
	
	static mapping = { id generator: 'increment'}
	
	String nombre
	Comunidad comunidad
	
	static hasMany= [animales:Animal]
	
    static constraints = {
    }
	def principalZooService
	
//	def beforeDelete() {
//		principalZooService.beforeDeleteZoo this
//	}
}
