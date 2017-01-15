package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.Exception.NonexistentVariable;
import tp.pr3.Exception.VariableTableOverflow;
/**
 * Interfaz que representa los t�rminos del c�digo, implemenatada 
 * por Number y Variable.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public interface Term {
	Term parse(String term);
	ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler) 
			throws VariableTableOverflow;
}
