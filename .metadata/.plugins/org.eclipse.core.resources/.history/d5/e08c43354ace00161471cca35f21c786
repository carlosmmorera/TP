package tp.pr3.ByteCode.ConditionalJumps;

import tp.pr3.ByteCode.ByteCode;
import tp.pr3.CPU.CPU;
/**
 * Clase abstracta que gestiona los ByteCode de salto condicional 
 * 
 * De ella heredan: IfEq, IfLe, IfLeq y IfNeq
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public abstract class ConditionalJumps implements ByteCode{
	final static int NUMOPERANDOS = 2;
	/**
	 * pos es la instrucción a la que se salta si se cumple la condición
	 */
	protected int pos;
	/**
	 * Constructores de la clase
	 * @param p posición a la que se salta
	 */
	public ConditionalJumps(int p){
		this.pos = p;
	}
	public ConditionalJumps(){
		this.pos = 0;
	}
	/**
	 * Método que ejecuta la operación de salto condicional deseada si es posible 
	 * @param cpu elemento de la clase @see {@link tp.pr2.CPU}
	 * @return booleano dependiendo de si la operación ha sido realizada con éxito
	 */
	public boolean execute(CPU cpu){
		if (cpu.haynelempila(NUMOPERANDOS)){
			int op2 = cpu.pilapop();
			return this.ejec(cpu, cpu.pilapop(), op2);
		}
		else return false;
	}
	/**
	 * Método que parsea la instruccion de salto condicional
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con algún salto condicional o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2)return parseCondJump(s);
		else return null;
	}
	public void setPos(int n){
		this.pos = n;
	}
	abstract public ByteCode parseCondJump(String[] s);
	abstract public boolean ejec(CPU cpu, int op1, int op2);
}
