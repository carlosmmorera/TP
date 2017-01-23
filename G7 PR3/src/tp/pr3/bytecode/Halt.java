package tp.pr3.bytecode;

import tp.pr3.cpu.CPU;
/**
 * Clase que gestiona el ByteCode Halt.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 *
 */
public class Halt implements ByteCode{
	/**
	 * Método que ejecuta el ByteCode (para el programa).
	 * @param cpu: @see {@link tp.pr3.cpu.CPU}.
	 */
	public void execute(CPU cpu){
		cpu.halt();
	}
	/**
	 * Método que parsea la instrucción Halt.
	 * @param s recibe la cadena de caracteres que representa el 
	 * ByteCode introducido.
	 * 
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Halt o no.
	 */
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else return null;
	}
	/**
	 * @return String con el nombre del BC.
	 */
	public String toString(){
		return "HALT";
	}
}
