abstract public class Personaje{
	protected int vida;

	/******** Contructor: Personaje *******************
		Descripcion: Crea un personaje nuevo
		Parametros:
			vid entero
	************************************************/		
	
	Personaje(int vid){
		vida = vid;
	}

	/******** Contructor: Personaje *******************
		Descripcion: Crea un personaje nuevo
	************************************************/	
	
	Personaje(){
		vida=0;
	}

	/******** Metodo: get_vida *******************
		Descripcion: Obtiene la vida del personaje
		Retorno: Retorna la vida del perosnaje
	************************************************/	
	
	public int get_vida(){
		return vida;
	}

	/******** Metodo: set_vida *******************
		Descripcion: Modifica la vida del personaje
		Parametros:
			vid entero
	************************************************/
	
	public void set_vida(int vid){
		vida = vid;
	}

	/******** Metodo Abstracto: reduce_hp ****************************
		Descripcion: Reduce la vida del jugador
		Parametros:
			damage entero
	******************************************************************/	
	
	abstract int reduce_hp(int damage);
}
