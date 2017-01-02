package tp.pr3.ByteCode.Arithmetics;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.CPU.CPU;
import tp.pr3.Exception.*;
/**
 * Clase que gestiona el operador aritmético Div.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 *
 */
public class Div extends Arithmetics{
	/**
	 * Método que ejecuta el ByteCode.
	 * @param cpu objeto de la clase @see {@link tp.pr2.CPU}.
	 * @param op1 operando 1.
	 * @param op2 operando 2.
	 * @throws DivisionByZero al intentar dividir por 0.
	 */
	public void ejec(CPU cpu, int op1, int op2)throws DivisionByZero, StackException{
		if (op2 == 0) throw new DivisionByZero();
		cpu.push(op1 / op2);
	}
	/**
	 * Método que parsea el operador aritmético Div.
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido.
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Div o no.
	 */
	public ByteCode parseArith(String[] s){
		if(s[0].equalsIgnoreCase("DIV"))return new Div();
		else return null;
	}
	/**
	 * @return la cadena de caracteres con el BC correspondiente.
	 */
	public String toString(){
		return "DIV";
	}
}
