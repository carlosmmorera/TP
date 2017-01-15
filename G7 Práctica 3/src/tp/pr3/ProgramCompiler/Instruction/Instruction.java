package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Interfaz con la que representamos las instrucciones del c�digo.
 * 
 * Es implementada por: CompoundAssignment, IfThen, Return, SimpleAssignment,
 * While y Write.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public interface Instruction {
	public Instruction lexParse(String[] words, LexicalParser lexParser) 
			throws ArrayException, LexicalAnalysisException;
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) 
			throws ArrayException, VariableTableOverflow, NonexistentVariable;
}
