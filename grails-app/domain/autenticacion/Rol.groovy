package autenticacion

class Rol {

	static mapping = { id generator: 'increment'}
	
	String  nombre
	String descripcion
    static constraints = {
    }
}
