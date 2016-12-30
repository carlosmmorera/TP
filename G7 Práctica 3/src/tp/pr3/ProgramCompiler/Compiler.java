//CORREGIR TODAS LAS EXCEPCIONES DE ESTA CLASE
package tp.pr3.ProgramCompiler;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.Instruction.Instruction;

public class Compiler {
	private ByteCodeProgram bytecode;
	private String[] varTable;
	private int numVars;
	
	public void compile(ParsedProgram pProgram) throws ArrayException {
		int i = 0;
		try {
			while (i < pProgram.getNumeroInstrucciones()){
				Instruction inst = pProgram.getInstructionAt(i);
				inst.compile(this);
				++i;
			}
		}
		catch (ArrayException e){
			
		}
	}
	public void addByteCode(ByteCode b) throws ArrayException {
		this.bytecode.pushbc(b);
	}
	public int getIndex(String varName) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < this.numVars && !encontrado){
			if (this.varTable[i].equals(varName)) encontrado = true;
			else ++i;
		}
		if (!encontrado){
			this.varTable[this.numVars] = varName;
			++this.numVars;
		}
		return i;
	}
	public int getProgramCounter(){
		return this.bytecode.getTam();
	}
}
