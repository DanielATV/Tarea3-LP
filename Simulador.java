import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Simulador{
	public int Simulator(Nivel N){
		Nivel Aux = N;
		Jugador player = Aux.get_player();
		Jefe boss = Aux.get_jefe();
		Aliado ally = Aux.get_ally();
		Objeto Object = Aux.get_obj();
		Enemigo enemy = Aux.get_enemy();
		int vida_esbirro = enemy.get_vida();
		int Cant = N.get_cant();
		int esp_or_not;
		int what_esp;
		int Flag=1;
		String which_one;
		ally.assign_item(player); // Asignando atributos del aliado al player
		test Test = new test(Cant); // Creando las listas para aleatoriedad
		int choice = Test.rand_path();
		while(Flag != 0){
			if (choice == 1) { 
				// Objeto encontrado -- Mobilis in mobili
				player.set_obj(Object,0);
			} else if (choice == 2) {
				// Pelea contra esbirro
				while(enemy.get_vida()>0 && player.get_vida()>0){
					// Ataque del player
					esp_or_not = Test.atack_choice();
					if (esp_or_not == 1) {
						// Ataque normal hacia el esbirro
						if(player.atacar_enemigo(enemy) == 0){
							// Esbirro derrotado
							break;
						}
					} else if (esp_or_not == 2) {
						// Ataque especial hacia el esbirro siempre y cuando sea posible con los pp actuales
						what_esp = Test.select_esp();
						if(player.ata_esp_enemigo(what_esp,enemy) == 0){
							// Esbirro derrotado
							break;
						}
					}
					// Ataque Esbirro
					which_one = Test.rand_atack(ally.get_vida());
					if (which_one.equals("Aliado")) {
						enemy.atacar_aliado(ally,player);
						if (player.get_vida() == 0) {
							// Casualidades de objeto el player muere
							Flag = 0;
						}
					} else if (which_one.equals("Jugador")) {
						if(enemy.atacar_jugador(player) == 0){
							// El esbirro mata al player
							Flag = 0;
						}
					}
				}
				// Resucitando al esbirro y restando de la horda
				Cant--;
				enemy.set_vida(vida_esbirro);
			} else if (choice == 3) {
				// Pelea contra jefe -- Shit is getting serious
				while(boss.get_vida()>0 && player.get_vida()>0){
					// Ataque del player
					esp_or_not = Test.atack_choice();
					if (esp_or_not == 1) {
						// Ataque normal hacia el jefe
						if(player.atacar_jefe(boss) == 0){
							// jefe derrotado
							Flag = 0;
						}
					} else if (esp_or_not == 2) {
						// Ataque especial hacia el jefe siempre y cuando sea posible con los pp actuales
						what_esp = Test.select_esp();
						if(player.ata_esp_jefe(what_esp,boss) == 0){
							// jefe derrotado
							Flag = 0;
						}
					}
					// Ataque del Jefe
					which_one = Test.rand_atack(ally.get_vida());
					esp_or_not = Test.atack_choice();
					if (which_one.equals("Aliado")) {
						if (esp_or_not == 1) {
							boss.atacar_aliado(ally,player);
							if (player.get_vida() == 0) {
								// Casualidades de objeto el player muere
								Flag = 0;
							}
						} else if (esp_or_not == 2){
							boss.ata_esp_aliado(ally,player);
							if (player.get_vida() == 0) {
								// Casualidades de objeto el player muere
								Flag = 0;
							}
						}
					} else if (which_one.equals("Jugador")) {
						if (esp_or_not == 1) {
							if(boss.atacar_jugador(player) == 0){
								// El jefe mata al player
								Flag = 0;
							}
						} else if (esp_or_not == 2) {
							if (boss.ata_esp_jugador(player) == 0) {
								// El jefe mata al player
								Flag = 0;
							}
						}
					}
				}
			} else {
				System.out.println("Ago raro paso :c");
			}
			choice = Test.rand_path();
		}
		return Cant;
	}
}