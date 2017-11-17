
public class Jefe extends Personaje{
	protected int ataque;
	protected int defensa;
    protected int punto_poder;
	protected String nombre;
	protected String esp_1;
	protected int power_1;


	Jefe(int vid, int def, int ata, String name){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
	}

	int get_pp(){
		return punto_poder;
	}

	int get_def(){
		return defensa;
	}

	int get_ata(){
		return ataque;
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
}