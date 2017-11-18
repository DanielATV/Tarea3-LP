import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class test {
    public static void main(String[] args) {
    	String random;
    	int a=0;
    	int cant_enemigos = 5;
    	List<String> list = new ArrayList<String>();
		list.add("Objeto");
		while(cant_enemigos > 0){
			list.add("Enemigo");	
			cant_enemigos--;
		}
		list.add("Jefe");
		while(a < 30){
			random = list.get(new Random().nextInt(list.size()));
			if (random.equals("Objeto")) {
				list.remove(random);	
				System.out.println("Objeto Obtenido!!");
			}else if (random.equals("Enemigo")) {
				list.remove(random);
				System.out.println("Enemigo Encontrado!!");
			} else if (random.equals("Jefe")) {
				list.remove(random);
				System.out.println("Batalla Final!!");
				break;
			}
			a++;
		}
		
    }
}