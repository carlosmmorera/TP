package tp.pr3.ProgramCompiler;

import tp.pr3.Exception.ArrayException;
/**
 * Clase en la que se almacen el código introducido por el usuario.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class SourceProgram {
	final int TAM_MAX = 100;
	
	private String[] sProgram;
	private int numInstruc;
	/**
	 * Constructor de la clase.	
	 */
	public SourceProgram(){
		this.sProgram = new String[TAM_MAX];
		this.numInstruc = 0;
	}
	/**
	 * Método que carga una línea de código.
	 * @param s
	 * @throws ArrayException
	 */
	public void cargarInst(String s)throws ArrayException{
		if (this.numInstruc == TAM_MAX) throw new ArrayException("Superado el "
				+ "tamaño máximo permitido para un código fuente.");
		
		this.sProgram[this.numInstruc] = s;
		++this.numInstruc;
	}
	/**
	 * Método con el que se obtiene el número de líneas del programa.
	 * @return número de instrucciones.
	 */
	public int getNumeroInstrucciones(){
		return this.numInstruc;
	}
	/**
	 * Método que devuelve la instrucción n-ésima de un programa.
	 * @param n
	 * @return String que representa una línea del código dado.
	 * @throws ArrayException
	 */
	public String getInstructionAt(int n)throws ArrayException{
		if (n < 0 && n >= this.numInstruc) throw new ArrayException("Acceso a posición "
				+ "del código fuente inexistente.");

		return this.sProgram[n];
	}
	/**
	 * Método que transforma a String el programa almacenado.
	 */
	public String toString(){
		String strProgram = "Programa fuente almacenado:\n";
		for (int i = 0; i < this.numInstruc; ++i){
			strProgram += i + ": " + this.sProgram[i] + "\n";
		}
		return strProgram;
	}
	public void reset(){
		this.numInstruc = 0;
	}
}
