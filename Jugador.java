public class Jugador extends Personaje implements Ataque,AtaqueEspecial{
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

	Jugador(){
		super(0);
		this.ataque = 0;
		this.defensa = 0;
		this.nombre = "";
	}

	public void set_nombre(String nom){
		nombre = nom;
	}

	public int get_def(){
		return defensa;
	}

	public int get_pp1(){
		return cost_1;
	}

	public int get_pp2(){
		return cost_2;
	}

	public int get_ata(){
		return ataque;
	}

	public String get_esp1(){
		return esp_1;
	}

	public String get_esp2(){
		return esp_2;
	}

	public String get_name(){
		return nombre;
	}

	public int get_power_esp1(){
		return power_1;
	}

	public int get_power_esp2(){
		return power_2;
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

	public void set_name(String name){
		nombre = name;
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

	public int ataque_especial(int opc,int vid, int def){
		if (opc == 1) {
			cost_1--;
			if ((ataque + power_1 - def) <= 0) {
				return 0;
			} else if ((ataque + power_1 - def) > 0) {
				if ((vid - (ataque + power_1 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_1 - def);
				}
			}	
		} else if (opc == 2) {
			cost_2--;
			if ((ataque + power_2 - def)<=0) {
				return 0;
			} else if ((ataque + power_2 - def) > 0) {
				if ((vid - (ataque + power_2 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_2 - def);
				}
			}
		}
		return vid;
	}

	public int atacar_jefe(Jefe J){
		int dano = atacar(J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	public int atacar_enemigo(Enemigo E){
		int dano = atacar(E.get_def(),E.get_vida());
		E.set_vida(dano);
		return dano;
	}

	public int ata_esp_enemigo(int opc,Enemigo E){
		int dano;
		if (opc == 1 && cost_1 > 0) {
			dano = ataque_especial(1,E.get_vida(),E.get_def());
			E.set_vida(dano);	
		} else if (opc == 2 && cost_2 > 0) {
			dano = ataque_especial(2,E.get_vida(),E.get_def());
			E.set_vida(dano);	
		} else {
			dano = atacar(E.get_def(),E.get_vida());
			E.set_vida(dano);
		}
		return dano;
	}

	public int ata_esp_jefe(int opc,Jefe J){
		int dano;
		if (opc == 1 && cost_1 > 0) {
			dano = ataque_especial(1,J.get_vida(),J.get_def());
			J.set_vida(dano);	
		} else if (opc == 2 && cost_2 > 0) {
			dano = ataque_especial(2,J.get_vida(),J.get_def());
			J.set_vida(dano);	
		} else {
			dano = atacar(J.get_def(),J.get_vida());
			J.set_vida(dano);
		}
		return dano;
	}

}
