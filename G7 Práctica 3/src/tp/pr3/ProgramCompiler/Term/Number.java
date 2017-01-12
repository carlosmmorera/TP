package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.*;
/**
 * Clase que implementa los términos numéricos que aparecen en el código.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class Number implements Term{
	private int value;
	/**
	 * Constructores de la clase.
	 */
	public Number(){
		this.value = 0;
	}
	public Number(int n){
		this.value = n;
	}
	/**
	 * Método que parsea el término dado.
	 * @param term: término dado a parsear.
	 * @return Term dependiendo si el término introducido en 
	 * el programa es númerico.
	 */
	public Term parse(String term){
		try{
			return new Number(Integer.parseInt(term));
		}
		catch(NumberFormatException e){
			return null;
		}
	}
	/**
	 * Método que compila el término numérico.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @return Bytecode en el que se traduce el término.
	 */
	public ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler){
		return new Push(this.value);
	}
	/**
	 * Método que pasa a un String esta clase.
	 */
	public String toString(){
		return Integer.toString(this.value);
	}
}
