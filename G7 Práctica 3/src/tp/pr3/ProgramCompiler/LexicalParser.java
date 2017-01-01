package tp.pr3.ProgramCompiler;

import tp.pr3.ProgramCompiler.Instruction.*;

public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;
	
//	public LexicalParser(){
//		this.sProgram = new SourceProgram();
//		this.programCounter = 0;
//	}
//	public LexicalParser(SourceProgram srcPr){
//		this.sProgram = srcPr;
//		this.programCounter = 0;
//	}
//	public LexicalParser(SourceProgram srcPr, int n){
//		this.sProgram = srcPr;
//		this.programCounter = n;
//	}
	
	//TIENE QUE INCREMENTAR EL CONTADOR
	public void lexicalParser(ParsedProgram pProgram, String stopKey){
		String instr = "";
		boolean stop = false;
		Instruction instruction = null;
		
		while (this.programCounter < this.sProgram.getNumeroInstrucciones()&& !stop){
			instr = sProgram.getInstructionAt(this.programCounter);
			
			if (instr.equalsIgnoreCase(stopKey))stop = true;
			else {
				instruction = ParserInstruction.parse(instr,this);
				pProgram.cargarInst(instruction);
				this.increaseProgramCounter();
			}
		}
	}
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	public int getProgramCounter(){
		return this.programCounter;
	}
}
