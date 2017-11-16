public class Juego {
	    public static void main(String[] args) {
	      Jugador A = new Jugador(100,20,35,"Ryu",23);
	      Jefe B = new Jefe(2000,40,30,"Akuma");
	      B.set_esp1("Satsui no Hadou", 2000);
	      A.set_esp1("Hadouken", 200 , 15);
	      A.set_esp2("Shoryouken", 250 , 20);
	      System.out.println("----------------------------------------");
	      A.display();
	      System.out.println("----------------------------------------");
	      B.display();
	      System.out.println("----------------------------------------");
	      return;
    }
}