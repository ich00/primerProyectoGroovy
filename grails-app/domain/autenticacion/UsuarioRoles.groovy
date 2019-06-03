package autenticacion

class UsuarioRoles {

	Usuario usuario
	Rol rol
	
    static constraints = {
		usuario(nullable:false)
		rol(nullable:false)
    }
}
