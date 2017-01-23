package tp.pr3.programcompiler.term;

import tp.pr3.bytecode.ByteCode;
import tp.pr3.exception.NonexistentVariable;
/**
 * Interfaz que representa los t�rminos del c�digo, implemenatada 
 * por Number y Variable.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public interface Term {
	public Term parse(String term);
	public ByteCode compile(tp.pr3.programcompiler.Compiler compiler) 
			throws NonexistentVariable;
}
