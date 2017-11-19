import java.io.FileWriter;
import java.io.IOException;

public class Nivel{
	
	String nombreNivel;
	Jugador player;
	Jefe boss;
	Aliado ally;
	Objeto object;
	Enemigo enemy;
	int cantidadEnemigos;

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
	public int simulator(Nivel n){

		Jugador player = n.get_player();
		Jefe boss = n.get_jefe();
		Aliado ally = n.get_ally();
		Objeto object = n.get_obj();
		Enemigo enemy = n.get_enemy();
		int vida_esbirro = enemy.get_vida();
		int cant = n.get_cant();
		int esp_or_not;
		int what_esp;
		int flag=1;
		String which_one;
		ally.assign_item(player); // Asignando atributos del aliado al player
		Test test = new Test(cant); // Creando las listas para aleatoriedad
		int choice = test.rand_path();


		try{

			FileWriter writer = new FileWriter("registro_simulaciones.txt", true);

		}catch(IOException ioe){

	  		ioe.printStackTrace();
		}
		while(flag != 0){
			if (choice == 1) { 
				// Objeto encontrado -- Mobilis in mobili
				player.set_obj(object,0);
			} else if (choice == 2) {
				// Pelea contra esbirro
				while(enemy.get_vida()>0 && player.get_vida()>0){
					// Ataque del player
					esp_or_not = test.atack_choice();
					if (esp_or_not == 1) {
						// Ataque normal hacia el esbirro
						if(player.atacar_enemigo(enemy) == 0){
							// Esbirro derrotado
							break;
						}
					} else if (esp_or_not == 2) {
						// Ataque especial hacia el esbirro siempre y cuando sea posible con los pp actuales
						what_esp = test.select_esp();
						if(player.ata_esp_enemigo(what_esp,enemy) == 0){
							// Esbirro derrotado
							break;
						}
					}
					// Ataque Esbirro
					which_one = test.rand_atack(ally.get_vida());
					if (which_one.equals("Aliado")) {
						enemy.atacar_aliado(ally,player);
						if (player.get_vida() == 0) {
							// Casualidades de objeto el player muere
							flag = 0;
						}
					} else if (which_one.equals("Jugador")) {
						if(enemy.atacar_jugador(player) == 0){
							// El esbirro mata al player
							flag = 0;
						}
					}
				}
				// Resucitando al esbirro y restando de la horda
				cant--;
				enemy.set_vida(vida_esbirro);
			} else if (choice == 3) {
				// Pelea contra jefe -- Shit is getting serious
				while(boss.get_vida()>0 && player.get_vida()>0){
					// Ataque del player
					esp_or_not = test.atack_choice();
					if (esp_or_not == 1) {
						// Ataque normal hacia el jefe
						if(player.atacar_jefe(boss) == 0){
							// jefe derrotado
							flag = 0;
						}
					} else if (esp_or_not == 2) {
						// Ataque especial hacia el jefe siempre y cuando sea posible con los pp actuales
						what_esp = test.select_esp();
						if(player.ata_esp_jefe(what_esp,boss) == 0){
							// jefe derrotado
							flag = 0;
						}
					}
					// Ataque del Jefe
					which_one = test.rand_atack(ally.get_vida());
					esp_or_not = test.atack_choice();
					if (which_one.equals("Aliado")) {
						if (esp_or_not == 1) {
							boss.atacar_aliado(ally,player);
							if (player.get_vida() == 0) {
								// Casualidades de objeto el player muere
								flag = 0;
							}
						} else if (esp_or_not == 2){
							boss.ata_esp_aliado(ally,player);
							if (player.get_vida() == 0) {
								// Casualidades de objeto el player muere
								flag = 0;
							}
						}
					} else if (which_one.equals("Jugador")) {
						if (esp_or_not == 1) {
							if(boss.atacar_jugador(player) == 0){
								// El jefe mata al player
								flag = 0;
							}
						} else if (esp_or_not == 2) {
							if (boss.ata_esp_jugador(player) == 0) {
								// El jefe mata al player
								flag = 0;
							}
						}
					}
				}
			} else {
				System.out.println("Ago raro paso :c");
			
			}
			choice = test.rand_path();
		}
		return cant;
	}

}
