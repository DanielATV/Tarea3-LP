import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Juego {

  public static void main(String[] args) {
  	String nombreNiv;
  	String nombreJug;
  	int vidaJug;
  	int ataqJug;
  	int defJug;
  	int op;
  	int op2;
  	String ataque1;
  	String ataque2;
  	String desi;
  	String obj = "";
  	int cantEn;
  	String atributo = "";
  	int stat = -1;
  	boolean juego = true;
  	Scanner scan = new Scanner(System.in);
  	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  	String linea;
  	boolean menu;


  	while(juego){

  		try{

			System.out.println("1. Crear Nivel");
			System.out.println("2. Simular avance en Nivel");
			System.out.println("3. Consultar informacion de Nivel");
			System.out.println("4. Salir");
			System.out.print("Opcion: ");


			linea = reader.readLine();
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
					while(menu){

					}
					System.out.println("Elegir ataques especiales:");
					System.out.println("1. Guillotine Fist +200 ataque, 30pp");
					System.out.println("2. Rising Dragon +500 ataque, 25pp");
					System.out.println("3. Knuckle Arrow +100 ataque, 50pp");
					System.out.println("4. Gate of Hell +5000 ataque, 5pp");
					System.out.print("Poder 1: ");
					op = scan.nextInt();
					System.out.print("Poder 2: ");
					op2 = scan.nextInt();
					if (op == 1){
						ataque1 = "Guillotine_Fist";
						writer.write(ataque1 + " ");
						player.set_esp1(ataque1,200,30);

					}
					else if (op == 2){
						ataque1 = "Rising_Dragon";
						writer.write(ataque1 + " ");
						player.set_esp1(ataque1,500,25);

					}
					else if (op == 3){
						ataque1 = "Knuckle_ArrowFist";
						writer.write(ataque1 + " ");
						player.set_esp1(ataque1,100,50);

					}
					else if (op == 4){
						ataque1 = "Gate_of_Hell";
						writer.write(ataque1 + " ");
						player.set_esp1(ataque1,5000,5);

					}
					if (op2 == 1){
						ataque2 = "Guillotine_Fist";
						writer.write(ataque2 + " ");
						player.set_esp2(ataque2,200,30);

					}
					else if (op2 == 2){
						ataque2 = "Rising_Dragon";
						writer.write(ataque2 + " ");
						player.set_esp2(ataque2,500,25);


					}
					else if (op2 == 3){
						ataque2 = "Knuckle_Arrow";
						writer.write(ataque2 + " ");
						player.set_esp2(ataque2,100,50);


					}
					else if (op2 == 4){
						ataque2 = "Gate_of_Hell";
						writer.write(ataque2 + " ");
						player.set_esp2(ataque2,5000,5);

					}

					System.out.println("Desea equipar un objeto? y/n");
					desi = scan.next();
					if( desi.equals("y")){
						System.out.println("1. Veil of Discord +600 defensa");
						System.out.println("2. Chainmail +500 defensa");
						System.out.println("3. Guardian Greaves + 500 vida");
						System.out.println("4. Lotus Orb +1000 vida");
						op = scan.nextInt();
						

						if (op == 1){
							obj = "Veil_of_Discord";
							writer.write(obj);
							writer.write("\n");
							Objeto objJug = new Objeto(obj,"defensa",600);
							player.set_obj(objJug,1);

						}
						else if (op == 2){
							obj = "Chainmail";
							writer.write(obj);
							writer.write("\n");
							Objeto objJug = new Objeto(obj,"defensa",500);
							player.set_obj(objJug,1);

							
						}
						else if (op == 3){
							obj = "Guardian_Greaves";
							writer.write(obj);
							writer.write("\n");
							Objeto objJug = new Objeto(obj,"vida",500);
							player.set_obj(objJug,1);

							
						}
						else if (op == 4){
							obj = "Lotus_Orb";
							writer.write(obj);
							writer.write("\n");
							Objeto objJug = new Objeto(obj,"vida",1000);
							player.set_obj(objJug,1);
							
						}


					}
					else if( desi.equals("n")){
						writer.write("\n");

					}

					System.out.println("Nombre del Jefe: ");
					nombreJug = scan.next();
					writer.write(nombreJug + " ");
					System.out.println("Vida del Jefe: ");
					vidaJug = scan.nextInt();
					writer.write(vidaJug + " ");
					System.out.println("Ataque del Jefe: ");
					ataqJug = scan.nextInt();
					writer.write(ataqJug + " ");
					System.out.println("Defensa del Jefe: ");
					defJug = scan.nextInt();
					writer.write(defJug + " ");

					Jefe boss = new Jefe(vidaJug,defJug,ataqJug,nombreJug);

					System.out.println("Elegir ataques especiales:");
					System.out.println("1. Cannon Spear + 300 ataque");
					System.out.println("2. Limit Break +10000 ataque");
					op = scan.nextInt();
					if (op == 1){
						ataque1 = "Cannon_Spear";
						writer.write(ataque1 + " ");
						writer.write("\n");
						boss.set_esp1(ataque1,300);

					}
					else if (op == 2){
						ataque1 = "Limit_Break ";
						writer.write(ataque1 + " ");
						writer.write("\n");
						boss.set_esp1(ataque1,10000);

					}

					System.out.println("Vida del Aliado: ");
					vidaJug = scan.nextInt();
					writer.write(vidaJug + " ");
					System.out.println("Objeto Aliado: ");
					System.out.println("1. Veil of Discord +600 defensa");
					System.out.println("2. Chainmail +500 defensa");
					System.out.println("3. Guardian Greaves + 500 vida");
					System.out.println("4. Lotus Orb +1000 vida");
					op = scan.nextInt();

					if (op == 1){
						obj = "Veil_of_Discord";
						writer.write(obj);
						writer.write("\n");
						atributo = "defensa";
						stat = 600;

						
						

					}
					else if (op == 2){
						obj = "Chainmail";
						writer.write(obj);
						writer.write("\n");
						atributo = "defensa";
						stat = 500;
						

						
					}
					else if (op == 3){
						obj = "Guardian_Greaves";
						writer.write(obj);
						writer.write("\n");
						atributo = "vida";
						stat = 500;
						

						
					}
					else if (op == 4){
						obj = "Lotus_Orb";
						writer.write(obj);
						writer.write("\n");
						atributo = "vida";
						stat = 1000;
						
					}

					Objeto objAlly = new Objeto(obj,atributo,stat);
					Aliado ally = new Aliado(vidaJug,objAlly);

					System.out.println("Objeto del Nivel ");
					System.out.println("1. Veil of Discord +600 defensa");
					System.out.println("2. Chainmail +500 defensa");
					System.out.println("3. Guardian Greaves + 500 vida");
					System.out.println("4. Lotus Orb +1000 vida");
					op = scan.nextInt();

					if (op == 1){
						obj = "Veil_of_Discord";
						writer.write(obj);
						writer.write("\n");
						atributo = "defensa";
						stat = 600;

					}
					else if (op == 2){
						obj = "Chainmail";
						writer.write(obj);
						writer.write("\n");
						atributo = "defensa";
						stat = 500;
						
					}
					else if (op == 3){
						obj = "Guardian_Greaves";
						writer.write(obj);
						writer.write("\n");
						atributo = "vida";
						stat = 500;
						
					}
					else if (op == 4){
						obj = "Lotus_Orb";
						writer.write(obj);
						writer.write("\n");
						atributo = "vida";
						stat = 1000;
					}

					Objeto objNiv = new Objeto(obj,atributo,stat);

					System.out.println("Cantidad de enemigos: ");
					cantEn = scan.nextInt();
					writer.write(vidaJug + " ");
					System.out.println("Vida del enemigo: ");
					vidaJug = scan.nextInt();
					writer.write(vidaJug + " ");
					System.out.println("Ataque del enemigo: ");
					ataqJug = scan.nextInt();
					writer.write(ataqJug + " ");
					System.out.println("Defensa del enemigo: ");
					defJug = scan.nextInt();
					writer.write(defJug + " ");
					writer.write("\n");

					Enemigo enemy = new Enemigo(vidaJug,defJug,ataqJug);

					Nivel nivel = new Nivel(nombreNiv,player,boss,ally,objNiv,enemy,cantEn);

					writer.close();

				} catch (IOException e) {
					e.printStackTrace();
					}
			}
			else if (linea.equals("2")){
				System.out.println("Test");
			}
			else if(linea.equals("4")){
				juego = false;
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
