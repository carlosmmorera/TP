package TP.PR1.MV;

//Clase que gestiona la pila
public class OperandStack {
	/*@param stack Es un vector con el que implementamos la pila
	 * @param numoperand Establece cu�ntos operandos hay en la pila*/
	private int[] stack;
	private int numoperand;
	
	//Constructor de la clase
	public OperandStack(){
		this.stack=new int[100];
		this.numoperand=0;
	}
	//M�todo que introduce un operando en la pila
	public void pushop(int op){
		//lo introduce en la cima
		this.stack[this.numoperand]= op;
		//Aumenta el n�mero de operandos
		++this.numoperand;
	}
	//M�todo que comprueba si se puede hacer pop
	public boolean haypop(){
		return numoperand > 0;
	}
	//M�todo que extrae el elemento de la cima de la pila
	public int pop(){
		int valor = this.stack[numoperand - 1];
		--numoperand;
		return valor;
	}
	//M�todo que muestra el estado de la pila
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
}
