package tp.pr3.Command;

import java.io.FileNotFoundException;

import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.BadFormatByteCode;
import tp.pr3.Exception.ExecutionError;
import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.Exception.NonexistentVariable;
import tp.pr3.Exception.VariableTableOverflow;
import tp.pr3.mv.Engine;
/**
 * Clase abstracta que gestiona los comandos de la que heredan AddByteCommand,
 *  Help, Quit, Replace, Reset y Run.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 15/01/2017
 *
 */
public interface Command {
	public void execute(Engine engine) 
			throws LexicalAnalysisException, ArrayException, 
			VariableTableOverflow, BadFormatByteCode, ExecutionError, 
			NonexistentVariable, FileNotFoundException;
	public Command parse(String[] s);
	public String textHelp();
}
