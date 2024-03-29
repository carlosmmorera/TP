package tp.pr2.Command;

import tp.pr2.mv.Engine;
/**
 * Clase que gestiona el comando Quit
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Quit extends Command {
	/**
	 * M�todo que ejecuta el comando Quit
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecuci�n del comando tuvo
	 * �xito o no @see {@link Engine#quit()}
	  */
	public boolean execute(Engine engine){
		return engine.quit();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario
	 * @param s cadena de caracteres introducida por el usuario
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Quit o no
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando QUIT
	 */
	public String textHelp(){
		return " QUIT: Cierra la aplicacion " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "QUIT";
	}
}
