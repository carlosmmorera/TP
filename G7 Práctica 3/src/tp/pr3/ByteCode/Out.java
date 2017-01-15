package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
import tp.pr3.Exception.StackTooSmall;
/**
 * Clase que gestiona el ByteCode Out.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class Out implements ByteCode{
	/**
	 * Método que ejecuta el ByteCode Out.
	 * @param cpu: @see {@link tp.pr3.CPU.CPU}.
	 * @throws StackTooSmall
	 */
	public void execute(CPU cpu)throws StackTooSmall{
		cpu.out();
		cpu.aumentarCont();
	}
	/**
	 * Método que parsea la instrucción Out.
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido.
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Out o no.
	 */
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else return null;
	}
	/**
	 * @return String con el nombre del BC.
	 */
	public String toString(){
		return "OUT";
	}
}
