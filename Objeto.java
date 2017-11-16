
public class Objeto{
	String nombreObjeto;
	String atributoObjeto;
	int valorAtributo;

	public Objeto(String nombre,String atributo,int valor){
		nombreObjeto = nombre;
		atributoObjeto = atributo;
		valorAtributo = valor;

	}
	String getNombre(){
		return nombreObjeto;

	}

	String getAtributo(){
		return atributoObjeto;

	}
	int getValor(){
		return valorAtributo;

	}
}

