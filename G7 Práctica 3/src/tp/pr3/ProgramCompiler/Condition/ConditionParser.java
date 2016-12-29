package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ProgramCompiler.LexicalParser;

public class ConditionParser {
	private final static Condition[] conditions = {
		new Equal(), new Less(), new LessEq(), new NotEqual()
	};
	public static Condition parse(String t1, String op, String t2, LexicalParser lexical){
		Condition cnd = null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < conditions.length && !encontrado){
			cnd = conditions[i].parse(t1, op, t2, lexical);
			if (cnd != null) encontrado = true;
			++i;
		}
		return cnd;
	}
}
