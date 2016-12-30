package tp.pr3.ProgramCompiler;

import tp.pr3.ProgramCompiler.Instruction.*;

public class ParsedProgram {
	final int TAM_INI = 100;
	
	private Instruction[] pProgram;
	private int numInstruc;
	private int tam;
	
	public ParsedProgram(){
		this.pProgram = new Instruction[TAM_INI];
		this.numInstruc = 0;
		this.tam = TAM_INI;
	}
	public void cargarInst(Instruction instr){
		if (this.numInstruc == this.tam) this.resize();
		
		this.pProgram[this.numInstruc] = instr;
		++this.numInstruc;
	}
	public void resize(){
		int newtam = 2*this.tam;
		Instruction[] newsProgram = new Instruction[newtam];
		
		for (int i = 0; i < this.tam; ++i){
			newsProgram[i] = this.pProgram[i];
		}
		this.pProgram = newsProgram;
		this.tam = newtam;
	}
	public int getNumeroInstrucciones() {
		return this.numInstruc;
	}
	public Instruction getInstructionAt(int n) {
		if (n >= 0 && n < this.numInstruc) return this.pProgram[n];
		else return null;
	}
}
