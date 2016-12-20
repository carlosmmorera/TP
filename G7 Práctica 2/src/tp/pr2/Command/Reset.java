package tp.pr2.Command;

import tp.pr2.mv.Engine;
/**
 * Clase que gestiona el comando Reset
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Reset extends Command {
	/**
	 * Método que ejecuta el comando Reset
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecución del comando tuvo
	 * éxito o no @see {@link Engine#resetProgram()}
	  */
	public boolean execute(Engine engine) {
		return engine.resetProgram();
	}
	/**
	 * Método que parsea el comando introducido por el usuario
	 * @param s cadena de caracteres introducida por el usuario
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Reset o no
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else return null;
	}
	/**
	 * Método que devuele un string con información sobre el comando RESET
	 */
	public String textHelp() {
		return " RESET: Vacia el programa actual " +
		System.getProperty("line.separator");
	}
	/**
	 * Método que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "RESET";
	}
}
