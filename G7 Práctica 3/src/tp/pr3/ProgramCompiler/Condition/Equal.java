package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ByteCode.ConditionalJumps.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;
/**
 * Clase que implementa la condición '='.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class Equal extends Condition{
	/**
	 * Constructores de la clase.
	 */
	public Equal(){
		super();
	}
	public Equal(Term t1, Term t2){
		super(t1,t2);
	}
	/**
	 * Método que parsea la condición.
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return Condition en función de si la condición coincide con esta clase.
	 */
	public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser){
		if (op.equals("=")) return new Equal(t1, t2);
		else return null;
	}
	/**
	 * Método que compila esta condición.
	 * @return ConditionalJumps de acuerdo con esta condición.
	 */
	public ConditionalJumps compileAux(){
		return new IfEq();
	}
}
