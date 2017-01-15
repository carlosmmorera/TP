package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.Exception.NonexistentVariable;
/**
 * Interfaz que representa los términos del código, implemenatada 
 * por Number y Variable.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 15/01/2017
 */
public interface Term {
	public Term parse(String term);
	public ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler) 
			throws NonexistentVariable;
}
