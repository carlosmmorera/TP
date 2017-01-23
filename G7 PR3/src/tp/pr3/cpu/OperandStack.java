package tp.pr3.cpu;

import tp.pr3.exception.*;

/**
 * Clase que gestiona la pila.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 30/12/2016
 */
public class OperandStack {
	final int TAM = 100;
	/**
	 * stack Es un vector con el que implementamos la pila.
	 * 
	 * numoperand Establece cuántos operandos hay en la pila.
	 */
	private int[] stack;
	private int numoperand;
	
	/**
	 * Constructor de la clase.
	 */
	public OperandStack(){
		this.stack = new int[TAM];
		this.numoperand = 0;
	}
	/**
	 * Método que introduce un operando en la pila.
	 * @param op operando a introducir.
	 * @throws StackException
	 */
	public void push(int op)throws StackException{
		if (this.pilallena())throw new StackException("Superado el tamaño máximo"
				+ "permitido de la pila.");
		
		//lo introduce en la cima
		this.stack[this.numoperand] = op;
		//Aumenta el número de operandos
		++this.numoperand;
	}
	/**
	 * Método que extrae el elemento de la cima de la pila.
	 * @return elemento extraido de la pila.
	 * @throws StackTooSmall cuando no hay elementos que extraer de la pila
	 */
	public int pop()throws StackTooSmall{
		if (this.numoperand == 0) throw new StackTooSmall("Tamaño de pila insuficiente.");
		
		int valor = this.stack[numoperand - 1];
		--numoperand;
		return valor;
	}
	/**
	 * Método que muestra el estado de la pila.
	 */
	public String toString(){
		String cadena = "\tPila: ";
		if (this.numoperand > 0){
			for (int i = 0; i < numoperand - 1; ++i){
				cadena += Integer.toString(this.stack[i]) + " ";
			}
			cadena += Integer.toString(this.stack[numoperand - 1]) + '\n';
		}
		else cadena += "<vacia>\n";
		
		return cadena;
	}
	/**
	 * Método que comprueba si la pila está llena.
	 * @return booleano dependiendo de si la pila está llena.
	 */
	private boolean pilallena(){
		return this.numoperand == TAM;
	}
}