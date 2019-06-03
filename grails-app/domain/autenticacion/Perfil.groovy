package autenticacion

class Perfil {
	static mapping = { id generator: 'increment'}
	
	String nombre
	
    static constraints = {
    }
}
