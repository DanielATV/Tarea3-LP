
public class Jefe extends Personaje implements Ataque,AtaqueEspecial{
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

	Jefe(){
		super(0);
		this.ataque=0;
		this.defensa=0;
		this.nombre="";
	}

	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	void set_ata(int ata)}{
		ataque = ata;
	}

	void set_def(int def){
		defensa = def;
	}

	public int use_esp(String name, int def){
		if (esp_1 == name) {
			if (power_1 <= def) {
				return 0;
			}
		}
		return ataque  +power_1 - def;
	}

	public int get_def(){
		return defensa;
	}

	public int get_ata(){
		return ataque;
	}

	public String get_esp(){
		return esp_1;
	}

	public int get_power_esp(){
		return power_1;
	}

	public String get_nombre(){
		return nombre;
	}

	public void set_esp1(String name, int power){
		this.esp_1 = name;
		this.power_1 = power;
	}

	public void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1);
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

	public int ataque_especial(int opc,int vid, int def){
		if (opc == 1) {
			if ((ataque + power_1 - def)<=0) {
				return 0;
			} else if ((ataque + power_1 - def) > 0) {
				if ((vid - (ataque + power_1 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_1 - def);
				}
			}	
		}
		return vid;
	}

	public int ata_esp_jugador(Jugador J){
		int dano = ataque_especial(1,J.get_vida(),J.get_def());
		J.set_vida(dano);
		return dano;
	}

	public int ata_esp_aliado(Aliado A, Jugador J){
		int dano = ataque_especial(1,A.get_vida(),0);
		A.set_vida(dano);
		if (dano == 0) {
			A.delete_item(J);
		}
		return dano;
	}
}