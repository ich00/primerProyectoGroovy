package autenticacion

class AutenticacionService {

    def obtenerObjetoUsuario(def nombreUsuario){
		def resultado= autenticacion.Usuario.findByNombre(nombreUsuario)
		
		return resultado
	}
	
	def obtenerObjetoRol(def nombreRol){
		def resultado= autenticacion.Rol.findByNombre(nombreRol)
		return resultado
	}
	
	def obtenerObjetoRelacion(def objetoUsuario){
		def resultado= autenticacion.UsuarioRoles.findByRol()
	}
	
	
	def crearRelacionUsuarioRol(def nombreUsuario, def nombreRol){
		
		def objetoUsuario= this.obtenerObjetoUsuario(nombreUsuario)
		def objetoRol= this.obtenerObjetoRol(nombreRol)
		
		def newRelacion = new autenticacion.UsuarioRoles()
		
		newRelacion.usuario = objetoUsuario
		newRelacion.rol = objetoRol
		
		
		newRelacion.save()
		
	}
	
	def listarUsuarios(){
		def resultado= Usuario.list()
		return resultado
	}
	
	def listarRoles(){
		def resultado= Rol.list()
		return resultado
	}
	
	def listarPerfiles(){
		def resultado = Perfil.list()
		return resultado
	}
	
	
	def obtenerRolesPorUsuario(def nombreUsuario){
		def objetoUsuario= this.obtenerObjetoUsuario(nombreUsuario)
		def resultado = autenticacion.UsuarioRoles.findAllByUsuario(objetoUsuario)
		return resultado
	}
	
	
	def mostrarRolesRestantes(def nombreUsuario){
		def resultado = []
		def rolesTodos= this.listarRoles()
		def rolesUsuario= this.obtenerRolesPorUsuario(nombreUsuario)
		
		def nombreRolesUsuarios = rolesUsuario.rol.nombre
		
		println "nombre"+ nombreRolesUsuarios
		
		rolesTodos.each{rolt->
			
			def nombreRolt=rolt.nombre
			
			if(!nombreRolesUsuarios.contains(nombreRolt)){
				resultado.add(nombreRolt)
			}
			
		}
		
		return resultado
	}
	
	
	def eliminarRol(def objetoRol, def objetoUsuario){
		def rolEliminar= autenticacion.UsuarioRoles.findByUsuarioAndRol(objetoUsuario, objetoRol)
		rolEliminar.delete()
	}
	
	def eliminarRoles(def listaRoles, def objetoUsuario){
		def resultado=[]
		listaRoles.each{ rol->
			println "julus_"+rol
			def objetoRol=this.obtenerObjetoRol(rol)
			println "objetoRol"+objetoUsuario
			this.eliminarRol(objetoRol, objetoUsuario)
			resultado.add(rol)
		}
		return resultado
	}
	
	def añadirRol(def objetoRol, def objetoUsuario){
		
		def nuevoRolUsuario= new autenticacion.UsuarioRoles()
		nuevoRolUsuario.rol=objetoRol
		nuevoRolUsuario.usuario=objetoUsuario
		
		nuevoRolUsuario.save(flush:true)
		
	}
	
	def añadirRoles(def listaRoles, def objetoUsuario){
		def resultado=[]
		listaRoles.each{rol->
			def objetoRol=this.obtenerObjetoRol(rol)
			this.añadirRol(objetoRol, objetoUsuario)			
		}
	}
	
	def crearRelacionPerfilRol(def rol, def nombrePerfil){
		def objetoPerfil = this.obtenerObjetoPerfil(nombrePerfil)
		def objetoRol = this.obtenerObjetoRol(rol)
		
		def nuevaRelacion= new autenticacion.PerfilRol()
		nuevaRelacion.perfil= objetoPerfil
		nuevaRelacion.rol=objetoRol
		
		nuevaRelacion.save(flush:true)
	}
	def crearRelacionPerfil(def listaRoles, def nombrePerfil){
		listaRoles.each{ rol->
			println "rolito_"+rol
			this.crearRelacionPerfilRol(rol, nombrePerfil)
		}
	}
	
	def crearPerfil(def nombrePerfil, def listaRoles){
		def nuevoPerfil = new autenticacion.Perfil()
		nuevoPerfil.nombre= nombrePerfil
		nuevoPerfil.save(flush:true)
		
		this.crearRelacionPerfil(listaRoles, nombrePerfil)		
		
	}
	
	
	
	def obtenerObjetoPerfil(def nombrePerfil){
		def objetoPerfil= autenticacion.Perfil.findByNombre(nombrePerfil)
	}
	
	def obtenerUsuariosPorPerfil (def nombrePerfil){
		def objetoPerfil = this.obtenerObjetoPerfil(nombrePerfil)
		
	}
	
	def borrarRelacionPR(def objetoPerfil){
		def listaRoles= autenticacion.PerfilRol.findAllByPerfil(objetoPerfil)
		println "roleando_:"+listaRoles
		listaRoles.each{rol->
			rol.delete(flush:true)
		}
		
	}
	
	def borrarPerfilTUsuario(def objetoPerfil){
		def lista= autenticacion.Usuario.findAllByPerfil(objetoPerfil)
		lista.each{usuario->
			usuario.perfil = null
			usuario.save(flush:true)
		}
	}
	
	def obtenerRolesDePerfil(def nombrePerfil){
		def objetoPerfil= this.obtenerObjetoPerfil(nombrePerfil)
		def resultado = autenticacion.PerfilRol.findAllByPerfil(objetoPerfil)
		
		return resultado
	}
	
	def asignarPerfil(autenticacion.Usuario objetoUsuario, def objetoPerfil){
		objetoUsuario.perfil= objetoPerfil		
		objetoUsuario.save(flush:true)
	}
	
	def asignarRoles(def listaNombresRoles, autenticacion.Usuario objetoUsuario){
		println "lista: "+listaNombresRoles
		
		listaNombresRoles.each{rolToAdd->
			def objetoRelacion = new autenticacion.UsuarioRoles()
			def rol = autenticacion.Rol.findByNombre(rolToAdd)
			objetoRelacion.usuario = objetoUsuario
			objetoRelacion.rol = rol
			objetoRelacion.save(flush:true)
		}
	}
		
	def compararListas(def listaCompleta, def listaActual){
		def resultado=[]
		listaCompleta.each{rolC->
			if(!listaActual.contains(rolC)){
				resultado.add(rolC)
			}
		}
		return resultado
	}
	
	
}
