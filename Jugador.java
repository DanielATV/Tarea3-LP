public class Jugador extends Personaje implements Ataque{
	protected int ataque;
	protected int defensa;
	protected String nombre;
	protected String esp_1;
	protected int power_1;
	protected int cost_1;
	protected String esp_2;
	protected int power_2;
	protected int cost_2;
	protected Objeto obj1;
	protected int obj1_bool = 0;
	protected Objeto obj2;
	protected int obj2_bool = 0;


	Jugador(int vid, int def, int ata, String name){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
	}

	public int get_def(){
		return defensa;
	}

	public int get_ata(){
		return ataque;
	}

	public void set_esp1(String name, int power, int pp){
		this.esp_1 = name;
		this.power_1 = power;
		this.cost_1 = pp;
	}

	public void set_esp2(String name, int power, int pp){
		this.esp_2 = name;
		this.power_2 = power;
		this.cost_2 = pp;
	}

	public int use_esp(String name, int def){
		if (esp_1.equals(name)) {
			if (cost_1 == 0) {
				return -1;
			}
			cost_1 = cost_1 - 1;
			if (power_1 <= def) {
				return 0;
			}
			return ataque + power_1 - def;
		} else if (esp_2.equals(name)) {
			if (cost_2 == 0) {
				return -1;
			}
			cost_2 = cost_2 -1;
			if (power_2 <= def) {
				return 0;
			}
			return ataque + power_2 - def;
		}
		return 0;
	}

	public void set_ata(int ata){
		ataque = ata;
	}
	
	public void set_def(int def){
		defensa = def;
	}
	
	public void set_vida(int vid){
		vida = vid;
	}

	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	public void set_obj(Objeto A, int ini){
		if (ini == 1){
			obj1_bool = 1;
			obj1 = A;
			if (A.getAtributo() == "vida") {
				vida = vida + A.getValor();
			} else if (A.getAtributo() == "defensa"){
				defensa = defensa + A.getValor();
			} else {
				ataque = ataque + A.getValor();
			}
		} else {
			obj2_bool = 1;
			obj2 = A;
			if (A.getAtributo() == "vida") {
				vida = vida + A.getValor();
			} else if (A.getAtributo() == "defensa"){
				defensa = defensa + A.getValor();
			} else {
				ataque = ataque + A.getValor();
			}
		}
	}

	public void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1+" "+cost_1+"pp");
		System.out.println("Ataque especial: "+esp_2+" "+power_2+" "+cost_2+"pp");
		if (obj1_bool == 1) {
			obj1.display();
		}
		if (obj2_bool == 1) {
			obj2.display();
		}
	}

	public int atacar(int ata, int def, int vid){
		if ((ata - def) <= 0) {
			return vid;
		} else if ((ata - def) > 0) {
			if ((vid - (ata - def)) <= 0) {
				return 0;
			}
			return vid - (ata - def);
		}
		return vid - (ata - def);
	}

	public int atacar_jefe(Jefe J){
		int dano = atacar(ataque,J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	public int atacar_enemigo(Enemigo E){
		int dano = atacar(ataque,E.get_def(),E.get_vida());
		E.set_vida(dano);
		return dano;
	}
}