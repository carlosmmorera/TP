package tp.pr3.Command;

import tp.pr3.Exception.*;
import tp.pr3.mv.Engine;

/**
 * Clase que gestiona el comando Compile.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */

public class Compile implements Command{
	/**
	 * M�todo que ejecuta el comando Compile.
	 * @param engine @see {@link Engine}.
	 * @throws LexicalAnalysisException 
	 * @throws ArrayException
	 * @Override
	 */
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException{
		engine.compile();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Compile o no
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando HELP.
	 */
	public String textHelp(){
		return " COMPILE: Compila el programa introducido " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "COMPILE";
	}
}
