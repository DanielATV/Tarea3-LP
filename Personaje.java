package juego;
  
public abstract class Personaje{
	int vida;
	Personaje(int vid){
		vida = vid;
	}
	public abstract void crearPersonaje();
}
