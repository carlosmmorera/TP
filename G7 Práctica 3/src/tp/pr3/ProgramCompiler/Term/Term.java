package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.ByteCode;
/**
 * Interfaz que representa los términos del código de la que heredan Number y Variable.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public interface Term {
	Term parse(String term);
	ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler);
}
