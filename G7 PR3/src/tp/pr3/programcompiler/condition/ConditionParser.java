package tp.pr3.programcompiler.condition;

import tp.pr3.programcompiler.LexicalParser;
/**
 * Clase encargada del parseo de las condiciones.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class ConditionParser {
	private final static Condition[] conditions = {
		new Equal(), new Less(), new LessEq(), new NotEqual()
	};
	/**
	 * M�todo encargado de parsear la condici�n dada.
	 * @param t1: primer t�rmino a parsear.
	 * @param op: operador booleano a parsear.
	 * @param t2: segundo t�rmino a parsear.
	 * @param lexical
	 * @return Condition en funci�n de la condici�n introducida.
	 */
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
