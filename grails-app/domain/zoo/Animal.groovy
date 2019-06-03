package zoo

class Animal {
	
	static mapping = { id generator: 'increment'}
	
	String nombre
	String alias
	String cantidad
	Zoo zoo
	Familia familia
	 
    static constraints = {
	}
   }

