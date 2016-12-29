package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ByteCode.ConditionalJumps.ConditionalJumps;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;

public abstract class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition; //para la compilación
	
	final int TAM_MAX_CONDITION = 2;
	
	public Condition(){	}
	public Condition(Term term1, Term term2){
		this.t1 = term1;
		this.t2 = term2;
	}
	
	public Condition parse(String t1, String op, String t2,
			LexicalParser parser){
		if (op.length() <= TAM_MAX_CONDITION) return parseAux(t1, op, t2, parser);
		else return null;
	}
	abstract public Condition parseAux(String t1, String op, String t2,
			LexicalParser parser);
	abstract public void compile(Compiler compiler) throws ArrayException;
	//Otros métodos abstractos
}