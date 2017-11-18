
public class Jefe extends Personaje implements Ataque{
	protected int ataque;
	protected int defensa;
	protected String nombre;
	protected String esp_1;
	protected int power_1;


	Jefe(int vid, int def, int ata, String name){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
	}

	int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	int use_esp(String name, int def){
		if (esp_1 == name) {
			if (power_1 <= def) {
				return 0;
			}
		}
		return ataque  +power_1 - def;
	}

	int get_def(){
		return defensa;
	}

	int get_ata(){
		return ataque;
	}

	public void set_vida(int vid){
		vida = vid;
	}

	void set_esp1(String name, int power){
		this.esp_1 = name;
		this.power_1 = power;
	}

	void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1);
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