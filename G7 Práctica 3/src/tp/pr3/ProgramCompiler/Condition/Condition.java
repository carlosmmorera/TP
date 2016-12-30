package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ByteCode.ConditionalJumps.ConditionalJumps;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.*;

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
		if (op.length() <= TAM_MAX_CONDITION){
			Term term1 = TermParser.parse(t1);
			Term term2 = TermParser.parse(t2);
			
			if (term1 != null && term2 != null){
				return parseAux(term1, op, term2, parser);
			}
			else return null;
		}
		else return null;
	}
	abstract public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser);
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		try{
			compiler.addByteCode(this.t1.compile(compiler));
			compiler.addByteCode(this.t2.compile(compiler));
			compileAux(compiler);
		}
		catch(ArrayException e){
			
		}
	}
	abstract public void compileAux(tp.pr3.ProgramCompiler.Compiler compiler) throws 
		ArrayException;
}