package TP.PR1.MV;
/**
 * Clase que gestiona la pila
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 17/11/2016
 *
 */
public class OperandStack {
	final int TAM = 100;
	/**
	 * stack Es un vector con el que implementamos la pila
	 * 
	 * numoperand Establece cuántos operandos hay en la pila
	 */
	private int[] stack;
	private int numoperand;
	
	/**
	 * Constructor de la clase
	 */
	public OperandStack(){
		this.stack=new int[TAM];
		this.numoperand=0;
	}
	/**
	 * Método que introduce un operando en la pila
	 * @param op operando a introducir
	 */
	public boolean push(int op){
		if (!this.pilallena()){
			//lo introduce en la cima
			this.stack[this.numoperand] = op;
			//Aumenta el número de operandos
			++this.numoperand;
			
			return true;
		}
		else return false;
	}
	/**
	 * Método que comprueba si se puede hacer pop
	 * @return un booleano dependiendo de si la pila esta vacia o no
	 */
	public boolean vacia(){
		return numoperand == 0;
	}
	/**
	 * Método que extrae el elemento de la cima de la pila
	 * @return elemento extraido de la pila
	 */
	public int pop(){
		int valor = this.stack[numoperand - 1];
		--numoperand;
		return valor;
	}
	/**
	 * Método que muestra el estado de la pila
	 */
	public void mostrar(){
		System.out.print("Pila: ");
		if (this.numoperand > 0){
			for (int i = 0; i < numoperand - 1; ++i){
				System.out.print(Integer.toString(this.stack[i]) + " ");
			}
			System.out.println(Integer.toString(this.stack[numoperand - 1]));
		}
		else System.out.println("<vacia>");
	}
	public boolean pilallena(){
		return this.numoperand == TAM;
	}
}
