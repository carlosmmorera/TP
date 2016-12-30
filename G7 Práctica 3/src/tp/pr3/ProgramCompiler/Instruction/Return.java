package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;

public class Return implements Instruction{
	final int LENGTH_INSTRUCTION = 1;
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if(words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("RETURN")) return null;
		else return new Return();
	}
}
