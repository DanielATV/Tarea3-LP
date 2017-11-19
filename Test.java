import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Test {
	String random;
	int cant_enemigos;
	List<String> list_path;
	List<String> list_ally;
	Test(int enemigos){
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
	int rand_path(){
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

	int atack_choice(){
		int a = new Random().nextInt(2) + 1;
		return a;
	}

	int select_esp(){
		int b = new Random().nextInt(2) + 1;
		return b;
	}

	String rand_atack(int ally_hp){
		if (ally_hp == 0) {
			return list_ally.get(0);
		} else {
			random = list_ally.get(new Random().nextInt(list_ally.size()));
			return random;
		}
	}


}
