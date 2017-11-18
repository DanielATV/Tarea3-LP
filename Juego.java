
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
  	Scanner scan = new Scanner(System.in);
  	//String s = scan.next();
  	//int i = scan.nextInt();

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







		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
		}


   
  }
}
