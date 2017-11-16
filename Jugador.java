public class Jugador extends Personaje{
	protected int ataque;
	protected int defensa;
    protected int punto_poder;
	protected String nombre;

	Jugador(int vid, int def, int ata, String name, int pp){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
        this.punto_poder = pp;
	}
}
