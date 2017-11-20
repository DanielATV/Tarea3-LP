public class Nivel{
	
	String nombreNivel = "";
	Jugador player = new Jugador();
	Jefe boss = new Jefe();
	Aliado ally = new Aliado();
	Objeto object = new Objeto();
	Enemigo enemy = new Enemigo();
	int cantidadEnemigos = 0;

	Nivel(String nombre,Jugador p1,Jefe jef, Aliado al, Objeto obj, Enemigo enem, int cant){
		nombreNivel = nombre;
		player = p1;
		boss = jef;
		ally = al;
		object = obj;
		enemy = enem;
		cantidadEnemigos = cant;
	}
	
	public String get_name(){
		return nombreNivel;
	}
	
	public void set_name(String name){
		nombreNivel = name;
	}
	
	public Jugador get_player(){
		return player;
	}
	
	public void set_player(Jugador J){
		player = J;
	}
	
	public Jefe get_jefe(){
		return boss;
	}
	
	public void set_jefe(Jefe J){
		boss = J;
	}
	
	public Aliado get_ally(){
		return ally;
	}
	
	public void set_ally(Aliado A){
		ally = A;
	}
	
	public Objeto get_obj(){
		return object;
	}
	
	public void set_obj(Objeto O){
		object = O;
	}
	
	public Enemigo get_enemy(){
		return enemy;
	}
	
	public void set_enemy(Enemigo E){
		enemy = E;
	}
	
	public int get_cant(){
		return cantidadEnemigos;
	}
	
	public void set_cant(int cant){
		cantidadEnemigos = cant;
	}

}
