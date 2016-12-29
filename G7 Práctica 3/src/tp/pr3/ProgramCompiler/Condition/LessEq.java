package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ProgramCompiler.LexicalParser;

public class LessEq extends Condition{
	public Condition parseAux(String t1, String op, String t2,
			LexicalParser parser){
		if (op.equalsIgnoreCase("<=")) return LessEq(Integer.parseInt(t1), 
				Integer.parseInt(t2));
		else return null;
	}
}
