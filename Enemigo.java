
public class Enemigo extends Personaje implements Ataque{
	protected int ataque;
	protected int defensa;

	Enemigo(int vid, int def, int ata){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
	}

	Enemigo(){
		super(0);
		this.ataque= 0;
		this.defensa = 0;
	}

	void set_ata(int ata){
		ataque = ata;
	}

	void set_def(int def){
		defensa = def;
	}

	void set_vida(int vid){
		vida = vid;
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

	public int get_def(){
		return defensa;
	}

	public int get_ata(){
		return ataque;
	}

	public int atacar(int def, int vid){
		if ((ataque - def) <= 0) {
			return vid;
		} else if ((ataque - def) > 0) {
			if ((vid - (ataque - def)) <= 0) {
				return 0;
			}
			return vid - (ataque - def);
		}
		return vid - (ataque - def);
	}

	public int atacar_jugador(Jugador J){
		int dano = atacar(J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	public int atacar_aliado(Aliado A,Jugador J){
		int dano = atacar(0,A.get_vida());
		A.set_vida(dano);
		if (dano == 0) {
			A.delete_item(J);
		}
		return dano;
	}
}
