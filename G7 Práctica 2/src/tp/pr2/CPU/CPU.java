package tp.pr2.CPU;

import tp.pr2.ByteCode.*;

/**
 * Clase que gestiona la ejecuci�n de las instrucciones bytecode
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 17/11/2016
 *
 */
public class CPU {
	/**
	 * Memoria es un objeto de la clase @see TP.PR1.MV.Memory
	 * pila es un objeto de la clase @see TP.PR1.MV.OperandStack
	 * end es un booleano que indica cuando acaba la ejecuci�n 
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
	public CPU(ByteCodeProgram prog){
		this.memoria = new Memory();
		this.pila = new OperandStack();
		this.end = false;
		this.programCounter = 0;
		this.bcProgram = prog;
	}
	/**
	 * M�todo que ejecuta la instrucci�n bytecode dada
	 * @param instr instrucci�n a ejecutar
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta 
	 */
	public boolean run(){
		boolean error = false;
		ByteCode bc = null;
		
		while (!acabar() && !error){
			bc = getInstr();
			++this.programCounter;
			error = !bc.execute(this);
			
			if (!error) {
				//Si no hubo errores muestro el estado actual de la m�quina
				System.out.println("El estado de la maquina tras "
						+ "ejecutar el bytecode " + bc.toString() + " es:");
				System.out.println(toString());
			}
		}
		return !error;
	}
	public boolean haynelempila(int n){
		return n <= this.pila.getnumoperand();
	}
	/**
	 * M�todo que implementa la instrucci�n LOAD
	 * @param pos posici�n de memoria
	 * @return un booleano si la carga fue corr ecta
	 */
	public boolean load(int pos){
		//Leo el elemento de memoria
		int elem = this.memoria.read(pos);
		return this.pila.push(elem);
	}
	/**
	 * M�todo que muestra el estado de la CPU, mostrando el de la pila y memoria
	 */
	public String toString(){
		String cadena = "Estado de la CPU:\n";
		cadena += this.memoria.toString();
		cadena += this.pila.toString();
		return cadena;
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
	public boolean acabar(){
		return this.end && this.bcProgram.cerrarPrograma(this.programCounter);
	}
}
