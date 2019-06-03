package zoo

class Familia {
	
	String nombre
	
	static hasMany=[animales: Animal]
	
    static constraints = {
    }
}
