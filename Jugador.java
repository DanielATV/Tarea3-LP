public class Jugador extends Personaje implements Ataque,AtaqueEspecial{
	protected int ataque;
	protected int defensa;
	protected String nombre;
	protected String esp_1;
	protected int power_1;
	protected int cost_1;
	protected String esp_2;
	protected int power_2;
	protected int cost_2;
	protected Objeto obj1;
	protected int obj1_bool = 0;
	protected Objeto obj2;
	protected int obj2_bool = 0;

	/******** Contructor: Jugador *******************
		Descripcion: Crea un jugador nuevo
		Parametros:
			vida entero
			def entero
			ata entero
			name String
	************************************************/	

	Jugador(int vid, int def, int ata, String name){
		super(vid);
		this.ataque = ata;
		this.defensa = def;
        this.nombre = name;
	}
	
	/******** Contructor: Jugador *******************
		Descripcion: Crea un jugador nuevo
	************************************************/

	Jugador(){
		super(0);
		this.ataque = 0;
		this.defensa = 0;
		this.nombre = "";
	}

	/******** Metodo: get_def ***************************************
		Descripcion: Obtiene la defensa del jugador
		Retorno: Retorna la defensa del jugador
	*****************************************************************/

	public int get_def(){
		return defensa;
	}

	/******** Metodo: get_pp1 ***************************************
		Descripcion: Obtiene los puntos de poder del jugador
		Retorno: Retorna los punots de poder del jugador
	******************************************************************/

	public int get_pp1(){
		return cost_1;
	}

	/******** Metodo: get_pp2 ***************************************
		Descripcion: Obtiene los puntos de poder del jugador
		Retorno: Retorna los punots de poder del jugador
	******************************************************************/

	public int get_pp2(){
		return cost_2;
	}

	/******** Metodo: get_ata ***************************************
		Descripcion: Obtiene el ataque del jugador
		Retorno: Retorna el ata del jugador
	******************************************************************/

	public int get_ata(){
		return ataque;
	}

	/******** Metodo: get_esp1 *****************************
		Descripcion: Obtiene el nombre del primer 
					 ataque especial del jugador
		Retorno: Retorna el nombre del primer 
				 ataque especial del jugador
	*******************************************************/

	public String get_esp1(){
		return esp_1;
	}

	/******** Metodo: get_esp2 *****************************
		Descripcion: Obtiene el nombre del segundo 
					 ataque especial del jugador
		Retorno: Retorna el nombre del segundo 
				 ataque especial del jugador
	*******************************************************/

	public String get_esp2(){
		return esp_2;
	}

	/******** Metodo: get_nombre ******************
		Descripcion: Obtiene el nombre del jugador
		Retorno: Retorna el nombre del jugador
	***********************************************/

	public String get_name(){
		return nombre;
	}

	/******** Metodo: get_power_esp1 **********************
		Descripcion: Obtiene el poder del primer ataque 
					 especial del jugador
		Retorno: Retorna el poder del primer ataque 
				 especial del jugador
	*******************************************************/

	public int get_power_esp1(){
		return power_1;
	}

	/******** Metodo: get_power_esp2 **********************
		Descripcion: Obtiene el poder del segundo ataque 
					 especial del jugador
		Retorno: Retorna el poder del segundo ataque 
				 especial del jugador
	*******************************************************/

	public int get_power_esp2(){
		return power_2;
	}

	/******** Metodo: set_esp1 ***************************************
		Descripcion: Define el primer ataque especial del jugador
		Parametros:
			name String
			power entero
			pp entero
	******************************************************************/

	public void set_esp1(String name, int power, int pp){
		this.esp_1 = name;
		this.power_1 = power;
		this.cost_1 = pp;
	}

	/******** Metodo: set_esp2 ***************************************
		Descripcion: Define el segundo ataque especial del jugador
		Parametros:
			name String
			power entero
			pp entero
	******************************************************************/

	public void set_esp2(String name, int power, int pp){
		this.esp_2 = name;
		this.power_2 = power;
		this.cost_2 = pp;
	}

	/******** Metodo: use_esp ***************************************
		Descripcion: Usa un ataque especial
		Parametros:
			name String
			def entero
		Retorno: Retorna el daño producido por el ataque especial
	******************************************************************/

	public int use_esp(String name, int def){
		if (esp_1.equals(name)) {
			if (cost_1 == 0) {
				return -1;
			}
			cost_1 = cost_1 - 1;
			if (power_1 <= def) {
				return 0;
			}
			return ataque + power_1 - def;
		} else if (esp_2.equals(name)) {
			if (cost_2 == 0) {
				return -1;
			}
			cost_2 = cost_2 -1;
			if (power_2 <= def) {
				return 0;
			}
			return ataque + power_2 - def;
		}
		return 0;
	}

	/******** Metodo: set_ata ***************************************
		Descripcion: Establece el ataque del jugador
		Parametros:
			ata entero
	******************************************************************/

	public void set_ata(int ata){
		ataque = ata;
	}
	
	/******** Metodo: set_def ***************************************
		Descripcion: Establece la defensa del jugador
		Parametros:
			def entero
	******************************************************************/

	public void set_def(int def){
		defensa = def;
	}

	/******** Metodo: set_name ***************************************
		Descripcion: Establece el nombre del jugador
		Parametros:
			name String
	******************************************************************/

	public void set_name(String name){
		nombre = name;
	}

	/******** Metodo: reduce_hp **************************************
		Descripcion: Reduce la vida del jugador
		Parametros:
			damage entero
		Retorno: 0 en caso de muerte del jugador 1 en caso contrario
	******************************************************************/

	public int reduce_hp(int damage){
		damage = damage - defensa;
		vida = vida - damage;
		if (vida <=0) {
			return 0;
		}
		return 1;
	}

	/******** Metodo: set_obj **************************************
		Descripcion: Asigna el objeto al jugador
		Parametros:
			A Objeto
			ini entero
	******************************************************************/

	public void set_obj(Objeto A, int ini){
		if (ini == 1){
			obj1_bool = 1;
			obj1 = A;
			if (A.getAtributo() == "vida") {
				vida = vida + A.getValor();
			} else if (A.getAtributo() == "defensa"){
				defensa = defensa + A.getValor();
			} else {
				ataque = ataque + A.getValor();
			}
		} else {
			obj2_bool = 1;
			obj2 = A;
			if (A.getAtributo() == "vida") {
				vida = vida + A.getValor();
			} else if (A.getAtributo() == "defensa"){
				defensa = defensa + A.getValor();
			} else {
				ataque = ataque + A.getValor();
			}
		}
	}

	/******** Metodo: display ****************************************
		Descripcion: Imprime en pantalla el estado del enemigo
	******************************************************************/

	public void display(){
		System.out.println(nombre);
		System.out.println("Vida: "+vida);
		System.out.println("Ataque: "+ataque);
		System.out.println("Defensa: "+defensa);
		System.out.println("Ataque especial: "+esp_1+" "+power_1+" "+cost_1+"pp");
		System.out.println("Ataque especial: "+esp_2+" "+power_2+" "+cost_2+"pp");
		if (obj1_bool == 1) {
			obj1.display();
		}
		if (obj2_bool == 1) {
			obj2.display();
		}
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
		return (vid - (ataque - def));
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
			cost_1--;
			if ((ataque + power_1 - def) <= 0) {
				return 0;
			} else if ((ataque + power_1 - def) > 0) {
				if ((vid - (ataque + power_1 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_1 - def);
				}
			}	
		} else if (opc == 2) {
			cost_2--;
			if ((ataque + power_2 - def)<=0) {
				return 0;
			} else if ((ataque + power_2 - def) > 0) {
				if ((vid - (ataque + power_2 - def)) <= 0) {
					return 0;
				} else {
					return vid - (ataque + power_2 - def);
				}
			}
		}
		return vid;
	}

	/******** Metodo: atacar_jefe ************
		Descripcion: Ataca al jefe
		Parametros:
			J Jefe
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	********************************************/	

	public int atacar_jefe(Jefe J){
		int dano;
		dano  = atacar(J.get_def(),J.get_vida());
		J.set_vida(dano);
		return dano;
	}

	/******** Metodo: atacar_enemigo ************
		Descripcion: Ataca al enemigo
		Parametros:
			E Enemigo
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	********************************************/	

	public int atacar_enemigo(Enemigo E){
		int dano = atacar(E.get_def(),E.get_vida());
		E.set_vida(dano);
		return dano;
	}

	/******** Metodo: ataque_esp_enemigo ******************************
		Descripcion: Ataca al enemigo con un ataque especial
		Parametros:
			opc entero
			E Enemigo
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque especial hacia el enemigo
	*******************************************************************/

	public int ata_esp_enemigo(int opc,Enemigo E){
		int dano;
		if (opc == 1 && cost_1 > 0) {
			dano = ataque_especial(opc,E.get_vida(),E.get_def());
			E.set_vida(dano);	
		} else if (opc == 2 && cost_2 > 0) {
			dano = ataque_especial(opc,E.get_vida(),E.get_def());
			E.set_vida(dano);	
		} else {
			dano = atacar(E.get_def(),E.get_vida());
			E.set_vida(dano);
		}
		return dano;
	}

	/******** Metodo: ataque_esp_jefe ******************************
		Descripcion: Ataca al jefe con un ataque especial
		Parametros:
			opc entero
			J Jefe
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque especial hacia el jefe
	*******************************************************************/

	public int ata_esp_jefe(int opc,Jefe J){
		int dano;
		if (opc == 1 && cost_1 > 0) {
			dano = ataque_especial(opc,J.get_vida(),J.get_def());
			J.set_vida(dano);	
		} else if (opc == 2 && cost_2 > 0) {
			dano = ataque_especial(opc,J.get_vida(),J.get_def());
			J.set_vida(dano);	
		} else {
			dano = atacar(J.get_def(),J.get_vida());
			J.set_vida(dano);
		}
		return dano;
	}

}