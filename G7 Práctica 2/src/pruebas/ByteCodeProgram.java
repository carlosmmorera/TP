package pruebas;


import java.util.Scanner;
/**
 * Clase que gestiona el programa
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 17/11/2016
 *
 */
public class ByteCodeProgram {
	final int TAM_INI = 100;
	/**
	 * program es un array que guarda todas las instrucciones del programa
	 * newinst guarda el número de instrucciones de las que consta el array
	 */
	private ByteCode[] program;
	int newinst;
	
	/**
	 * Constructor de la clase que inicializa el vector por defecto a 100
	 */
	public ByteCodeProgram(){
		this.program = new ByteCode[TAM_INI];
		this.newinst=0;
	}
	/**
	 * Método que muestra el programa almacenado
	 */
	public String toString(){
		String cadena = "\nPrograma almacenado:\n";
		
		//Recorre todo el array
		for (int i=0; i < this.newinst; ++i){
			cadena += Integer.toString(i);
			cadena += ": " + this.program[i].toString() + '\n';
		}
		return cadena;
	}
	/**
	 * Método que inserta una nueva instrucción en el programa
	 * @param bc
	 * @return un booleano dependiendo de si la ejecución de la instrucción 
	 * ha sido correcta
	 */
	
	public boolean pushbc(ByteCode bc){
		if (bc.comprobarbc()){
			this.program[this.newinst] = bc;
			++this.newinst;
			return true;
		}
		else return false;
	}
	/**
	 * Método que resetea, poniendo el número de elementos del vector a 0
	 */
	public void reset(){ this.newinst=0; }
	/**
	 * Método que reemplaza la instrucción n-ésima del programa por otra dada
	 * @param n el número de la instrucción que hay que cambiar
	 * @return un booleano dependiendo si el bytecode es correcto o no
	 */
	public boolean replace(int n){
		if (n > 0 && n < this.newinst){
			System.out.print("Nueva instruccion: ");
			
			//Pido la nueva instrucción
			Scanner entrada = new Scanner(System.in);
			String strbc=entrada.nextLine();
			
			
			ByteCode bc = ByteCodeParser.parse(strbc);
			
			if (bc.comprobarbc()){
				this.program[n]=bc;
				return true;
			}
			else return false;
		}
		else return false;
	}
	/**
	 * @param n posición de memoria a la que queremos acceder
	 * @return la instrucción n-ésima del programa
	 */
	public ByteCode instn(int n){
		return this.program[n];
	}
	/**
	 * 
	 * @return  el número de instrucciones del programa
	 */
	public int getTam(){
		return this.newinst;
	}
}
