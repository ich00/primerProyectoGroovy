package zoo

class Trabajador {
	
	static mapping = { id generator: 'increment'}
	
	String nombre
	String apellidos

	
    static constraints = {
		
    }
	

	
}
