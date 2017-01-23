package tp.pr3.programcompiler;

import tp.pr3.exception.*;
import tp.pr3.programcompiler.instruction.*;
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
				
				if (instruction == null) throw new LexicalAnalysisException("Error en "
						+ "la sint�xis del c�digo fuente en la l�nea " + 
						this.programCounter + "\nLa instrucci�n '" + instr + 
						"' no existe");
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
}
