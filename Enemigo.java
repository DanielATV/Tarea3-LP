public class Enemigo extends Personaje implements Ataque{
	protected int ataque;
	protected int defensa;

	/******** Contructor: Enemigo *******************
		Descripcion: Crea un enemigo nuevo
		Parametros:
			vida entero
			def entero
			ata entero
	************************************************/

	Enemigo(int vid, int def, int ata){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
	}

	/******** Contructor: Enemigo ********************
		Descripcion: Crea un enemigo nuevo
	************************************************/

	Enemigo(){
		super(0);
		this.ataque= 0;
		this.defensa = 0;
	}

	/******** Metodo: set_ata ***************************************
		Descripcion: Establece el ataque del enemigo
		Parametros:
			ata entero
	******************************************************************/

	void set_ata(int ata){
		ataque = ata;
	}

	/******** Metodo: set_def ***************************************
		Descripcion: Establece la defensa del enemigo
		Parametros:
			def entero
	******************************************************************/

	void set_def(int def){
		defensa = def;
	}

	/******** Metodo: get_vida ***************************************
		Descripcion: Obtiene la vida del enemigo
		Retorno: Retorna la vida del enemigo
	******************************************************************/

	public int get_vida(){
		return vida;
	}
	
	/******** Metodo: display ****************************************
		Descripcion: Imprime en pantalla el estado del enemigo
	******************************************************************/

	public void display(){
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
	}

	/******** Metodo: reduce_hp **************************************
		Descripcion: Reduce la vida del enemigo
		Parametros:
			damage entero
		Retorno: 0 en caso de muerte del enemigo 1 en caso contrario
	******************************************************************/

	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	/******** Metodo: get_def ***************************************
		Descripcion: Obtiene la defensa del enemigo
		Retorno: Retorna la defensa del enemigo
	******************************************************************/

	public int get_def(){
		return defensa;
	}

	/******** Metodo: get_ata ***************************************
		Descripcion: Obtiene el ata del enemigo
		Retorno: Retorna el ata del enemigo
	******************************************************************/

	public int get_ata(){
		return ataque;
	}

	/******** Metodo: atacar **********************
		Descripcion: Calcula el daño a producir 
					 mediante un ataque normal
		Parametros:
			def entero
			int vid
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	***********************************************/

	public int atacar(int def, int vid){
		if ((ataque - def) <= 0) {
			return vid;
		} else if ((ataque - def) > 0) {
			if ((vid - (ataque - def)) <= 0) {
				return 0;
			}
			return vid - (ataque - def);
		}
		return vid - (ataque - def);
	}

	/******** Metodo: atacar_jugador ************
		Descripcion: Ataca al jugador
		Parametros:
			J Jugador
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	********************************************/	

	public int atacar_jugador(Jugador J){
		int dano = atacar(J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	/******** Metodo: atacar_aliado *************
		Descripcion: Ataca al aliado
		Parametros:
			A Aliado
			J Jugador
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	********************************************/

	public int atacar_aliado(Aliado A,Jugador J){
		int dano = atacar(0,A.get_vida());
		A.set_vida(dano);
		if (dano == 0) {
			A.delete_item(J);
		}
		return dano;
	}
}
