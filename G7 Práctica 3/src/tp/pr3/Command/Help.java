package tp.pr3.Command;

import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Help.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Help implements Command {
	/**
	 * M�todo que ejecuta el comando Help.
	 * @param engine: @see {@link Engine}.
	 */
	public void execute(Engine engine){
		CommandParser.showHelp();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Help o no.
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando HELP.
	 */
	public String textHelp(){
		return " HELP: Muestra esta ayuda " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "HELP";
	}
}
