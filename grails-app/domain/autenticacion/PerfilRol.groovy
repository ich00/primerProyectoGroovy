package autenticacion

class PerfilRol {
	static mapping = { id generator: 'increment'}
	
	Rol rol		
	Perfil perfil
    static constraints = {
    }
}
