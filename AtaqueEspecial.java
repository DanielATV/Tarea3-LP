public interface AtaqueEspecial{

	/******** Metodo: ataque_especial ************************
		Descripcion: Calcula el daño a recibir mediante 
					 un ataque especial
		Parametros:
			opc entero
			def entero
			int vid
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque especial
	*********************************************************/

	public int ataque_especial(int opc,int vida, int def);
}

