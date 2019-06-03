package zoo

class RelacionTrabajadorZoo {

	static mapping = { version false}
	
	
	Zoo zoo
	Trabajador trabajador
	String idEmpleado
	
    static constraints = {
		zoo(nullable:false)
		trabajador(nullable:false)
    }
	
	
}
