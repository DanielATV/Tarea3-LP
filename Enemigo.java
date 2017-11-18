public class Enemigo extends Personaje{
	protected int ataque;
	protected int defensa;

	Enemigo(int vid, int def, int ata){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
	}

	void display(){
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
	}

	int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}
	
	int get_def(){
		return defensa;
	}

	int get_ata(){
		return ataque;
	}
}
