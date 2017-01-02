package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.*;
/**
 * Clase que implementa la instrucci�n SimpleAssignment.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class SimpleAssignment implements Instruction{
	private String var_name;
	private Term rhs;
	
	final int NUMCOMPONENTES = 3;
	/**
	 * Constructores de la clase.
	 */
	public SimpleAssignment(){
		this.var_name = "";
	}
	public SimpleAssignment(String varName, Term term){
		this.var_name = varName;
		this.rhs = term;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 */
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
	/**
	 * M�todo que compila la instrucci�n.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		compiler.addByteCode(this.rhs.compile(compiler));
		ByteCode bc = new Store(compiler.getIndex(this.var_name));
		compiler.addByteCode(bc);
	}
}