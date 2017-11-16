public class Jugador extends Personaje{
	protected int ataque;
	protected int defensa;
    protected int punto_poder;
	protected String nombre;
	protected String esp_1;
	protected int power_1;
	protected int cost_1;
	protected String esp_2;
	protected int power_2;
	protected int cost_2;


	Jugador(int vid, int def, int ata, String name, int pp){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
        this.punto_poder = pp;
	}

	int get_pp(){
		return punto_poder;
	}

	void set_esp1(String name, int power, int pp){
		this.esp_1 = name;
		this.power_1 = power;
		this.cost_1 = pp;
	}

	void set_esp2(String name, int power, int pp){
		this.esp_2 = name;
		this.power_2 = power;
		this.cost_2 = pp;
	}

	void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1+" "+cost_1+"pp");
		System.out.println("Ataque especial: "+esp_2+" "+power_2+" "+cost_2+"pp");
	}
}
