package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Load
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Load implements ByteCode{
	private int n;
	/**
	 * Constructores de la clase
	 */
	public Load(){
		this.n = 0;
	}
	public Load(int a){
		this.n = a;
	}
	/**
	 * M�todo que ejecuta el ByteCode Load
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 */
	public void execute(CPU cpu){
		cpu.load(this.n);
		cpu.aumentarCont();
	}
	/**
	 * M�todo que parsea la instruccion Load
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Load o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(s[1]));
		else return null;
	}
	/**
	 * @return String con el nombre del BC
	 */
	public String toString(){
		return "LOAD " + this.n;
	}
}
