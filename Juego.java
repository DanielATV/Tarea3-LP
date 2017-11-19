import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Juego {

	public int Simulator(Nivel N){

		Jugador player = N.get_player();
		Jefe boss = N.get_jefe();
		Aliado ally = N.get_ally();
		Objeto object = N.get_obj();
		Enemigo enemy = N.get_enemy();
		int vida_esbirro = enemy.get_vida();
		int cant = N.get_cant();
		int esp_or_not;
		int what_esp;
		int flag=1;
		String which_one;
		ally.assign_item(player); // Asignando atributos del aliado al player
		test test = new test(cant); // Creando las listas para aleatoriedad
		int choice = test.rand_path();
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

	public static void main(String[] args) {

		String nombreNiv = "";
	  	String nombreJug;
	  	int vidaJug;
	  	int ataqJug;
	  	int defJug;
	  	String ataque1;
	  	String ataque2;
	  	String obj = "";
	  	int cantEn;
	  	String atributo = "";
	  	int stat = -1;
	  	boolean juego = true;
	  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	  	String linea;
	  	String lineaAux = "";
	  	boolean menu;
	  	boolean subMenu;
	  	int opcion = -1;
	  	
	  	StringBuffer stringBuffer = new StringBuffer();
	  	String[] tokens;
	  	int contador;

	  	Nivel N;
		String name;
		int size;
		int i;
	  

		List<Nivel> listaNiveles = new ArrayList<Nivel>();

		Jugador playerDummy = new Jugador(-1,-1,-1,"");
		Objeto objJugDummy = new Objeto("","",-1);
		Jefe bossDummy = new Jefe(-1,-1,-1,"");
		Objeto objAllyDummy = new Objeto("","",-1);
		Aliado allyDummy = new Aliado(-1,objAllyDummy);
		Objeto objNivDummy = new Objeto("","",-1);
		Enemigo eneDummy = new Enemigo(-1,-1,-1);
		Nivel nivelDummy = new Nivel("",playerDummy,bossDummy,allyDummy,objNivDummy,eneDummy,-1);
		



	  	try{

	  		File file = new File("niveles.txt");
		  	FileReader fileReader = new FileReader(file);
		  	BufferedReader bufferedReader = new BufferedReader(fileReader);
		  	contador = 0;

	  		while ((linea = bufferedReader.readLine()) != null){
	  		tokens = linea.split(" ");

	  		if (contador == 0){
	  			contador += 1;
	  			nombreNiv = tokens[0];
	  					

	  		}
	  		else if(contador == 1){

	  			contador += 1;

	  			nombreJug =tokens[0];
	  			playerDummy.set_nombre(nombreJug);
	  			vidaJug = Integer.parseInt(tokens[1]);
	  			playerDummy.set_vida(vidaJug);
				ataqJug =  Integer.parseInt(tokens[2]);
				playerDummy.set_ata(ataqJug);
				defJug = Integer.parseInt(tokens[3]);
				playerDummy.set_def(defJug);

				ataque1 = tokens[4];
				ataque2 = tokens[5];

				if (tokens[4].equals("Guillotine_Fist")){

					playerDummy.set_esp1(ataque1,200,30);

				}
				else if (tokens[4].equals("Rising_Dragon")){

					playerDummy.set_esp1(ataque1,500,25);

				}
				else if (tokens[4].equals("Knuckle_ArrowFist")){

					playerDummy.set_esp1(ataque1,100,50);


				}
				else if (tokens[4].equals("Gate_of_Hell")){

					playerDummy.set_esp1(ataque1,5000,5);

				}

				if (tokens[5].equals("Guillotine_Fist")){

					playerDummy.set_esp2(ataque2,200,30);

				}
				else if (tokens[5].equals("Rising_Dragon")){

					playerDummy.set_esp2(ataque2,500,25);


				}
				else if (tokens[5].equals("Knuckle_ArrowFist")){

					playerDummy.set_esp2(ataque2,100,50);


				}
				else if (tokens[5].equals("Gate_of_Hell")){

					playerDummy.set_esp2(ataque2,5000,5);

				}

				if (tokens.length == 7){
					obj= tokens[6];

	  				if (obj.equals("Veil_of_Discord")){

	  					objJugDummy.set_nombre(obj);
	  					objJugDummy.set_atributo("defensa");
	  					objJugDummy.set_valor(600);

	  		
							
						playerDummy.set_obj(objJugDummy,1);


					}
					else if (obj.equals("Chainmail")){

						objJugDummy.set_nombre(obj);
	  					objJugDummy.set_atributo("defensa");
	  					objJugDummy.set_valor(500);
		
								
						playerDummy.set_obj(objJugDummy,1);


								
					}
					else if (obj.equals("Guardian_Greaves")){

						objJugDummy.set_nombre(obj);
	  					objJugDummy.set_atributo("vida");
	  					objJugDummy.set_valor(500);

			
						playerDummy.set_obj(objJugDummy,1);
								
					}
					else if (obj.equals("Lotus_Orb")){

						objJugDummy.set_nombre(obj);
	  					objJugDummy.set_atributo("vida");
	  					objJugDummy.set_valor(1000);

								
						playerDummy.set_obj(objJugDummy,1);

					}
				}

						

	  		}
	  		else if(contador == 2){

				contador += 1;
				nombreJug =tokens[0];
				bossDummy.set_nombre(nombreJug);
				vidaJug = Integer.parseInt(tokens[1]);
				bossDummy.set_vida(vidaJug);
				ataqJug =  Integer.parseInt(tokens[2]);
				bossDummy.set_ata(ataqJug);
				defJug = Integer.parseInt(tokens[3]);
				bossDummy.set_def(defJug);

				ataque1 = tokens[4];

				if (tokens[4].equals("Cannon_Spear")){

					bossDummy.set_esp1(ataque1,300);


				}

				else if (tokens[4].equals("Limit_Break")){
							
					bossDummy.set_esp1(ataque1,10000);

				}

	  		}
	  		else if(contador == 3){
	  			contador += 1;

	  			vidaJug = Integer.parseInt(tokens[0]);
	  			allyDummy.set_vida(vidaJug);

	  			obj= tokens[1];

				if (obj.equals("Veil_of_Discord")){

					objAllyDummy.set_nombre(obj);
					objAllyDummy.set_atributo("defensa");
					objAllyDummy.set_valor(600);

		
					allyDummy.set_obj(objAllyDummy);


				}

				else if (obj.equals("Chainmail")){
					objAllyDummy.set_nombre(obj);
					objAllyDummy.set_atributo("defensa");
					objAllyDummy.set_valor(500);

					
					allyDummy.set_obj(objAllyDummy);


					
				}
				else if (obj.equals("Guardian_Greaves")){

					objAllyDummy.set_nombre(obj);
					objAllyDummy.set_atributo("vida");
					objAllyDummy.set_valor(500);


					allyDummy.set_obj(objAllyDummy);
					
				}
				else if (obj.equals("Lotus_Orb")){

					objAllyDummy.set_nombre(obj);
					objAllyDummy.set_atributo("vida");
					objAllyDummy.set_valor(1000);

					
					allyDummy.set_obj(objAllyDummy);

				}


	  		}
			else if(contador == 4){
				contador += 1;
				obj= tokens[0];

				if (obj.equals("Veil_of_Discord")){

					objNivDummy.set_nombre(obj);
					objNivDummy.set_atributo("defensa");
					objNivDummy.set_valor(600);


				}

				else if (obj.equals("Chainmail")){

					objNivDummy.set_nombre(obj);
					objNivDummy.set_atributo("defensa");
					objNivDummy.set_valor(500);

								
				}
				else if (obj.equals("Guardian_Greaves")){

					objNivDummy.set_nombre(obj);
					objNivDummy.set_atributo("vida");
					objNivDummy.set_valor(500);

				}

				else if (obj.equals("Lotus_Orb")){

					objNivDummy.set_nombre(obj);
					objNivDummy.set_atributo("vida");
					objNivDummy.set_valor(1000);

				}
			}
	  		else {
	  			cantEn = Integer.parseInt(tokens[0]);

				vidaJug = Integer.parseInt(tokens[1]);
				eneDummy.set_vida(vidaJug);
				ataqJug =  Integer.parseInt(tokens[2]);
				eneDummy.set_ata(ataqJug);
				defJug = Integer.parseInt(tokens[3]);
				eneDummy.set_def(defJug);

				contador = 0;

				nivelDummy.set_name(nombreNiv);
				nivelDummy.set_player(playerDummy);
				nivelDummy.set_jefe(bossDummy);
				nivelDummy.set_ally(allyDummy);
				nivelDummy.set_obj(objNivDummy);
				nivelDummy.set_enemy(eneDummy);
				nivelDummy.set_cant(cantEn);
				listaNiveles.add(nivelDummy);



			}


		}

		fileReader.close();

		System.out.println("Niveles cargados:");

			
		size = listaNiveles.size();
		i=0;

		while(i < size){
			N = listaNiveles.get(i);
			name = N.get_name();
			System.out.println(name);

			i++;
		}

	  	}catch(IOException ioe){

	  		ioe.printStackTrace();
		}



	  	while(juego){

	  		try{

	  			


				System.out.println("1. Crear Nivel");
				System.out.println("2. Simular avance en Nivel");
				System.out.println("3. Consultar informacion de Nivel");
				System.out.println("4. Salir");
				System.out.print("Opcion: ");


				linea = reader.readLine();
				//Falta ver cuando son menos que 0 los enteros;
				if (linea.equals("1")){

					menu = true;

					try {

						FileWriter writer = new FileWriter("niveles.txt", true);
						System.out.print("Nombre del Nivel: ");
						linea = reader.readLine();
						nombreNiv = linea;
						writer.write(nombreNiv);
						writer.write("\n");
						System.out.print("Nombre del Jugador: ");
						linea = reader.readLine();
						nombreJug = linea;
						writer.write(nombreJug + " ");
						System.out.print("Vida del Jugador: ");
						linea = reader.readLine();
						vidaJug = Integer.parseInt(linea);
						writer.write(vidaJug + " ");
						System.out.print("Ataque del Jugador: ");
						linea = reader.readLine();
						ataqJug = Integer.parseInt(linea);
						writer.write(ataqJug + " ");
						System.out.print("Defensa del Jugador: ");
						linea = reader.readLine();
						defJug = Integer.parseInt(linea);
						writer.write(defJug + " ");

						Jugador player = new Jugador(vidaJug,defJug,ataqJug,nombreJug);

						System.out.println("Elegir ataques especiales:");
						System.out.println("1. Guillotine Fist +200 ataque, 30pp");
						System.out.println("2. Rising Dragon +500 ataque, 25pp");
						System.out.println("3. Knuckle Arrow +100 ataque, 50pp");
						System.out.println("4. Gate of Hell +5000 ataque, 5pp");

						while(menu){
							
							System.out.print("Poder 1: ");
							linea = reader.readLine();
							lineaAux = linea;
							
							if (linea.equals("1")){
								ataque1 = "Guillotine_Fist";
								writer.write(ataque1 + " ");
								player.set_esp1(ataque1,200,30);
								menu = false;

							}
							else if (linea.equals("2")){
								ataque1 = "Rising_Dragon";
								writer.write(ataque1 + " ");
								player.set_esp1(ataque1,500,25);
								menu = false;


							}
							else if (linea.equals("3")){
								ataque1 = "Knuckle_ArrowFist";
								writer.write(ataque1 + " ");
								player.set_esp1(ataque1,100,50);
								menu = false;


							}
							else if (linea.equals("4")){
								ataque1 = "Gate_of_Hell";
								writer.write(ataque1 + " ");
								player.set_esp1(ataque1,5000,5);
								menu = false;


							}
							else{
								System.out.println("Opcion no valida");
							}

						}
						menu = true;

						while (menu){

							System.out.print("Poder 2: ");
							linea = reader.readLine();

							if(linea.equals(lineaAux)){
								System.out.println("No puede ser el mismo poder");

							}
							else if (linea.equals("1")){
								ataque2 = "Guillotine_Fist";
								writer.write(ataque2 + " ");
								player.set_esp2(ataque2,200,30);
								menu = false;

							}
							else if (linea.equals("2")){
								ataque2 = "Rising_Dragon";
								writer.write(ataque2 + " ");
								player.set_esp2(ataque2,500,25);
								menu = false;



							}
							else if (linea.equals("3")){
								ataque2 = "Knuckle_Arrow";
								writer.write(ataque2 + " ");
								player.set_esp2(ataque2,100,50);
								menu = false;



							}
							else if (linea.equals("4")){
								ataque2 = "Gate_of_Hell";
								writer.write(ataque2 + " ");
								player.set_esp2(ataque2,5000,5);
								menu = false;


							}
							else{
								System.out.print("Opcion no valida");
							}

						}

						menu = true;
						System.out.println("Desea equipar un objeto? y/n");

						while(menu){
							System.out.print("Opcion: ");

							linea = reader.readLine();


							if( linea.equals("y")){
								menu = false;
								subMenu = true;
								System.out.println("1. Veil of Discord +600 defensa");
								System.out.println("2. Chainmail +500 defensa");
								System.out.println("3. Guardian Greaves + 500 vida");
								System.out.println("4. Lotus Orb +1000 vida");

								while(subMenu){
									System.out.print("Opcion: ");
									linea = reader.readLine();

									if (linea.equals("1")){
										obj = "Veil_of_Discord";
										writer.write(obj);
										writer.write("\n");
										Objeto objJug = new Objeto(obj,"defensa",600);
										player.set_obj(objJug,1);
										subMenu = false;

									}
									else if (linea.equals("2")){
										obj = "Chainmail";
										writer.write(obj);
										writer.write("\n");
										Objeto objJug = new Objeto(obj,"defensa",500);
										player.set_obj(objJug,1);
										subMenu = false;

										
									}
									else if (linea.equals("3")){
										obj = "Guardian_Greaves";
										writer.write(obj);
										writer.write("\n");
										Objeto objJug = new Objeto(obj,"vida",500);
										player.set_obj(objJug,1);
										subMenu = false;

										
									}
									else if (linea.equals("4")){
										obj = "Lotus_Orb";
										writer.write(obj);
										writer.write("\n");
										Objeto objJug = new Objeto(obj,"vida",1000);
										player.set_obj(objJug,1);
										subMenu = false;
										
									}
									else{
										System.out.println("Opcion no valida");
									}

								}
											

							}
							else if( linea.equals("n")){
								writer.write("\n");
								menu = false;

							}
							else {
								System.out.print("Opcion no valida");
							}

						}




						System.out.print("Nombre del Jefe: ");
						linea = reader.readLine();
						nombreJug = linea;
						writer.write(nombreJug + " ");
						System.out.print("Vida del Jefe: ");
						linea = reader.readLine();
						vidaJug = Integer.parseInt(linea);
						writer.write(vidaJug + " ");
						System.out.print("Ataque del Jefe: ");
						linea = reader.readLine();
						ataqJug = Integer.parseInt(linea);
						writer.write(ataqJug + " ");
						System.out.print("Defensa del Jefe: ");
						linea = reader.readLine();
						defJug = Integer.parseInt(linea);
						writer.write(defJug + " ");

						Jefe boss = new Jefe(vidaJug,defJug,ataqJug,nombreJug);

						menu = true;

						System.out.println("Elegir ataques especiales:");
						System.out.println("1. Cannon Spear + 300 ataque");
						System.out.println("2. Limit Break +10000 ataque");

						while (menu){
							System.out.print("Opcion: ");
							linea = reader.readLine();
							if (linea.equals("1")){
								ataque1 = "Cannon_Spear";
								writer.write(ataque1 + " ");
								writer.write("\n");
								boss.set_esp1(ataque1,300);
								menu = false;

							}
							else if (linea.equals("2")){
								ataque1 = "Limit_Break";
								writer.write(ataque1 + " ");
								writer.write("\n");
								boss.set_esp1(ataque1,10000);
								menu = false;

							}
							else {
								System.out.println("Opcion no valida");
							}
						}
						
							

						System.out.print("Vida del Aliado: ");
						linea = reader.readLine();
						vidaJug = Integer.parseInt(linea);
						writer.write(vidaJug + " ");
						System.out.println("Objeto Aliado: ");
						System.out.println("1. Veil of Discord +600 defensa");
						System.out.println("2. Chainmail +500 defensa");
						System.out.println("3. Guardian Greaves + 500 vida");
						System.out.println("4. Lotus Orb +1000 vida");

						menu = true;

						while(menu){
							System.out.print("Opcion: ");
							linea = reader.readLine();
							

							if (linea.equals("1")){
								obj = "Veil_of_Discord";
								writer.write(obj);
								writer.write("\n");
								atributo = "defensa";
								stat = 600;
								menu = false;


							}
							else if (linea.equals("2")){
								obj = "Chainmail";
								writer.write(obj);
								writer.write("\n");
								atributo = "defensa";
								stat = 500;
								menu = false;
								

								
							}
							else if (linea.equals("3")){
								obj = "Guardian_Greaves";
								writer.write(obj);
								writer.write("\n");
								atributo = "vida";
								stat = 500;
								menu = false;
								

								
							}
							else if (linea.equals("4")){
								obj = "Lotus_Orb";
								writer.write(obj);
								writer.write("\n");
								atributo = "vida";
								stat = 1000;
								menu = false;
								
							}

							else{

								System.out.println("Opcion no valida");
							}

						}
						

						Objeto objAlly = new Objeto(obj,atributo,stat);
						Aliado ally = new Aliado(vidaJug,objAlly);

						System.out.println("Objeto del Nivel ");
						System.out.println("1. Veil of Discord +600 defensa");
						System.out.println("2. Chainmail +500 defensa");
						System.out.println("3. Guardian Greaves + 500 vida");
						System.out.println("4. Lotus Orb +1000 vida");

						menu = true;

						while(menu){

							System.out.print("Opcion: ");
							linea = reader.readLine();
							


							if (linea.equals("1")){
								obj = "Veil_of_Discord";
								writer.write(obj);
								writer.write("\n");
								atributo = "defensa";
								stat = 600;
								menu = false;

							}
							else if (linea.equals("2")){
								obj = "Chainmail";
								writer.write(obj);
								writer.write("\n");
								atributo = "defensa";
								stat = 500;
								menu = false;
								
							}
							else if (linea.equals("3")){
								obj = "Guardian_Greaves";
								writer.write(obj);
								writer.write("\n");
								atributo = "vida";
								stat = 500;
								menu = false;
								
							}
							else if (linea.equals("4")){
								obj = "Lotus_Orb";
								writer.write(obj);
								writer.write("\n");
								atributo = "vida";
								stat = 1000;
								menu = false;
							}
							else{

								System.out.println("Opcion no valida");
							}
						}

							

						Objeto objNiv = new Objeto(obj,atributo,stat);

						System.out.print("Cantidad de enemigos: ");
						linea = reader.readLine();
						cantEn = Integer.parseInt(linea);
						writer.write(vidaJug + " ");
						System.out.print("Vida del enemigo: ");
						linea = reader.readLine();
						vidaJug = Integer.parseInt(linea);
						writer.write(vidaJug + " ");
						System.out.print("Ataque del enemigo: ");
						linea = reader.readLine();
						ataqJug = Integer.parseInt(linea);
						writer.write(ataqJug + " ");
						System.out.print("Defensa del enemigo: ");
						linea = reader.readLine();
						defJug = Integer.parseInt(linea);
						writer.write(defJug + " ");
						writer.write("\n");

						Enemigo enemy = new Enemigo(vidaJug,defJug,ataqJug);

						Nivel nivel = new Nivel(nombreNiv,player,boss,ally,objNiv,enemy,cantEn);

						listaNiveles.add(nivel);
						writer.close();

						System.out.println("Nivel Creado");

					}
					catch (IOException e) {
						e.printStackTrace();
					}
					catch (NumberFormatException e){
						System.out.println("Debe ser un numero");
					}
				}
				else if (linea.equals("2")){

					i = 0;
					size = listaNiveles.size();
					while(i < size){
						N = listaNiveles.get(i);
						name = N.get_name();
						System.out.println((i+1)+". "+name);
		
						i++;
					}

					menu = true;

					while(menu){

						System.out.print("Opcion: ");
						linea = reader.readLine();
						try{

							opcion = Integer.parseInt(linea);

						} catch(NumberFormatException e){

							System.out.println("Debe ser un numero");

						}

						if ((opcion-1) < 0 || (opcion-1) >  size ){
							System.out.println("Opcion no valida");
						}

						else{

							N = listaNiveles.get(opcion-1);
							menu = false;

							Simulator(N);

						}

					}

						
					

				}
				else if (linea.equals("3")){

					i = 0;
					size = listaNiveles.size();
					while(i < size){
						N = listaNiveles.get(i);
						name = N.get_name();
						System.out.println((i+1)+". "+name);
		
						i++;
					}
					

					menu = true;

					while(menu){

						System.out.print("Opcion: ");
						linea = reader.readLine();

						
						try{

							opcion = Integer.parseInt(linea);


						} catch(NumberFormatException e){

							System.out.println("Debe ser un numero");

						}

						if ((opcion-1) < 0 || (opcion-1) >  size ){
							System.out.println("Opcion no valida");
						}

						else{
							N = listaNiveles.get(opcion-1);
							menu = false;

							System.out.println("Nombre del nivel: " + N.get_name());

							(N.get_player()).display();

							(N.get_jefe()).display();

							(N.get_ally()).display();

							(N.get_obj()).display();

							System.out.println("Cantidad de enemigos: " + N.get_cant());

							System.out.println("Enemigo");

							(N.get_enemy()).display();

							System.out.println("Fin de informacion");

							



						}

					}

				}
				else if(linea.equals("4")){
					juego = false;
					System.out.println("Cerrando juego");
				}
				else{
					System.out.println("Opcion no valida");
				}



			} catch(IOException ioe){
				ioe.printStackTrace();
			}
		  		
	  	}


   
	}
}
