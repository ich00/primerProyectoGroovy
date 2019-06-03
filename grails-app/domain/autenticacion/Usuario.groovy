package autenticacion

class Usuario {

	static mapping = { id generator: 'increment'}
	
	String nombre
	Perfil perfil
	
    static constraints = {
		perfil(nullable:true)
    }
}
