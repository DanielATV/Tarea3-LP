public class Objeto{
	String nombreObjeto;
	String atributoObjeto;
	int valorAtributo;

	Objeto(){
		nombreObjeto="";
		atributoObjeto="";
		valorAtributo=0;
	}

	Objeto(String nombre,String atributo,int valor){
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

	void display(){
		System.out.println(nombreObjeto+": "+valorAtributo+" "+atributoObjeto);
	}
}
