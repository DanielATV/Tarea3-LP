import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class test {
	String random;
	int cant_enemigos;
	List<String> list_path;
	List<String> list_ally;

	/******** Contructor: test *******************
		Descripcion: Crea una clase test nueva
		Parametros:
			enemigos entero
	************************************************/	

	test(int enemigos){
		cant_enemigos = enemigos;
		list_path = new ArrayList<String>();
		list_ally = new ArrayList<String>();
		list_path.add("Objeto");
		list_path.add("Jefe");
		while(enemigos > 0){
			list_path.add("Enemigo");
			enemigos--;
		}
		list_ally.add("Jugador");
		list_ally.add("Aliado");
	}

	/******** Metodo: rand_path *************************
		Descripcion: Obtiene un camino aleatorio
		Retorno: Retorna eleccion de enemigo 
				 objeto o jefe segun su disponibilidad
	*****************************************************/

	public int rand_path(){
		random =list_path.get(new Random().nextInt(list_path.size()));
		if (random.equals("Objeto")) {
			list_path.remove(random);	
			System.out.println("Objeto Obtenido!!");
			return 1;
		} else if (random.equals("Enemigo")) {
			list_path.remove(random);
			cant_enemigos --;
			System.out.println("Enemigo Encontrado!! - Restantes: "+cant_enemigos);
			return 2;
		} else if (random.equals("Jefe")) {
			list_path.remove(random);
			System.out.println("Batalla Final!!");
			return 3;
		}
		return 0;
	}

	/******** Metodo: atack_choice *************************
		Descripcion: Obtiene un 1 o 2 de forma aleatoria
		Retorno: Retorna 1 o 2
	*****************************************************/

	public int atack_choice(){
		int a = new Random().nextInt(2) + 1;
		return a;
	}

	/******** Metodo: select_esp *************************
		Descripcion: Obtiene un 1 o 2 de forma aleatoria
		Retorno: Retorna 1 o 2
	*****************************************************/

	public int select_esp(){
		int b = new Random().nextInt(2) + 1;
		return b;
	}

	/******** Metodo: rand_atack *************************
		Descripcion: Obtiene "Aliado" o "Jugador" segun 
					 disponibilidad de forma aleatoria
		Retorno: Retorna "Aliado" o "Jugador"
	*****************************************************/

	public String rand_atack(int ally_hp){
		if (ally_hp == 0) {
			return list_ally.get(0);
		} else {
			random = list_ally.get(new Random().nextInt(list_ally.size()));
			return random;
		}
	}

	public static void main(String[] args) {
		int a;
		int c=0;
		test B = new test(20);
		while(c < 25){
			a = B.rand_path();
			if (a == 3) {
				break;
			}
			c++;
		}
		c = 0;
		while(c < 5){
			System.out.println("Opcion de ataque: "+B.rand_atack(0));
			c++;
		}
		c = 0;
		while(c < 5){
			a = B.atack_choice();
			if(a==2){
				System.out.println("Ataque Especial "+B.select_esp());
			} else if (a == 1) {
				System.out.println("Ataque Normal");
			} else {
				System.out.println("Wea mas rara");
			}
			c++;
		}

	}
}