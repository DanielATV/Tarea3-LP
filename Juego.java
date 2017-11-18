import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
  	Sting desi;
  	String obj;
  	int cantEn;
  	Scanner scan = new Scanner(System.in);
  	//String s = scan.next();
  	//int i = scan.nextInt();

  	System.out.println("Elegir ataques especiales:");
	System.out.println("1. Crear Nivel");
	System.out.println("2. Simular avance en Nivel");
	System.out.println("3. Consultar informacion de Nivel");
	System.out.println("4. Salir");
	op = scan.nextInt();
	if (op == 1){

		try {
			FileWriter writer = new FileWriter("niveles.txt", true);
			System.out.println("Nombre del Nivel: ");
			nombreNiv = scan.next();
			writer.write(nombreNiv);
			writer.write("\n");
			System.out.println("Nombre del Jugador: ");
			nombreJug = scan.next();
			writer.write(nombreJug + " ");
			System.out.println("Vida del Jugador: ");
			vidaJug = scan.nextInt();
			writer.write(vidaJug + " ");
			System.out.println("Ataque del Jugador: ");
			ataqJug = scan.nextInt();
			writer.write(ataqJug + " ");
			System.out.println("Defensa del Jugador: ");
			defJug = scan.nextInt();
			writer.write(defJug + " ");
			System.out.println("Elegir ataques especiales:");
			System.out.println("1. Guillotine Fist +200 ataque, 30pp");
			System.out.println("2. Rising Dragon +500 ataque, 25pp");
			System.out.println("3. Knuckle Arrow +100 ataque, 50pp");
			System.out.println("4. Gate of Hell +5000 ataque, 5pp");
			op = scan.nextInt();
			op2 = scan.nextInt();
			if (op == 1){
				ataque1 = "Guillotine Fist";
				writer.write(ataque1 + " ");

			}
			else if (op == 2){
				ataque1 = "Rising Dragon";
				writer.write(ataque1 + " ");

			}
			else if (op == 3){
				ataque1 = "Knuckle ArrowFist";
				writer.write(ataque1 + " ");

			}
			else if (op == 4){
				ataque1 = "Gate of Hell";
				writer.write(ataque1 + " ");

			}
			if (op2 == 1){
				ataque2 = "Guillotine Fist";
				writer.write(ataque2 + " ");

			}
			else if (op2 == 2){
				ataque2 = "Rising Dragon";
				writer.write(ataque2 + " ");


			}
			else if (op2 == 3){
				ataque2 = "Knuckle Arrow";
				writer.write(ataque2 + " ");


			}
			else if (op2 == 4){
				ataque2 = "Gate of Hell";
				writer.write(ataque2 + " ");

			}

			System.out.println("Desea equipar un objeto? y/n");
			desi = scan.next();
			if( desi == "y"){
				System.out.println("1. Veil of Discord +600 defensa");
				System.out.println("2. Chainmail +500 defensa");
				System.out.println("3. Guardian Greaves + 500 vida");
				System.out.println("4. Lotus Orb +1000 vida");
				op = scan.nextInt();

				if (op == 1){
					obj = "Veil of Discord"
					writer.write(obj);
					writer.write("\n");

				}
				else if (op == 2){
					obj = "Chainmail"
					writer.write(obj);
					writer.write("\n");

					
				}
				else if (op == 3){
					obj = "Guardian Greaves"
					writer.write(obj);
					writer.write("\n");

					
				}
				else if (op == 4){
					obj = "Lotus Orb"
					writer.write(obj);
					writer.write("\n");
					
				}


			}
			else if( desi == "n"){
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
			System.out.println("Elegir ataques especiales:");
			System.out.println("1. Cannon Spear + 300 ataque");
			System.out.println("2. Limit Break +10000 ataque");
			op = scan.nextInt();
			if (op == 1){
				ataque1 = "Cannon Spear";
				writer.write(ataque1 + " ");
				writer.write("\n");

			}
			else if (op == 2){
				ataque1 = "Limit Break ";
				writer.write(ataque1 + " ");
				writer.write("\n");

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
				obj = "Veil of Discord"
				writer.write(obj);
				writer.write("\n");

			}
			else if (op == 2){
				obj = "Chainmail"
				writer.write(obj);
				writer.write("\n");

				
			}
			else if (op == 3){
				obj = "Guardian Greaves"
				writer.write(obj);
				writer.write("\n");

				
			}
			else if (op == 4){
				obj = "Lotus Orb"
				writer.write(obj);
				writer.write("\n");
				
			}

			System.out.println("Objeto del Nivel ");
			System.out.println("1. Veil of Discord +600 defensa");
			System.out.println("2. Chainmail +500 defensa");
			System.out.println("3. Guardian Greaves + 500 vida");
			System.out.println("4. Lotus Orb +1000 vida");
			op = scan.nextInt();

			if (op == 1){
				obj = "Veil of Discord"
				writer.write(obj);
				writer.write("\n");

			}
			else if (op == 2){
				obj = "Chainmail"
				writer.write(obj);
				writer.write("\n");

				
			}
			else if (op == 3){
				obj = "Guardian Greaves"
				writer.write(obj);
				writer.write("\n");

				
			}
			else if (op == 4){
				obj = "Lotus Orb"
				writer.write(obj);
				writer.write("\n");
				
			}

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


			


			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			}
	}


	  	


   
  }
}
