package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.*;

public class SimpleAssignment implements Instruction{
	private String var_name;
	private Term rhs;
	
	final int NUMCOMPONENTES = 3;
	
	public SimpleAssignment(){
		this.var_name = "";
	}
	public SimpleAssignment(String varName, Term term){
		this.var_name = varName;
		this.rhs = term;
	}
	public Instruction lexParse(String[] words, LexicalParser lexparser){
		if (words.length != NUMCOMPONENTES || words[1].length() != 1) return null;
		else{
			if (!words[1].equals("=")) return null;
			else {
				Term term = TermParser.parse(words[2]);
				if (term == null) return null;
				else{
					lexparser.increaseProgramCounter();
					return new SimpleAssignment(words[0], term);
				}
			}
		}
	}
}