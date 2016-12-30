package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.ParsedProgram;
import tp.pr3.ProgramCompiler.Condition.Condition;
import tp.pr3.ProgramCompiler.Condition.ConditionParser;

public class IfThen implements Instruction{
	Condition condition;
	ParsedProgram ifThenBody;
	
	final int NUMCOMPONENTES = 4;
	
	public IfThen(){ }
	public IfThen(Condition cnd, ParsedProgram iBody){
		this.condition = cnd;
		this.ifThenBody = iBody;
	}
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("IF")) return null;
		else {
			Condition cnd = ConditionParser.parse(words[1], words[2], 
					words[3], lexParser);
			
			if (cnd == null) return null;
			else{
				ParsedProgram iBody = new ParsedProgram();
				try{
					lexParser.lexicalParser(iBody, "ENDIF");
					lexParser.increaseProgramCounter();
					return new IfThen(cnd, iBody);
				}
				catch(LexicalAnalysisException e){
					System.out.println(e + "Error en la línea: " + 
							lexParser.getProgramCounter());
					System.out.println("No se ha podido compilar el programa");
					
					return null;
				}
			}
		}
	}
	public void compile(Compiler compiler) throws ArrayException{...}
}
