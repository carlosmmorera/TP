package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Store
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Store extends ByteCode{
	private int n;
	/**
	 * Constructores de la clase
	 */
	public Store(){
		this.n = 0;
	}
	public Store(int a){
		this.n = a;
	}
	/**
	 * Método que ejecuta el ByteCode Store
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 * @return booleano dependiendo de si se pudo realizar la operación 
	 * con éxito o no
	 */
	public boolean execute(CPU cpu){
		if (cpu.store(this.n)){
			cpu.aumentarCont();
			return true;
		}
		else return false;
	}
	/**
	 * Método que parsea la instruccion Store
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Push o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("STORE"))
			return new Store(Integer.parseInt(s[1]));
		else return null;
	}
	/**
	 * @return String con el nombre del ByteCode
	 */
	public String toString(){
		return "STORE " + this.n;
	}
}
