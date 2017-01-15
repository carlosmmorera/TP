package tp.pr3.ProgramCompiler;

import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.Instruction.*;
/**
 * Clase encargada de gestionar el programa parseado.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public class ParsedProgram {
	final int TAM_MAX = 100;
	
	private Instruction[] pProgram;
	private int numInstruc;
	/**
	 * Constructor de la clase.
	 */
	public ParsedProgram(){
		this.pProgram = new Instruction[TAM_MAX];
		this.numInstruc = 0;
	}
	/**
	 * M�todo encargado de cargar la instrucci�n dada.
	 * @param instr: instrucci�n dada para cargar.
	 * @throws ArrayException
	 */
	public void cargarInst(Instruction instr)throws ArrayException{
		if (this.numInstruc == TAM_MAX) throw new ArrayException("Superado el tama�o "
				+ "m�ximo permitido de un programa parseado.");
		
		this.pProgram[this.numInstruc] = instr;
		++this.numInstruc;
	}
	/**
	 * M�todo con el que se obtiene el n�mero de instrucciones parseadas.
	 * @return int n�mero de instrucciones parseadas.
	 */
	public int getNumeroInstrucciones() {
		return this.numInstruc;
	}
	/**
	 * M�todo que devuelve la instrucci�n n-�sima del programa parseado.
	 * @param n
	 * @return Instruction.
	 * @throws ArrayException
	 */
	public Instruction getInstructionAt(int n) throws ArrayException{
		if (n < 0 && n >= this.numInstruc) throw new ArrayException("Acceso a posici�n "
				+ "del programa parseado inexistente.");
		
		return this.pProgram[n];
	}
	/**
	 * M�todo utilizado para resetear el Progarma Parseado.
	 */
	public void reset(){
		this.numInstruc = 0;
	}
	/**
	 * M�todo que genera un String de la clase.
	 */
	public String toString(){
		String s = "";
		for (int i = 0; i < this.numInstruc; ++i){
			s = this.pProgram[i].toString() + '\n';
		}
		return s;
	}
}
