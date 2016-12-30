package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Push
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Push implements ByteCode{
	private int n;
	/**
	 * Constructores de la clase
	 */
	public Push(){
		this.n = 0;
	}
	public Push(int a){
		this.n = a;
	}
	/**
	 * Método que ejecuta el ByteCode Push
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 * @return booleano dependiendo de si se pudo realizar la operación 
	 * con éxito o no
	 */
	public void execute(CPU cpu){
		cpu.push(this.n);
		cpu.aumentarCont();
	}
	/**
	 * Método que parsea la instruccion Push
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Push o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(s[1]));
		else return null;
	}
	/**
	 * @return String con el nombre del ByteCode
	 */
	public String toString(){
		return "PUSH " + this.n;
	}
}
