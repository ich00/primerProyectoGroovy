package utilidades

class Utilidades {
	public static  comprobarStringLista(def lista){
		
		def listaResultado = []
		if(lista.getClass().getName()=="java.lang.String"){
			listaResultado.add(lista)
		}
		else{
			listaResultado=lista
		}
		
		return listaResultado
	}
}
