package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.GoTo;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Condition.*;
/**
 * Clase que implementa la instrucci�n While.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public class While implements Instruction{
	Condition condition;
	ParsedProgram whileBody;
	
	final int NUMCOMPONENTES = 4;
	/**
	 * Constructores de la clase.
	 */
	public While(){ }
	public While(Condition cnd, ParsedProgram wBody){
		this.condition = cnd;
		this.whileBody = wBody;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexParser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) 
			throws ArrayException, LexicalAnalysisException{
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("WHILE")) return null;
		else {
			Condition cnd = ConditionParser.parse(words[1], words[2], 
					words[3], lexParser);
			
			if (cnd == null) return null;
			ParsedProgram wBody = new ParsedProgram();
			lexParser.increaseProgramCounter();
			lexParser.lexicalParser(wBody, "ENDWHILE");
			lexParser.increaseProgramCounter();
			return new While(cnd, wBody);
		}
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param compiler
	 * @throws ArrayException
	 * @throws VariableTableOverflow
	 * @throws NonexistentVariable 
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) 
			throws ArrayException, VariableTableOverflow, NonexistentVariable{
		
		int pc1 = compiler.getProgramCounter();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(pc1));
		this.condition.setJump(compiler.getProgramCounter());
	}
	/**
	 * M�todo que genera un String de la instrucci�n.
	 */
	public String toString(){
		String s = "while " + this.condition.toString() + '\n' + this.whileBody.toString()
				+ "endwhile";
		return s;
	}
}
