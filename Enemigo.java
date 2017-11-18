public class Enemigo extends Personaje implements Ataque{
	protected int ataque;
	protected int defensa;

	Enemigo(int vid, int def, int ata){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
	}

	public void display(){
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
	}

	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	public void set_vida(int vid){
		vida = vid;
	}

	public int get_def(){
		return defensa;
	}

	public int get_ata(){
		return ataque;
	}

	public int atacar_jugador(Jugador J){
		int dano = atacar(ataque,J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	public int atacar_aliado(Aliado A,Jugador J){
		int dano = atacar(ataque,0,A.get_vida());
		A.set_vida(dano);
		if (dano == 0) {
			A.delete_item(J);
		}
		return dano;
	}
}
