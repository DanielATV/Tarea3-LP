abstract public class Personaje{
	protected int vida;

	Personaje(int vid){
		vida = vid;
	}

	int get_vida(){
		return vida;
	}

	abstract int reduce_hp(int damage);
}