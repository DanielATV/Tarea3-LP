public class Juego {
	    public static void main(String[] args) {
	      Jugador A = new Jugador(100,20,35,"Ryu");
	      Jefe B = new Jefe(2000,40,30,"Akuma");
	      Objeto C = new Objeto("Kaiser Knuckles","ataque",45);
	      Objeto D = new Objeto("God Hand","ataque",250);
	      Aliado J = new Aliado(50,D);
	      B.set_esp1("Satsui no Hadou", 2000);
	      A.set_esp1("Hadouken", 200 , 15);
	      A.set_esp2("Shoryouken", 250 , 20);
	      A.set_obj(C,1);
	      J.assign_item(A);
	      System.out.println("----------------------------------------");
	      A.display();
	      A.reduce_hp(25);
	      System.out.println("----------------------------------------");
	      A.display();
	      System.out.println("----------------------------------------");
	      B.reduce_hp(A.use_esp("Hadouken",B.get_def()));
	      B.display();
	      System.out.println("----------------------------------------");
	      A.display();
	      System.out.println("----------------------------------------");
	      return;
    }
}