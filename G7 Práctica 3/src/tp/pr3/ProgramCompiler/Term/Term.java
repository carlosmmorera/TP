package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.ByteCode;
/**
 * Interfaz que representa los t�rminos del c�digo de la que heredan Number y Variable.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public interface Term {
	Term parse(String term);
	ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler);
}
