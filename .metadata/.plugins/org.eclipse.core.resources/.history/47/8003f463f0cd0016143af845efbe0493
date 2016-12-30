package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.ParsedProgram;
import tp.pr3.ProgramCompiler.Condition.Condition;

public class While implements Instruction{
	Condition condition;
	ParsedProgram whileBody;
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		//...
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDWHILE");
		lexParser.increaseProgramCounter();
		//...
	}
	public void compile(Compiler compiler) throws ArrayException{...}
}
