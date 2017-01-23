package tp.pr3.bytecode.conditionaljumps;

import tp.pr3.bytecode.ByteCode;
import tp.pr3.cpu.CPU;
/**
 * Clase que gestiona el operador de salto condicional IfEq.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class IfEq extends ConditionalJumps{
	/**
	 * Constructores de la clase.
	 * @param n: instrucción a la que se desea saltar.
	 */
	public IfEq(int n){
		super(n);
	}
	public IfEq(){
		super();
	}
	/**
	 * Método que ejecuta el ByteCode.
	 * @param cpu: @see {@link tp.pr3.cpu}.
	 * @param op1 primer operando a comparar.
	 * @param op2 segundo operando a comparar.
	 */
	public void ejec(CPU cpu, int op1, int op2){
		if (op1 == op2){
			cpu.aumentarCont();
		}
		else cpu.goTo(this.pos);
	}
	/**
	 * Método que parsea el salto condicional IfEq.
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido.
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con IfEq o no.
	 */
	public ByteCode parseCondJump(String[] s){
		try{
			if(s[0].equalsIgnoreCase("IFEQ")){
				int numinstr = Integer.parseInt(s[1]);
				return new IfEq(numinstr);
			}
			else return null;
		}
		catch(NumberFormatException e){
			System.out.println("Error al introducir el ByteCode IFEQ");
			System.out.println("A 'IFEQ' debe precederle un caracter numérico");
			return null;
		}
	}
	
	/**
	 * @return la cadena de caracteres que corresponde al ByteCode introducida.
	 */
	public String toString(){
		return "IFEQ " + this.pos;
	}
}
