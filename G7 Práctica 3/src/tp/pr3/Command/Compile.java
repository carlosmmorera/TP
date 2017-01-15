package tp.pr3.Command;

import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.Exception.NonexistentVariable;
import tp.pr3.Exception.VariableTableOverflow;
import tp.pr3.mv.Engine;

/**
 * Clase que gestiona el comando Compile.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 15/01/2017
 */

public class Compile implements Command{
	/**
	 * Método que ejecuta el comando Compile.
	 * @param engine
	 * @throws VariableTableOverflow 
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws NonexistentVariable
	 */
	public void execute(Engine engine) 
			throws LexicalAnalysisException, ArrayException, 
			VariableTableOverflow, NonexistentVariable {
		engine.compile();
	}
	/**
	 * Método que parsea el comando introducido por el usuario.
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
	 * Método que devuelve un string con información sobre el comando HELP.
	 */
	public String textHelp(){
		return " COMPILE: Compila el programa introducido " +
				System.getProperty("line.separator");
	}
	/**
	 * Método que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "COMPILE";
	}
}
