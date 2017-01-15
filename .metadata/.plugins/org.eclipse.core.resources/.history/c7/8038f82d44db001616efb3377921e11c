package tp.pr3.CPU;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.*;

/**
 * Clase que gestiona la ejecución de las instrucciones bytecode.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class CPU {
	/**
	 * Memoria es un objeto de la clase @see TP.PR1.MV.Memory.
	 * pila es un objeto de la clase @see TP.PR1.MV.OperandStack.
	 * end es un booleano que indica cuando acaba la ejecución
	 * de las intrucciones bytecode.
	 * programCounter es un entero que representa al contador de programa.
	 * bcProgram es un objeto de la clase @see tp.pr2.ByteCode.ByteCodeProgram.
	 */
	private Memory memoria;
	private OperandStack pila;
	private boolean end;
	private int programCounter;
	private ByteCodeProgram bcProgram;
	
	/**
	 * Constructor de la clase.
	 * @param prog es el programa con el que se inicializa la CPU.
	 */
	public CPU(ByteCodeProgram prog){
		this.memoria = new Memory();
		this.pila = new OperandStack();
		this.end = false;
		this.programCounter = 0;
		this.bcProgram = prog;
	}
	/**
	 * Método que ejecuta el programa dado. 
	 * @throws ExecutionError 
	 */
	public void run() throws ExecutionError{
		ByteCode bc = null;
		try{
			while (!acabar()){
				bc = getInstr();
				bc.execute(this);
			}
		}
		catch(Exception e){
			String ExceptionMessage = "Excepción en la ejecución del bytecode ";
			ExceptionMessage += this.programCounter + ".\nExcepción-bytecode ";
			ExceptionMessage += bc.toString() + ": " + e.getMessage();
			throw new ExecutionError(ExceptionMessage);
		}
	}
	/**
	 * Método que implementa la instrucción LOAD.
	 * @param pos posición de memoria.
	 * @throws ArrayException
	 * @throws StackException
	 */
	public void load(int pos) throws ArrayException, StackException{
		//Leo el elemento de memoria
		int elem = this.memoria.read(pos);
		this.pila.push(elem);
	}
	/**
	 * Método que muestra el estado de la CPU, mostrando el de la pila y memoria.
	 */
	public String toString(){
		String cadena = "\nEstado de la CPU:\n";
		cadena += this.memoria.toString();
		cadena += this.pila.toString();
		return cadena;
	}
	/**
	 * Método que devuelve el BC que se debe ejecutar.
	 * @return ByteCode de la instrucción que se va
	 * ejecutar @see {@link ByteCodeProgram#getBcAtn(int)}.
	 * @throws ArrayException
	 * 
	 */
	public ByteCode getInstr() throws ArrayException{
		return this.bcProgram.getBcAtn(this.programCounter);
	}
	/**
	 * Método que extrae un elemento de la cima de la pila.
	 * @return int que será el elemento en la cima de la
	 * pila @see {@link OperandStack#pop()}.
	 * @throws StackTooSmall
	 */
	public int pilapop()throws StackTooSmall{
		return pila.pop();
	}
	/**
	 * Método que introduce un elemento en la pila.
	 * @param n elemento a introducir.
	 * @throws StackException
	 */
	public void push(int n)throws StackException{
		pila.push(n);
	}
	/**
	 * Método que salta a la n-ésima instrucción del programa.
	 * @param n número de instrucción a la que se desea saltar.
	 */
	public void goTo(int n){
		this.programCounter = n;
	}
	/**
	 * Método que ejecuta el ByteCode store.
	 * @param n posición de memoria.
	 * @throws ArrayException
	 * @throws StackTooSmall
	 */
	public void store(int n)throws ArrayException, StackTooSmall{
		this.memoria.write(n, pila.pop());
	}
	/**
	 * Método que ejecuta el ByteCode Halt.
	 */
	public void halt(){
		this.end = true;
	}
	/**
	 * Método que ejecuta el ByteCode Out.
	 * @throws StackTooSmall
	 */
	public void out() throws StackTooSmall{
		System.out.println("consola: " + Integer.toString(pila.pop()));
	}
	/**
	 * Método que comprueba si el programa debe acabar o no.
	 * @return booleano dependiendo de si el programa debe acabar.
	 */
	public boolean acabar(){
		return (this.end || this.bcProgram.cerrarPrograma(this.programCounter));
	}
	/**
	 * Método que aumenta en uno el valor del contador de programa.
	 */
	public void aumentarCont(){
		++this.programCounter;
	}
}
