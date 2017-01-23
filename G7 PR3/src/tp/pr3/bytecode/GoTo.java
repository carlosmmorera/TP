package tp.pr3.bytecode;

import tp.pr3.cpu.CPU;
/**
 * Clase que gestiona el ByteCode GoTo.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public class GoTo implements ByteCode{
	private int n;
	/**
	 * Constructores de la clase.
	 */
	public GoTo(){
		this.n = 0;
	}
	public GoTo(int a){
		this.n = a;
	}
	/**
	 * M�todo que ejecuta el salto a la l�nea n.
	 * @param cpu par�metro de la clase @see {@link tp.pr3.cpu.CPU}.
	 */
	public void execute(CPU cpu){
		cpu.goTo(this.n);
	}
	/**
	 * M�todo que parsea la instrucci�n GoTo.
	 * @param s: cadena de caracteres que representa el ByteCode introducido.
	 * 
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con GoTo o no.
	 */
	public ByteCode parse(String[] s){
		try{
			if (s.length == 2 && s[0].equalsIgnoreCase("GOTO"))
				return new GoTo(Integer.parseInt(s[1]));
			else return null;
		}
		catch(NumberFormatException e){
			System.out.println("Error al introducir el ByteCode GOTO");
			System.out.println("A 'GOTO' debe precederle un caracter num�rico");
			return null;
		}
	}
	/**
	 * @return una string con el nombre del BC y el n�mero de
	 * la l�nea a saltar @see {@link tp.pr3.bytecode.GoTo#n}.
	 */
	public String toString(){
		return "GOTO " + this.n;
	}
}
