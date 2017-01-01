package tp.pr3.Command;

import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Quit
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Quit implements Command {
	/**
	 * Método que ejecuta el comando Quit
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecución del comando tuvo
	 * éxito o no @see {@link Engine#quit()}
	  */
	public void execute(Engine engine){
		engine.quit();
	}
	/**
	 * Método que parsea el comando introducido por el usuario
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
	 * Método que devuele un string con información sobre el comando QUIT
	 */
	public String textHelp(){
		return " QUIT: Cierra la aplicacion " +
				System.getProperty("line.separator");
	}
	/**
	 * Método que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "QUIT";
	}
}
