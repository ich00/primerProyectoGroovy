package autenticacion

import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;
import utilidades.Utilidades

class AdminRolesController {

	def autenticacionService
	
	def beforeInterceptor = {
//		def usuarios=["administrador", "secretaria", "jefe", "rrhh", "comercial", "tramitacion"]
//		usuarios.each {usuario->
//			def nuevoUsuario = new autenticacion.Usuario()
//			nuevoUsuario.nombre = usuario
//			
//			if(nuevoUsuario.validate()){
//				nuevoUsuario.save(flush:true)
//			}else{
//				println nuevoUsuario.errors
//			}
//		}
//		def roles=["básico", "normal", "high", "root"]
//		roles.each{ rol->
//			def nuevoRol = new autenticacion.Rol()
//			nuevoRol.nombre= rol
//			nuevoRol.descripcion= "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
//		if(nuevoRol.validate()){
//							nuevoRol.save(flush:true)
//						}else{
//							println nuevoRol.errors
//						}
//			
//		}
		
//		def perfiles=["administrador","root","facturacion","secretaria","administracion","comercial","rrhh","marketing"]
//		perfiles.each{perfil->
//			def nuevoPerfil = new autenticacion.Perfil()
//			nuevoPerfil.nombre=perfil
//			if(nuevoPerfil.validate()){
//				nuevoPerfil.save(flush:true)
//			}else{
//			println nuevoPerfil.errors
//			}
//		}
	}
	
    def index() { 
		render(view:'general')
	}
	
	def crearRelacionUsuarioRol(){
		def crear= autenticacionService.crearRelacionUsuarioRol(params.nombreUsuario, params.nombreRol)
		println"hemos llegado aqui..."		
	}
	
	def prueba(){
		
		def usuarios = autenticacionService.listarUsuarios()
		def roles = autenticacionService.listarRoles()
		
		usuarios.each{user->
			
			roles.each{rol->
			
				def newRelacion = new autenticacion.UsuarioRoles()
				newRelacion.usuario = user
				newRelacion.rol = rol
				newRelacion.save(flush:true)
			
			}
		}
		
	}
	
	def prueba2 (){
		def roles= autenticacionService.listarRoles()
		def perfiles= autenticacionService.listarPerfiles()
		roles.each{ rol->
			perfiles.each {perfil->
				def nuevaRelacion = new autenticacion.PerfilRol()
				nuevaRelacion.rol=rol
				nuevaRelacion.perfil = perfil
				nuevaRelacion.save(flush:true)
			
			}
		}
	}
	
	def listarUsuarios(){
		def usuarios= autenticacionService.listarUsuarios()
//		render(view:'general', model:[usuarios:usuarios])
		render (template:'listarUsuarios' , model:[usuarios:usuarios])
	}
	
	def listarRoles(){
		
		def rolesUsuario = autenticacionService.obtenerRolesPorUsuario(params.nombreUsuario)
		def rolesRestantes = autenticacionService.mostrarRolesRestantes(params.nombreUsuario)
		def listaRoles = autenticacionService.listarRoles()
		def listaPerfiles= autenticacionService.listarPerfiles()
		def listaUsuarios= autenticacionService.listarUsuarios()
		
		println "hbfsdfkjds: "+listaUsuarios
		println "kekekeke: "+listaPerfiles
		
		
		render(template:"listaRoles", model:[rolesUsuario:rolesUsuario, listaRoles:listaRoles,rolesRestantes:rolesRestantes, listaPerfiles:listaPerfiles,listaUsuarios: listaUsuarios,  nombreUsuario:params.nombreUsuario])
		
	}
	
	def comprobarStringLista(def lista){
		
		def listaResultado = []
		if(lista.getClass().getName()=="java.lang.String"){
			listaResultado.add(lista)
		}
		else{
			listaResultado=lista
		}
		
		return listaResultado
	}
	
	
	
	def eliminarRoles(){
		println"gugugug: "+params
		def listaRoles= params.rol
		def listaResultado = Utilidades.comprobarStringLista(listaRoles)
		
		println "lista_"+listaResultado
		
		def objetoUsuario=autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		def rolesEliminados= autenticacionService.eliminarRoles(listaResultado, objetoUsuario)
		
		String mensaje = ""
		rolesEliminados.eachWithIndex{ nombreRol,i->
			
			if(i==0){
				mensaje = "Roles eliminados: <br/>"
				mensaje += "<ul>"
			}
			
			
			mensaje+="<li>"+nombreRol+"</li>"
			
			if(i==rolesEliminados.size()-1){
				mensaje += "</ul>"
			}
		}
		
		
		if(mensaje!=""){
			flash.message = mensaje
		}
		
		
		redirect(action:'listarRoles',params:[nombreUsuario:params.nombreUsuario])
		
	}
	
	def añadirRoles(){
		println "rititntin: "+params
		def listaRoles= params.rol
		def listaResultado = Utilidades.comprobarStringLista(listaRoles)
		
		
		println "lista_"+listaResultado
		
		def objetoUsuario=autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		def rolesAñadidos= autenticacionService.añadirRoles(listaResultado, objetoUsuario)
		
		String mensaje = ""
		listaResultado.eachWithIndex{ nombreRol,i->
			
			if(i==0){
				mensaje = "Roles añadidos: <br/>"
				mensaje += "<ul>"
			}
			
			
			mensaje+="<li>"+nombreRol+"</li>"
			
			if(i==listaResultado.size()-1){
				mensaje += "</ul>"
			}
		}
		
		
		if(mensaje!=""){
			flash.message = mensaje
		}
		
		
		redirect(action:'listarRoles',params:[nombreUsuario:params.nombreUsuario])
	}
	
	def crearPerfil(){
		
		def listaRoles = params.roles
		def listaResultado = Utilidades.comprobarStringLista(listaRoles)
		println"listita: "+listaResultado
		
		def crearPerfil= autenticacionService.crearPerfil(params.nombre, listaResultado)
		
		redirect(action:'listarRoles',params:[nombreUsuario:params.nombreUsuario] )
	}
	
	def listarRolesUsuario(){
		println "remrumrum: "+params
		
		
		render(template:'test1',model:[nombreUsuario:params.parametro1])
	}
	
	def borrarPerfil(){
		println "jhjhj: "+params
		def objetoPerfil= autenticacionService.obtenerObjetoPerfil(params.nombrePerfil)
		def borrarRelacionPR= autenticacionService.borrarRelacionPR(objetoPerfil)
		
		def borrarPerfil= autenticacionService.borrarPerfilTUsuario( objetoPerfil )
		
		if(objetoPerfil){
			objetoPerfil.delete()
			flash.message="Borrado con éxito el perfil: "+params.nombrePerfil
		}else{
		flash.message="No se ha podido borrar el perfil"
		}
		
		redirect(action:'listarRoles',params:[nombreUsuario:params.nombreUsuario])
		
	}
	
	def mostrarPerfil(){
		println "perfil: "+params.perfil
		def listaRolesPerfil = autenticacionService.obtenerRolesDePerfil(params.perfil)
		
		println listaRolesPerfil
		
		render(template:"listaRolesPerfil", model:[listaRolesPerfil:listaRolesPerfil, nombreUsuario:params.nombreUsuario, nombrePerfil: params.perfil])
	
	}
	
	def asignarRolesDePerfil( def listaRoles, def objetoUsuario){
		def listaResultado= Utilidades.comprobarStringLista(listaRoles)
		def asignarRoles= autenticacionService.asignarRoles(listaResultado, objetoUsuario)
		
	}
	
	def asignarPerfil(){
		println " asignar: "+params
		def objetoUsuario= autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		def objetoPerfil = autenticacionService.obtenerObjetoPerfil(params.nombrePerfil)
		
		def asignarPerfil= autenticacionService.asignarPerfil(objetoUsuario, objetoPerfil)
		
		def listaRoles= autenticacionService.obtenerRolesPorUsuario(params.nombreUsuario)
		def listaRolesActuales= []
		
		listaRoles.each{rol->
			listaRolesActuales.add(rol.rol.nombre)
		}
		
		def borrarRolesUsuario=autenticacionService.eliminarRoles(listaRolesActuales, objetoUsuario)
		def asignarRolesDePerfil= this.asignarRolesDePerfil(params.rol, objetoUsuario)
		
		if(asignarRolesDePerfil){
			flash.message="El usuario "+params.nombreUsuario+ " tiene ahora el perfil "+params.nombrePerfil
		}else{
			flash.message="Error al asignar perfil al usuario "+params.nombreUsuario
		}
		
		redirect(action:'listarUsuarios')
	}
	
	def modificarPerfil(){
		println "mod: "+params
		
		def listaRoles=autenticacionService.listarRoles()
		def listaNombreRoles= listaRoles.nombre
		
		
		def listaRolesPerfil= autenticacionService.obtenerRolesDePerfil(params.nombrePerfil)
		def listaNombreRolesPerfil= listaRolesPerfil.rol.nombre
		
		def listaResultado= autenticacionService.compararListas(listaNombreRoles, listaNombreRolesPerfil)
		println"retete: "+listaResultado
		
		
		render(template:"formuPerfil", model:[nombrePerfil:params.nombrePerfil, listaRolesPerfil:listaRolesPerfil, listaDisponibles:listaResultado])
	}
	
	def actualizarPerfil(){
		println "actualizando::"+params
		def listaRoles= params.rol
		def listaResultado= Utilidades.comprobarStringLista(listaRoles)
		def objetoPerfil=autenticacionService.obtenerObjetoPerfil(params.nombrePerfil)
		def borrarExistentes= autenticacionService.borrarRelacionPR(objetoPerfil)
		def crearRelacion= autenticacionService.crearRelacionPerfil(listaResultado, params.nombrePerfil)
		objetoPerfil.nombre= params.nombrePerfilNuevo
		if(crearRelacion){
			flash.message="Perfil actualizado "+params.nombrePerfil.toUpperCase()}
		else{
			flash.message="Fallo al actualizar el perfil"+params.nombrePerfil.toUpperCase()
		}
		redirect(action:'listarUsuarios')
	}
	
	def modificarUserToUser(){
		println"touser: "+params
		def listaRoles=autenticacionService.listarRoles()
		def listaNombreRoles= listaRoles.nombre
		
		def rolesFinales=autenticacionService.obtenerRolesPorUsuario(params.usuarioBase)
		def nombreRolesFinales=rolesFinales.rol.nombre
		
		def listaResultado= autenticacionService.compararListas(listaNombreRoles, nombreRolesFinales)

		render(template:"formuUserToUser", model:[userBase:params.usuarioBase, nombreUsuario: params.usuarioFinal, nombreRolesFinales:nombreRolesFinales, listaDisponibles:listaResultado])
		
	}
	
	def asignarUserToUser(){
		println"ballena: "+params
		def listaRoles= params.rol
		def listaRolesDef= Utilidades.comprobarStringLista(listaRoles)
		
		def rolesUsuarioFinal=autenticacionService.obtenerRolesPorUsuario(params.nombreUsuario)
		def nombreRolesUsuarioFinal=rolesUsuarioFinal.rol.nombre
		
		
		def objetoUsuarioFinal=autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		if(objetoUsuarioFinal.perfil){
			def borrarPerfilUsuario=autenticacionService.borrarPerfilTUsuario(objetoUsuarioFinal.perfil)
		}
		def borrarRolesActuales=autenticacionService.eliminarRoles(nombreRolesUsuarioFinal, objetoUsuarioFinal)
		
		def asignarRoles= autenticacionService.añadirRoles(listaRolesDef,objetoUsuarioFinal )
		
		if(asignarRoles){
			flash.message= "Al usuario "+params.nombreUsuario+" se le han asignado los roles de "+params.userBase
		}else{
			flash.message="No se ha podido asignar los roles al usuario "+params.nombreUsuario
		}
		
		redirect(action:"listarUsuarios")
		
	}
	
	def mostrarPerfilUsuario(){
		println "perfilus: "+params
		def objetoUsuario= autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		def perfilUsuario= objetoUsuario.perfil.nombre
		def rolesPerfil= autenticacionService.obtenerRolesDePerfil(perfilUsuario)
		
		render(template:"mostrarPerfil", model:[rolesPerfil:rolesPerfil,perfilUsuario:perfilUsuario, nombreUsuario:params.nombreUsuario ])
	}
	
	def formuCrearPerfil(){
		def listaRoles= autenticacionService.listarRoles()
		
		render(template:"crearPerfil", model:[listaRoles:listaRoles])
	}
	
	def selectModPerfil(){
		println "777777777: "+params
		def nombreUsuario=params.nombreUsuario
		def listaPerfiles= autenticacionService.listarPerfiles()
		
		render(template:"selectModPerfil", model:[listaPerfiles:listaPerfiles, nombreUsuario:nombreUsuario])
	}
	
	def formuBorrarPerfil(){
		def listaPerfiles= autenticacionService.listarPerfiles()
		render(template:"borrarPerfil", model:[listaPerfiles:listaPerfiles])
	}
	
	def asigPerfil(){
		def listaPerfiles= autenticacionService.listarPerfiles()
		def nombreUsuario= params.nombreUsuario
		render(template:"../herramientasAsignacion/asignarPerfil", model:[nombreUsuario:nombreUsuario, listaPerfiles:listaPerfiles])
	}
	
	def asigUsuario(){
		def listaUsuarios=autenticacionService.listarUsuarios()
		def nombreUsuario= params.nombreUsuario
		render(template:"../herramientasAsignacion/asignarUsuario", model:[nombreUsuario:nombreUsuario, listaUsuarios:listaUsuarios])
	}
	
	def borrarPerfilUser(){
		println"borrrrrrrrr: "+params
		def objetoUsuario= autenticacionService.obtenerObjetoUsuario(params.nombreUsuario)
		def borrarPerfil=autenticacionService.borrarPerfilTUsuario(objetoUsuario.perfil)
		def listaRoles= autenticacionService.obtenerRolesPorUsuario(params.nombreUsuario)
		def nombreRolesUsuario=listaRoles.rol.nombre
		println"borrrrrrrrr: "+nombreRolesUsuario
		def borrarRolesActuales=autenticacionService.eliminarRoles(nombreRolesUsuario, objetoUsuario)
		def rolesResultado = autenticacionService.obtenerRolesPorUsuario(params.nombreUsuario)
		
		redirect(action:"listarRoles",params:[nombreUsuario:params.nombreUsuario])
	}
}
