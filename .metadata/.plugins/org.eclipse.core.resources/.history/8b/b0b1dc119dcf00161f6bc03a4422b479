package tp.pr3.ProgramCompiler.Term;

public class TermParser {
	private final static Term[] terms = {
		new Variable(), new Number(),
	};
	public static Term parse(String s){
		Term t =  null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < terms.length && !encontrado){
			t = terms[i].parse(s);
			if (t != null) encontrado = true;
			++i;
		}
		return t;
	}
}
