package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.Halt;
import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Clase que implementa la instrucci�n Return.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Return implements Instruction{
	final int LENGTH_INSTRUCTION = 1;
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if(words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("RETURN")) return null;
		else{
			lexParser.increaseProgramCounter();
			return new Return();
		}
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		compiler.addByteCode(new Halt());
	}
}
