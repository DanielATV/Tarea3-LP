public class Aliado extends Personaje{
	Objeto A;
	
	/******** Contructor: Aliado ********************
		Descripcion: Crea un aliado nuevo
		Parametros:
			vida entero
			B Objeto
	************************************************/
	
	Aliado(int vida, Objeto B){
		super(vida);
		this.A = B;
	}

	/******** Metodo: set_obj ***************************************
		Descripcion: Establece el objeto del aliado
		Parametros:
			ob Objeto
	******************************************************************/
	
	public void set_obj(Objeto ob){
		A = ob;
	}

	/******** Metodo: assign_item ***************************
		Descripcion: Asigna el item del aliado a un jugador
		Parametros:
			C Jugador
	*********************************************************/
	
	void assign_item(Jugador C){
		if (A.getAtributo()=="vida"){
			C.set_vida(C.get_vida()+A.getValor());
		}else if (A.getAtributo()=="defensa"){
			C.set_def(C.get_def()+A.getValor());
		} else {
			C.set_ata(C.get_ata()+A.getValor());
		}
	}

	/******** Metodo: delete_item ************************************
		Descripcion: Desasigna el item del aliado hacia 
			     el jugador y verifica si este muere 
			     en el proceso
		Parametros:
			C Jugador
		Retorno: 0 en caso de muerte del jugador 1 en caso contrario
	******************************************************************/
	
	int delete_item(Jugador C){
		if (A.getAtributo()=="vida"){
			if ((C.get_vida()-A.getValor())<=0){
				C.set_vida(0);
				return 0;
			}
			C.set_vida(C.get_vida()-A.getValor());
			return 1;
		} else if (A.getAtributo()=="defensa"){
				C.set_def(C.get_def()-A.getValor());
				return 1;
		} else {
				C.set_ata(C.get_ata()-A.getValor());
				return 1;
		}
	}
	
	/******** Metodo: reduce_hp **************************************
		Descripcion: Reduce la vida del aliado
		Parametros:
			damage entero
		Retorno: 0 en caso de muerte del aliado 1 en caso contrario
	******************************************************************/
	
	int reduce_hp(int damage){
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	
	/******** Metodo: get_objeto *************************************
		Descripcion: Obtiene el objeto del aliado
		Retorno: Retorna el objeto del aliado
	******************************************************************/
	
	Objeto get_obj(){
		return A;
	}

	/******** Metodo: set_vida ***************************************
		Descripcion: Establece la vida del aliado
		Parametros:
			vid entero
	******************************************************************/
	
	public void set_vida(int vid){
		vida = vid;
	}

	/******** Metodo: display ****************************************
		Descripcion: Imprime en pantalla 
					 el estado de salud del aliado
	******************************************************************/
	
	void display(){
		System.out.print("Aliado: "+vida+" HP ");
		A.display();
	}	
}
