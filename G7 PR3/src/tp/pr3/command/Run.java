package tp.pr3.command;

import tp.pr3.exception.ExecutionError;
import tp.pr3.exception.NonexistentBCProgram;
import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Run.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Run implements Command {
	/**
	 * M�todo que ejecuta el comando Run.
	 * @param engine: @see {@link Engine}.
	 * @throws ExecutionError 
	 * @throws NonexistentBCProgram 
	  */
	public void execute(Engine engine) throws ExecutionError, NonexistentBCProgram {
		engine.run();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Run o no.
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;
	}
	/**
	 * M�todo que devuelve un string con informaci�n sobre el comando RUN.
	 */
	public String textHelp(){
		return " RUN: Ejecuta el programa " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "RUN";
	}
}
