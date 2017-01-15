package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Condition.*;
/**
 * Clase que implementa la instrucción IfThen.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 15/01/2017
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
	 * Método que parsea la instrucción.
	 * @param words: instrucción introducida en el programa.
	 * @param lexParser encargada del análisis léxico.
	 * @return Instruction dependiendo de si coincide con la instrucción de esta clase.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser) 
			throws ArrayException, LexicalAnalysisException{
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("IF")) return null;

		Condition cnd = ConditionParser.parse(words[1], words[2], 
				words[3], lexParser);
		
		if (cnd == null) return null;
		
		ParsedProgram iBody = new ParsedProgram();
		lexParser.increaseProgramCounter();
		lexParser.lexicalParser(iBody, "ENDIF");
		lexParser.increaseProgramCounter();
		return new IfThen(cnd, iBody);
	}
	/**
	 * Método que compila la instrucción.
	 * @param compiler
	 * @throws ArrayException
	 * @throws NonexistentVariable 
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler)
			throws ArrayException, VariableTableOverflow, NonexistentVariable{
		this.condition.compile(compiler);
		compiler.compile(this.ifThenBody);
		this.condition.setJump(compiler.getProgramCounter());
	}
	/**
	 * Método que genera un String de la instrucción.
	 */
	public String toString(){
		String s = "if " + this.condition.toString() + '\n' + this.ifThenBody.toString() +
				"endif\n";
		return s;
	}
}
