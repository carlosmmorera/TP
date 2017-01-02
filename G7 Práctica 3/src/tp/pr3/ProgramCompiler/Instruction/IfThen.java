package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Condition.*;
/**
 * Clase que implementa la instrucci�n IfThen.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class IfThen implements Instruction{
	Condition condition;
	ParsedProgram ifThenBody;
	
	final int NUMCOMPONENTES = 4;
	/**
	 * Constructores de la clase.
	 */
	public IfThen(){ }
	public IfThen(Condition cnd, ParsedProgram iBody){
		this.condition = cnd;
		this.ifThenBody = iBody;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 * @throws ArrayException 
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) 
			throws ArrayException{
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("IF")) return null;
		else {
			Condition cnd = ConditionParser.parse(words[1], words[2], 
					words[3], lexParser);
			
			if (cnd == null) return null;
			else{
				try{
					ParsedProgram iBody = new ParsedProgram();
					lexParser.increaseProgramCounter();
					lexParser.lexicalParser(iBody, "ENDIF");
					lexParser.increaseProgramCounter();
					return new IfThen(cnd, iBody);
				}
				catch (LexicalAnalysisException e){
					return null;
				}
			}
		}
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler)throws ArrayException{
		this.condition.compile(compiler);
		compiler.compile(this.ifThenBody);
		this.condition.setJump(compiler.getProgramCounter());
	}
}
