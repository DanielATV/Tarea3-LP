public class Nivel{
	
	String nombreNivel;
	Jugador player;
	Jefe boss;
	Aliado ally;
	Objeto object;
	Enemigo enemy;
	int cantidadEnemigos;

	Nivel(String nombre,Jugador p1,Jefe jef,Aliado al,Objeto obj,Enemigo enem, int cant ){

	
	nombreNivel = nombre;
	player = p1;
	boss = jef;
	ally = al;
	object = obj;
	enemy = enem;
	cantidadEnemigos = cant;
	
	}
	
	public String getName(){
		return nombreNivel;
	}
	
	public Jugador get_player(){
		return player;
	}
	
	public Jefe get_jefe(){
		return boss;
	}
	
	public Aliado get_ally(){
		return ally;
	}
	
	public Objeto get_obj(){
		return obj;
	}
	
	public Enemigo get_enemy(){
		return enemy;
	}
	
	public int cant_ene(){
		return cantidadEnemigos;
	}

}
