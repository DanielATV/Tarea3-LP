

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

	public void set_nombre(String nom){

		nombreObjeto = nom;

	}
	public void set_atributo(String nom){

		atributoObjeto = nom;

	}
	public void set_valor(int val){

		valorAtributo = val;

	}

	void display(){
		System.out.println(nombreObjeto+": "+valorAtributo+" "+atributoObjeto);
	}
}
