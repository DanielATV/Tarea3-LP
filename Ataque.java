public interface Ataque{

	/******** Metodo: atacar *********************************
		Descripcion: Calcula el daño a recibir mediante 
					 un ataque normal
		Parametros:
			def entero
			int vid
		Retorno: Retorna la cantidad de vida a 
				 perder derivado del ataque
	*********************************************************/

	public int atacar(int def, int vid);
}
