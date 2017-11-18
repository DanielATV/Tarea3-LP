public class Aliado extends Personaje{
	Objeto A;
	
	Aliado(int vida, Objeto B){
		super(vida);
		this.A = B;
	}

	void assign_item(Jugador C){
		if (A.getAtributo()=="vida"){
			C.set_vida(C.get_vida()+A.getValor());
		}else if (A.getAtributo()=="defensa"){
			C.set_def(C.get_def()+A.getValor());
		} else {
			C.set_ata(C.get_ata()+A.getValor());
		}
	}

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

	int reduce_hp(int damage){
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	public void set_vida(int vid){
		vida = vid;
	}

	void display(){
		System.out.print("Aliado: "+vida+" HP ");
		A.display();
	}	
}
