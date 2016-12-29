package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ProgramCompiler.LexicalParser;

public class Equal extends Condition{
	public Condition parseAux(String t1, String op, String t2,
			LexicalParser parser){
		//�No habr�a que parsear los t�rminos?
		if (op.equalsIgnoreCase("==")) return Equal(Integer.parseInt(t1), 
				Integer.parseInt(t2));
		else return null;
	}
}
