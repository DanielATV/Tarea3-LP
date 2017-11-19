abstract public class Personaje{
	protected int vida;

	Personaje(int vid){
		vida = vid;
	}

	Personaje(){
		vida=0;
	}

	public int get_vida(){
		return vida;
	}

	public void set_vida(int vid){
		vida = vid;
	}

	abstract int reduce_hp(int damage);
}
