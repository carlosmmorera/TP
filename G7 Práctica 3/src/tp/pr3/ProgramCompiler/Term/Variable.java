package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.VariableTableOverflow;
/**
 * Clase que implementa las variables del c�digo.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Variable implements Term {
	private String varName;
	/**
	 * Constructores de la clase
	 */
	public Variable(){
		this.varName = "";
	}
	public Variable(String s){
		this.varName = s;
	}
	/**
	 * M�todo que parsea el t�rmino dado.
	 * @param term: t�rmino dado en el c�digo.
	 * @return Term dependiendo si el t�rmino introducido en el programa se
	 * corresponde con una variable.
	 * 
	 * @Override
	 */
	public Term parse(String term) {
		if (term.length() != 1) return null;
		else {
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z') return new Variable(term);
			else return null;
		}
	}	
	/**
	 * M�todo que compila la variable dada.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @return ByteCode correspondiente con la variable.
	 * 
	 * @Override
	 */
	public ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler)
		throws VariableTableOverflow{
		return new Load(compiler.getIndex(this.varName));
	}
	/**
	 * M�todo que pasa a un String esta clase.
	 */
	public String toString(){
		return this.varName;
	}
}
