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
	public void simulator(Nivel n){

		Jugador player = n.get_player();
		Jefe boss = n.get_jefe();
		Aliado ally = n.get_ally();
		Objeto object = n.get_obj();
		Enemigo enemy = n.get_enemy();
		int vida_esbirro = enemy.get_vida();
		int cant = n.get_cant();
		int esp_or_not;
		int what_esp;
		String ataq="";
		int flag=1;
		int valor = -1;
		String which_one;
		ally.assign_item(player); // Asignando atributos del aliado al player
		Test test = new Test(cant); // Creando las listas para aleatoriedad
		int choice = test.rand_path();


		try{

			FileWriter writer = new FileWriter("registro_simulaciones.txt", true);
			writer.write(n.get_name());
			writer.write("\n");
			writer.write("comienzoSimulacion");
			writer.write("\n");

			System.out.println("Begin!");

			while(flag != 0){

				if(cant == 0){
					System.out.println("Todos los enemigos han sido derrotados!");
					writer.write("Todos los enemigos han sido derrotados");
					writer.write("\n");
					choice = 3;

				}
				if (choice == 1) { 
					// Objeto encontrado
					System.out.println(object.getNombre() + " encontrado");
					writer.write(player.get_name()+" se encuentra con "+object.getNombre());
					writer.write("\n");
					player.set_obj(object,0);

				} else if (choice == 2) {
					// Pelea contra esbirro
					System.out.println("Enfrentamiento con Enemigo");
					writer.write(player.get_name()+" se encuentra con Enemigo");
					writer.write("\n");


					while(enemy.get_vida()>0 && player.get_vida()>0){
						// Ataque del player

						if(player.get_pp1()>0 || player.get_pp2()>0){

							esp_or_not = test.atack_choice();

						}

						else{

							esp_or_not = 1;
						}
						
						if (esp_or_not == 1) {
							// Ataque normal hacia el esbirro

							valor = player.atacar_enemigo(enemy) ;
							System.out.println(player.get_name()+" ataca Enemigo, "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" Enemigo: "+enemy.get_vida() );
							writer.write(player.get_name()+" ataque Enemigo "+player.get_vida()+" "+ally.get_vida()+" "+enemy.get_vida());
							writer.write("\n");

							if(valor == 0){
								// Esbirro derrotado
								System.out.println("Enemigo derrotado");
								writer.write("Enemigo muere");
								writer.write("\n");
								break;
							}
						} else if (esp_or_not == 2) {
							// Ataque especial hacia el esbirro siempre y cuando sea posible con los pp actuales
							what_esp = test.select_esp();

							if (what_esp == 1){

								if(player.get_pp1()>0){
									ataq = player.get_esp1();

								}
								else{
									ataq = player.get_esp2();
								}
								

							}
							else if (what_esp == 2 ){
								if(player.get_pp2()>0){

									ataq = player.get_esp2();
								}
								else{
									ataq = player.get_esp1();
								}
								

							}

							valor= player.ata_esp_enemigo(what_esp,enemy);

							System.out.println(player.get_name()+" utilizo "+ ataq + " contra Enemigo, Jugador: "+player.get_vida()+" Aliado: "+ally.get_vida()+" Enemigo: "+enemy.get_vida() );
							writer.write("Jugador "+ataq+ " Enemigo "+player.get_vida()+" "+ally.get_vida()+" "+enemy.get_vida());
							writer.write("\n");


							if( valor == 0){
								// Esbirro derrotado

								System.out.println("Enemigo derrotado");
								writer.write("Enemigo muere");
								writer.write("\n");

								break;
							}
						}
						// Ataque Esbirro
						which_one = test.rand_atack(ally.get_vida());
						if (which_one.equals("Aliado")) {
							enemy.atacar_aliado(ally,player);

							System.out.println("Enemigo ataca a Aliado, "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" Enemigo: "+enemy.get_vida() );
							writer.write("Enemigo ataca Aliado "+player.get_vida()+" "+ally.get_vida()+" "+enemy.get_vida());
							writer.write("\n");

							if(ally.get_vida() == 0){

								System.out.println("Tu aliado ha sido derrotado!");
								writer.write("Derrota del aliado");
								writer.write("\n");



							}
							if (player.get_vida() == 0) {
								// Casualidades de objeto el player muere

								System.out.println("Game Over");
								writer.write("Muerte de "+player.get_name());
								writer.write("\n");
								flag = 0;
							}

						} else if (which_one.equals("Jugador")) {

							valor = enemy.atacar_jugador(player);

							System.out.println("Enemigo ataca a"+player.get_name()+", "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" Enemigo: "+enemy.get_vida() );
							writer.write("Enemigo ataca "+player.get_name()+" "+player.get_vida()+" "+ally.get_vida()+" "+enemy.get_vida());
							writer.write("\n");

							if( valor == 0){
								// El esbirro mata al player

								System.out.println("Game Over");
								writer.write("Muerte de "+player.get_name());
								writer.write("\n");
								flag = 0;
							}
						}
					}
					// Resucitando al esbirro y restando de la horda
					cant--;
					enemy.set_vida(vida_esbirro);

				} else if (choice == 3) {
					// Pelea contra jefe
					System.out.println("WARNING!!");
					System.out.println("Batalla final");

					writer.write(player.get_name()+" se encuentra con "+boss.get_nombre());
					writer.write("\n");


					while(boss.get_vida()>0 && player.get_vida()>0){
						// Ataque del player

						if(player.get_pp1()>0 || player.get_pp2()>0){

							esp_or_not = test.atack_choice();

						}

						else{
							
							esp_or_not = 1;
						}


						if (esp_or_not == 1) {
							// Ataque normal hacia el jefe

							valor = player.atacar_jefe(boss);

							System.out.println(player.get_name()+" ataca a "+boss.get_nombre()+", "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_nombre()+" "+boss.get_vida() );
							writer.write(player.get_name()+" ataca "+boss.get_nombre()+" "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida() );
							writer.write("\n");


							if(valor == 0){
								// jefe derrotado
								System.out.println(boss.get_nombre()+ "ha sido derrotado");
								System.out.println("Salvaste al mundo!");
								writer.write("Muerte de "+boss.get_nombre());
								writer.write("\n");

								flag = 0;
							}
						} else if (esp_or_not == 2) {
							// Ataque especial hacia el jefe siempre y cuando sea posible con los pp actuales
							what_esp = test.select_esp();

							if (what_esp == 1){

								if(player.get_pp1()>0){
									ataq = player.get_esp1();

								}
								else{
									ataq = player.get_esp2();
								}
								

							}
							else if (what_esp == 2 ){

								if(player.get_pp2()>0){

									ataq = player.get_esp2();
								}
								else{
									ataq = player.get_esp1();
								}

							}

							valor = player.ata_esp_jefe(what_esp,boss);
							System.out.println(player.get_name()+" utilizo "+ ataq +"contra "+boss.get_nombre()+", "+player.get_name()+": "+player.get_vida()+"Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_vida() );
							writer.write(player.get_name()+" "+ataq+" "+boss.get_nombre()+" "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida());
							writer.write("\n");

							if(valor == 0){
								// jefe derrotado

								System.out.println(boss.get_nombre()+ "ha sido derrotado");
								System.out.println("Salvaste al mundo!");
								writer.write("Muerte de "+boss.get_nombre());
								writer.write("\n");
								flag = 0;
							}
						}
						// Ataque del Jefe
						which_one = test.rand_atack(ally.get_vida());
						esp_or_not = test.atack_choice();
						if (which_one.equals("Aliado")) {
							if (esp_or_not == 1) {
								boss.atacar_aliado(ally,player);

								System.out.println(boss.get_nombre()+" ataca a Aliado, "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_vida() );
								writer.write(boss.get_nombre()+" ataca Aliado "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida());
								writer.write("\n");

								if(ally.get_vida() == 0){
									
									System.out.println("Tu aliado ha sido derrotado!");
									writer.write("Derrota del aliado");
									writer.write("\n");
								}

								if (player.get_vida() == 0) {
									// Casualidades de objeto el player muere
									System.out.println("Game Over");
									writer.write("Muerte de "+player.get_name());
									writer.write("\n");
									flag = 0;
								}
							} else if (esp_or_not == 2){
								boss.ata_esp_aliado(ally,player);

								System.out.println(boss.get_nombre()+" utilizo "+boss.get_esp()+" contra Aliado, "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_vida() );
								writer.write(boss.get_nombre()+" "+boss.get_esp()+" Aliado "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida());
								writer.write("\n");

								if(ally.get_vida() == 0){

									System.out.println("Tu aliado ha sido derrotado!");
									writer.write("Derrota del aliado");
									writer.write("\n");
								}

								if (player.get_vida() == 0) {
									// Casualidades de objeto el player muere
									System.out.println("Game Over");
									writer.write("Muerte de "+player.get_name());
									writer.write("\n");
									flag = 0;
								}
							}

						} else if (which_one.equals("Jugador")) {
							if (esp_or_not == 1) {

								valor = boss.atacar_jugador(player);

								System.out.println(boss.get_nombre()+"ataca "+player.get_name()+", "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_vida() );
								writer.write(boss.get_nombre()+" ataque "+player.get_name()+" "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida());
								writer.write("\n");

								if(valor == 0){
									// El jefe mata al player

									System.out.println("Game Over");
									writer.write("Muerte de "+player.get_name());
									writer.write("\n");

									flag = 0;
								}
							} else if (esp_or_not == 2) {

								valor = boss.ata_esp_jugador(player);

								System.out.println(boss.get_nombre()+" utilizo "+boss.get_esp()+" contra "+player.get_name()+", "+player.get_name()+": "+player.get_vida()+" Aliado: "+ally.get_vida()+" "+boss.get_nombre()+" "+boss.get_vida() );
								writer.write(boss.get_nombre()+" "+boss.get_esp()+" "+player.get_name()+" "+player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida());
								writer.write("\n");

								if ( valor == 0) {
									// El jefe mata al player
									System.out.println("Game Over");
									writer.write("Muerte de "+player.get_name());
									writer.write("\n");
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
			System.out.println("Fin de la simulacion");
			writer.write("finalSimulacion");
			writer.write("\n");
			writer.write(player.get_vida()+" "+ally.get_vida()+" "+boss.get_vida()+" "+cant);
			writer.write("\n");
			writer.close();
			

		}catch(IOException ioe){

	  		ioe.printStackTrace();
		}

			
	}

}
