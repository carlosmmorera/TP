package tp.pr3.bytecode.conditionaljumps;

import tp.pr3.bytecode.ByteCode;
import tp.pr3.cpu.CPU;
import tp.pr3.exception.StackTooSmall;
/**
 * Clase abstracta que gestiona los ByteCode de salto condicional.
 * 
 * De ella heredan: IfEq, IfLe, IfLeq y IfNeq.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public abstract class ConditionalJumps implements ByteCode{
	/**
	 * pos es la instrucci�n a la que se salta si se cumple la condici�n.
	 */
	protected int pos;
	/**
	 * Constructores de la clase.
	 * @param p posici�n a la que se salta
	 */
	public ConditionalJumps(int p){
		this.pos = p;
	}
	public ConditionalJumps(){
		this.pos = 0;
	}
	/**
	 * M�todo que ejecuta la operaci�n de salto condicional deseada si es posible.
	 * @param cpu elemento de la clase @see {@link tp.pr3.cpu}.
	 */
	public void execute(CPU cpu)throws StackTooSmall{
		int op2 = cpu.pilapop();
		this.ejec(cpu, cpu.pilapop(), op2);
	}
	/**
	 * M�todo que parsea la instruccion de salto condicional.
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido.
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con alg�n salto condicional o no.
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2)return parseCondJump(s);
		else return null;
	}
	/**
	 * M�todo utilizado para darle la posici�n a un Salto Condicional ya creado
	 * @param n
	 */
	public void setPos(int n){
		this.pos = n;
	}
	abstract public ByteCode parseCondJump(String[] s);
	abstract public void ejec(CPU cpu, int op1, int op2);
}
