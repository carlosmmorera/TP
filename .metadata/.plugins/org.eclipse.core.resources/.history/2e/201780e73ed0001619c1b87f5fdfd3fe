package tp.pr3.Command;

import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.BadFormatByteCode;
import tp.pr3.Exception.BadFormatCommand;
import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.mv.Engine;
/**
 * Clase abstracta que gestiona los comandos de la que heredan AddByteCommand,
 *  Help, Quit, Replace, Reset y Run.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/11/2016
 *
 */
public interface Command {
	public void execute(Engine engine) throws BadFormatByteCode, ArrayException, LexicalAnalysisException;
	public Command parse(String[] s);
	public String textHelp();
}
