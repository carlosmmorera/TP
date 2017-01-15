package tp.pr3.ByteCode.ConditionalJumps;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el operador de salto condicional IfNeq.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class IfNeq extends ConditionalJumps{
	/**
	 * Constructores de la clase.
	 * @param n inicialización de la posición a la que saltar.
	 */
	public IfNeq(int n){
		super(n);
	}
	public IfNeq(){
		super();
	}
	/**
	 * Método que ejecuta el ByteCode.
	 * @param cpu: @see {@link tp.pr3.CPU}.
	 * @param op1 primer operando a comparar.
	 * @param op2 segundo operando a comparar.
	 */
	public void ejec(CPU cpu, int op1, int op2){
		if (op1 != op2){
			cpu.aumentarCont();
		}
		else cpu.goTo(this.pos);
	}
	/**
	 * Método que parsea el salto condicional IfNeq.
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido.
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con IfNeq o no.
	 */
	public ByteCode parseCondJump(String[] s){
		try{
			if(s[0].equalsIgnoreCase("IFNEQ")){
				int numinstr = Integer.parseInt(s[1]);
				return new IfNeq(numinstr);
			}
			else return null;
		}
		catch(NumberFormatException e){
			System.out.println("Error al introducir el ByteCode IFNEQ");
			System.out.println("A 'IFNEQ' debe precederle un caracter numérico");
			return null;
		}
	}
	
	/**
	 * @return la cadena de caracteres que corresponde al ByteCode introducida.
	 */
	public String toString(){
		return "IFNEQ " + this.pos;
	}
}