package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Clase que implementa la instrucci�n Write.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Write implements Instruction{
	private String varName;
	
	final int LENGTH_INSTRUCTION = 2;
	/**
	 * Constructores de la clase.
	 */
	public Write(){
		this.varName = "";
	}
	public Write(String var_name){
		this.varName = var_name;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n 
	 * de esta clase.
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("WRITE")) return null;
		else{
			lexParser.increaseProgramCounter();
			return new Write(words[1]);
		}
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) 
			throws ArrayException, VariableTableOverflow{
		ByteCode bc = new Load(compiler.getIndex(this.varName));
		compiler.addByteCode(bc);
		compiler.addByteCode(new Out());
	}
}
