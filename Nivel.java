public class Nivel{
	
	String nombreNivel;
	Jugador player;
	Jefe boss;
	Aliado ally;
	Objecto object;
	Enemigo enemy;
	int cantidadEnemigos;

	Nivel(String nombre,Jugador p1,Jefe jef,Aliado al,Objecto obj,Enemigo enem, int cant ){

	
	nombreNivel = nombre;
	player = p1;
	boss = jef;
	ally = al;
	object = obj;
	enemy = enem;
	cantidadEnemigos = cant;
	
	}

}
