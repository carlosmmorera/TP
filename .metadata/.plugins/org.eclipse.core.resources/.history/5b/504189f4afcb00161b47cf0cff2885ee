package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Out
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Out extends ByteCode{
	/**
	 * Método que ejecuta el ByteCode Out
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 * @return booleano dependiendo de si se pudo realizar la operación 
	 * con éxito o no
	 */
	public boolean execute(CPU cpu){
		if (cpu.out()){
			cpu.aumentarCont();
			return true;
		}
		else return false;
	}
	/**
	 * Método que parsea la instrucción Out
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Out o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else return null;
	}
	/**
	 * @return String con el nombre del BC
	 */
	public String toString(){
		return "OUT";
	}
}
