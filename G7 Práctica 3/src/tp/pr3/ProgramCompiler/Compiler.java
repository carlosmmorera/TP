package tp.pr3.ProgramCompiler;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.Instruction.Instruction;
/**
 * Clase encargada de generar el programa ByteCode.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class Compiler {
	private ByteCodeProgram bytecode;
	private String[] varTable;
	private int numVars;
	
	final int TAM_MAX = 100;
	/**
	 * Constructor de la clase
	 * @param bcProgram
	 */
	public Compiler(ByteCodeProgram bcProgram){
		this.bytecode = bcProgram;
		this.varTable = new String[TAM_MAX];
		this.numVars = 0;
	}
	/**
	 * Método que compila el programa parseado.
	 * @param pProgram: programa parseado.
	 * @throws ArrayException 
	 */
	public void compile(ParsedProgram pProgram) 
			throws ArrayException, VariableTableOverflow{
		int i = 0;
		while (i < pProgram.getNumeroInstrucciones()){
			Instruction inst = pProgram.getInstructionAt(i);
			inst.compile(this);
			++i;
		}
	}
	/**
	 * Método que inserta en el programa ByteCode el ByteCode correspondiente.
	 * @param b: ByteCode a introducir
	 * @throws ArrayException
	 */
	public void addByteCode(ByteCode b) throws ArrayException {
		this.bytecode.pushbc(b);
	}
	/**
	 * Método que obtiene el índice de la variable.
	 * @param varName
	 * @return int posición en la que se encuentra la variable.
	 */
	public int getIndex(String varName) throws VariableTableOverflow{
		int i = 0;
		boolean encontrado = false;
		
		while (i < this.numVars && !encontrado){
			if (this.varTable[i].equals(varName)) encontrado = true;
			else ++i;
		}
		if (!encontrado) addVar(varName);
		return i;
	}
	/**
	 * Método que obtiene el contador de programa.
	 * @return el contador de programa.
	 */
	public int getProgramCounter(){
		return this.bytecode.getTam();
	}
	/**
	 * Método que inserta una nueva variable en la tabla.
	 * @param varName: nombre de la variable a insertar.
	 * @throws VariableTableOverflow: que se produce cuando se supera el tamaño
	 * máximo del array varTable.
	 */
	private void addVar(String varName) throws VariableTableOverflow{
		if (this.numVars == TAM_MAX) 
			throw new VariableTableOverflow("Superado el número máximo "
					+ "permitido de variables en un programa.");
		
		this.varTable[this.numVars] = varName;
		++this.numVars;
	}
}
