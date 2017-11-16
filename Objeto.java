public class Objeto{
	protected String nombre;
	protected int bonus_vida;
	protected int bonus_ataque;
	protected int bonus_defensa;

	Objeto(String name, int b_v, int b_d, int b_a){
		nombre = name;
		bonus_defensa = b_d;
		bonus_ataque = b_a;
		bonus_vida = b_v;
	}
}
