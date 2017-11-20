
public class Jefe extends Personaje implements Ataque,AtaqueEspecial{
	protected int ataque;
	protected int defensa;
	protected String nombre;
	protected String esp_1;
	protected int power_1;

	/******** Contructor: Jefe *******************
		Descripcion: Crea un jefe nuevo
		Parametros:
			vida entero
			def entero
			ata entero
			name String
	************************************************/	

	Jefe(int vid, int def, int ata, String name){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
	}

	/******** Contructor: Jefe *******************
		Descripcion: Crea un jefe nuevo
	************************************************/
	
	Jefe(){
		super(0);
		this.ataque=0;
		this.defensa=0;
		this.nombre="";
	}

	/******** Metodo: reduce_hp **************************************
		Descripcion: Reduce la vida del jefe
		Parametros:
			damage entero
		Retorno: 0 en caso de muerte del aliado 1 en caso contrario
	******************************************************************/
	
	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	/******** Metodo: set_nombre **************************************
		Descripcion: Establece el nombre del jefe
		Parametros:
			nom String
	******************************************************************/
	
	public void set_nombre(String nom){
		nombre = nom;
	}

	/******** Metodo: set_ata ***************************************
		Descripcion: Establece el ataque del jefe
		Parametros:
			ata entero
	******************************************************************/
	
	void set_ata(int ata){
		ataque = ata;
	}

	/******** Metodo: set_def ***************************************
		Descripcion: Establece la defensa del jefe
		Parametros:
			def entero
	******************************************************************/	
	
	void set_def(int def){
		defensa = def;
	}

	/******** Metodo: use_esp ***************************************
		Descripcion: Usa un ataque especial
		Parametros:
			name String
			def entero
		Retorno: Retorna el daño producido por el ataque especial
	******************************************************************/	
	
	public int use_esp(String name, int def){
		if (esp_1 == name) {
			if (power_1 <= def) {
				return 0;
			}
		}
		return ataque  +power_1 - def;
	}

	/******** Metodo: get_def ***************************************
		Descripcion: Obtiene la defensa del jefe
		Retorno: Retorna la defensa del jefe
	*****************************************************************/	
	
	public int get_def(){
		return defensa;
	}

	/******** Metodo: get_ata ***************************************
		Descripcion: Obtiene el ata del jefe
		Retorno: Retorna el ata del jefe
	******************************************************************/	
	
	public int get_ata(){
		return ataque;
	}

	/******** Metodo: get_esp ***************************************
		Descripcion: Obtiene el nombre del ataque especial del jefe
		Retorno: Retorna el nombre del ataque especial del jefe
	******************************************************************/	
	
	public String get_esp(){
		return esp_1;
	}

	/******** Metodo: get_power_esp ***********************************
		Descripcion: Obtiene el poder del ataque especial del jefe
		Retorno: Retorna el poder del ataque especial del jefe
	******************************************************************/	
	
	public int get_power_esp(){
		return power_1;
	}

	/******** Metodo: get_nombre ******************
		Descripcion: Obtiene el nombre del jefe
		Retorno: Retorna el nombre del jefe
	***********************************************/	
	
	public String get_nombre(){
		return nombre;
	}

	/******** Metodo: set_esp1 ***************************************
		Descripcion: Define el ataque especial del jefe
		Parametros:
			name String
			power entero
	******************************************************************/	
	
	public void set_esp1(String name, int power){
		this.esp_1 = name;
		this.power_1 = power;
	}

	/******** Metodo: display ****************************************
		Descripcion: Imprime en pantalla el estado del enemigo
	******************************************************************/	
	
	public void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1);
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

	/******** Metodo: ataque_especial *********************
		Descripcion: Calcula el dano a realizar 
					 con un ataque especial
		Parametros:
			opc entero
			vid entero
			def entero
		Retorno: Retorna la cantidad de vida a 
			 perder derivado del ataque especial
	*******************************************************/	
	
	public int ataque_especial(int opc,int vid, int def){
		if (opc == 1) {
			if ((ataque + power_1 - def)<=0) {
				return vid;
			} else if ((ataque + power_1 - def) > 0) {
				if ((vid - (ataque + power_1 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_1 - def);
				}
			}	
		}
		return vid;
	}

	/******** Metodo: ataque_esp_jugador ******************************
		Descripcion: Ataca al jugador con un ataque especial
		Parametros:
			J Jugador
		Retorno: Retorna la cantidad de vida a 
			 perder derivado del ataque especial hacia el jugador
	*******************************************************************/	
	
	public int ata_esp_jugador(Jugador J){
		int dano = ataque_especial(1,J.get_vida(),J.get_def());
		J.set_vida(dano);
		return dano;
	}

	/******** Metodo: ataque_esp_aliado ******************************
		Descripcion: Ataca al aliado con un ataque especial
		Parametros:
			J Jugador
		Retorno: Retorna la cantidad de vida a 
			 perder derivado del ataque especial hacia el aliado
	*******************************************************************/	
	
	public int ata_esp_aliado(Aliado A, Jugador J){
		int dano = ataque_especial(1,A.get_vida(),0);
		A.set_vida(dano);
		if (dano == 0) {
			A.delete_item(J);
		}
		return dano;
	}
}
