import java.util.ArrayList;
import java.util.Random;
import java.util.List;


int Simulator(Nivel N){
	Jugador Player = N.get_player();
	Jefe Boss = N.get_jefe();
	Aliado Ally = N.get_ally();
	Objeto Object = N.get_obj();
	Enemigo Enemy = N.get_enemy();
	int vida_esbirro = Enemy.get_vida();
	int Cant = N.get_cant();
	int esp_or_not;
	int what_esp;
	int Flag=1;
	String which_one;
	Ally.assign_item(Player); // Asignando atributos del aliado al player
	test Test = new test(Cant); // Creando las listas para aleatoriedad
	int choice = Test.rand_path();
	while(Flag != 0){
		if (choice == 1) { 
			// Objeto encontrado -- Mobilis in mobili
			Player.set_obj(Object,0);
		} else if (choice == 2) {
			// Pelea contra esbirro
			while(Enemy.get_vida()>0 && Jugador.get_vida()>0){
				// Ataque del Player
				esp_or_not = Test.atack_choice();
				if (esp_or_not == 1) {
					// Ataque normal hacia el esbirro
					if(Jugador.atacar_enemigo(Enemy) == 0){
						// Esbirro derrotado
						break;
					}
				} else if (esp_or_not == 2) {
					// Ataque especial hacia el esbirro siempre y cuando sea posible con los pp actuales
					what_esp = Test.select_esp();
					if(Player.ata_esp_enemigo(what_esp,Enemy) == 0){
						// Esbirro derrotado
						break;
					}
				}
				// Ataque Esbirro
				which_one = Test.rand_atack(Aliado.get_vida());
				if (which_one.equals("Aliado")) {
					Enemy.atacar_aliado(Ally,Player);
					if (Player.get_vida() == 0) {
						// Casualidades de objeto el player muere
						Flag = 0;
					}
				} else if (which_one.equals("Jugador") == 0) {
					if(Enemy.atacar_jugador(Player) == 0){
						// El esbirro mata al player
						Flag = 0;
					}
				}
			}
			// Resucitando al esbirro y restando de la horda
			Cant--;
			Enemy.get_vida(vida_esbirro);
		} else if (choice == 3) {
			// Pelea contra jefe -- Shit is getting serious
			while(Boss.get_vida()>0 && Jugador.get_vida()>0){
				// Ataque del Player
				esp_or_not = Test.atack_choice();
				if (esp_or_not == 1) {
					// Ataque normal hacia el jefe
					if(Jugador.atacar_jefe(Boss) == 0){
						// jefe derrotado
						Flag = 0;
					}
				} else if (esp_or_not == 2) {
					// Ataque especial hacia el jefe siempre y cuando sea posible con los pp actuales
					what_esp = Test.select_esp();
					if(Player.ata_esp_jefe(what_esp,Boss) == 0){
						// jefe derrotado
						Flag = 0;
					}
				}
				// Ataque del Jefe
				which_one = Test.rand_atack(Aliado.get_vida());
				esp_or_not = Test.atack_choice();
				if (which_one.equals("Aliado")) {
					if (esp_or_not == 1) {
						Boss.atacar_aliado(Ally,Player);
						if (Player.get_vida() == 0) {
							// Casualidades de objeto el player muere
							Flag = 0;
						}
					} else if (esp_or_not == 2){
						Boss.ata_esp_aliado(Ally,Player);
						if (Player.get_vida() == 0) {
							// Casualidades de objeto el player muere
							Flag = 0;
						}
					}
				} else if (which_one.equals("Jugador")) {
					if (esp_or_not == 1) {
						if(Boss.atacar_jugador(Player) == 0){
							// El jefe mata al player
							Flag = 0;
						}
					} else if (esp_or_not == 2) {
						if (Boss.ata_esp_aliado(Player) == 0) {
							// El jefe mata al player
							Flag = 0;
						}
					}
				}
			}
		} else {
			System.out.println("Ago raro paso :c");
			exit(0);
		}
		choice = Test.rand_path();
	}
	return Cant;
}