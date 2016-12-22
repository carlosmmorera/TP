package tp.pr3.ByteCode.Arithmetics;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.CPU.CPU;
/**
 * Clase que gestiona el operador aritm�tico Mul
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public class Mul extends Arithmetics{
	/**
	 * M�todo que ejecuta el ByteCode
	 * @param cpu objeto de la clase @see {@link tp.pr2.CPU}
	 * @param op1 operando 1
	 * @param op2 operando 2
	 * @return booleano dependiendo de si la operaci�n se realiz� con �xito o no
	 */
	public boolean ejec(CPU cpu, int op1, int op2){
		return cpu.push(op1 * op2);
	}
	/**
	 * M�todo que parsea el operador aritm�tico Mul
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Mul o no
	 */
	public ByteCode parseArith(String[] s){
		if(s[0].equalsIgnoreCase("MUL"))return new Mul();
		else return null;
	}
	/**
	 * @return la cadena de caracteres con el BC correspondiente
	 */
	public String toString(){ return "MUL"; }
}
