package tp.pr3.ProgramCompiler;

import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.Instruction.*;
/**
 * Clase que se encarga de parsear el programa.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;
	/**
	 * Constructor de la clase.
	 * @param srcPr
	 */
	public LexicalParser(SourceProgram srcPr){
		this.sProgram = srcPr;
		this.programCounter = 0;
	}
	/**
	 * M�todo que se encarga de parsear el c�digo introducido.
	 * @param pProgram: Programa parseado.
	 * @param stopKey: centinela en el que acaba el programa a parsear.
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey)
		throws LexicalAnalysisException, ArrayException{
		String instr = "";
		boolean stop = false;
		Instruction instruction = null;
		
		while (this.programCounter < this.sProgram.getNumeroInstrucciones()
				&& !stop){
			instr = sProgram.getInstructionAt(this.programCounter);
			instr = instr.trim();
			
			if (instr.equalsIgnoreCase(stopKey))stop = true;
			else {
				instruction = ParserInstruction.parse(instr,this);
				pProgram.cargarInst(instruction);
			}
		}
	}
	/**
	 * M�todo que incrementa el contador de programa.
	 */
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	/**
	 * M�todo con el que se obtiene el contador de programa.
	 * @return int ProgramCounter
	 */
	public int getProgramCounter(){
		return this.programCounter;
	}
}
