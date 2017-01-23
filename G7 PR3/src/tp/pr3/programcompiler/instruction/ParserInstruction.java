package tp.pr3.programcompiler.instruction;

import tp.pr3.exception.ArrayException;
import tp.pr3.exception.LexicalAnalysisException;
import tp.pr3.programcompiler.LexicalParser;
/**
 * Clase que se encarga del parseo de las instrucciones del código.
 * @author Carlos Moreno Morera
 * @author Manuel Suárez
 * @version 15/01/2017
 */
public class ParserInstruction {
	final static int LONG_MAX_INSTRUCTION = 5;
	
	private final static Instruction[] instructions = {
		new SimpleAssignment(), new CompoundAssignment(), new IfThen(),
		new While(), new Return(), new Write(),
	};
	/**
	 * Método encargado del parseo de las instrucciones.
	 * @param line: línea de código introducida.
	 * @param parser
	 * @return Instruction dependiendo de la instrucción de la que se trate.
	 * @throws LexicalAnalysisException si no coincide con ninguna instrucción conocida.
	 * @throws ArrayException 
	 */
	public static Instruction parse(String line, LexicalParser parser)
			throws ArrayException, LexicalAnalysisException{
		String[] s = line.split(" ");
		if (s.length > LONG_MAX_INSTRUCTION) return null;
		
		Instruction instr = null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < instructions.length && !encontrado){
			instr = instructions[i].lexParse(s, parser);
			if (instr != null) encontrado = true;
			++i;
		}
		return instr;
	}
}
