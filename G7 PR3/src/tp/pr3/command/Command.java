package tp.pr3.command;

import java.io.FileNotFoundException;

import tp.pr3.exception.ArrayException;
import tp.pr3.exception.BadFormatByteCode;
import tp.pr3.exception.ExecutionError;
import tp.pr3.exception.LexicalAnalysisException;
import tp.pr3.exception.NonexistentBCProgram;
import tp.pr3.exception.NonexistentVariable;
import tp.pr3.exception.VariableTableOverflow;
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
			NonexistentVariable, FileNotFoundException, NonexistentBCProgram;
	public Command parse(String[] s);
	public String textHelp();
}
