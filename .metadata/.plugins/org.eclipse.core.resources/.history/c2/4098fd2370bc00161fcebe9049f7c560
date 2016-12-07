package tp.pr2.CPU;

import tp.pr2.ByteCode.*;

/**
 * Clase que gestiona la ejecución de las instrucciones bytecode
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 17/11/2016
 *
 */
public class CPU {
	/**
	 * Memoria es un objeto de la clase @see TP.PR1.MV.Memory
	 * pila es un objeto de la clase @see TP.PR1.MV.OperandStack
	 * end es un booleano que indica cuando acaba la ejecución 
	 * de las intrucciones bytecode
	 */
	private Memory memoria;
	private OperandStack pila;
	private boolean end;
	private int programCounter;
	private ByteCodeProgram bcProgram;
	
	/**
	 * Constructor de la clase
	 */
	public CPU(){
		this.memoria = new Memory();
		this.pila = new OperandStack();
		this.end = false;
		this.programCounter = 0;
		this.bcProgram = null;
	}
	/**
	 * Método que ejecuta la instrucción bytecode dada
	 * @param instr instrucción a ejecutar
	 * @return un booleano dependiendo de si la ejecución fue correcta 
	 */
	public boolean run(){
		boolean error = false, halt = false;
		ByteCode bc = null;
		while (!this.bcProgram.cerrarPrograma(this.programCounter) && !error
				&& !halt){
			bc = this.bcProgram.getbcatn(this.programCounter);
			++this.programCounter;
			error = !bc.execute(this);
		}
		return !error;
	}
	public boolean haynelempila(int n){
		return n <= this.pila.getnumoperand();
	}
	/**
	 * Método que implementa la instrucción LOAD
	 * @param pos posición de memoria
	 * @return un booleano si la carga fue corr ecta
	 */
	public boolean load(int pos){
		//Leo el elemento de memoria
		int elem = this.memoria.read(pos);
		return this.pila.push(elem);
	}
	/**
	 * Método que muestra el estado de la CPU, mostrando el de la pila y memoria
	 */
	public String toString(){
		String cadena = "Estado de la CPU:\n";
		cadena += this.memoria.toString();
		cadena += this.pila.toString();
		return cadena;
	}
	/**
	 * 
	 * @return un booleano dependiendo de si se ha detenido
	 *  la ejecución de un programa por ejecutar HALT
	 */
	public boolean getEnd(){
		return this.end;
	}
	public ByteCode getInstr(){
		return this.bcProgram.getbcatn(this.programCounter);
	}
	public int pilapop(){
		return pila.pop();
	}
	public boolean push(int n){
		return pila.push(n);
	}
	public boolean goTo(int n){
		if (n >= 0 && n < this.bcProgram.getTam()){
			this.programCounter = n;
			return true;
		}
		else return false;
	}
	public boolean store(int n){
		if (!pila.vacia()) 
			return this.memoria.write(n, pila.pop());
		else return false; 
	}
	public boolean halt(){
		this.end = true;
		return true;
	}
	public boolean out(){
		if (!pila.vacia()) {
			System.out.println(Integer.toString(pila.pop()));
			return true;
		}
		else return false;
	}
}
