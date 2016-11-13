package TP.PR1.MV;

import java.util.Scanner;

//Clase que gestiona el programa
public class ByteCodeProgram {
	/*@param program es un array que guarda todas las instrucciones dle programa
	 * @param newinst guarda el número de instrucciones de las que consta el array*/
	private ByteCode[] program;
	int newinst;
	
	//Inicializo el vector por defecto a 100
	public ByteCodeProgram(){
		this.program = new ByteCode[100];
		this.newinst=0;
	}
	////Método que muestra el programa almacenado
	public void mostrar(){
		System.out.println("Programa almacenado:");
		String cadena;
		
		//Recorre todo el array
		for (int i=0; i<this.newinst; ++i){
			cadena = Integer.toString(i);
			cadena += ": " + this.program[i].toString();
			System.out.println(cadena);
		}
	}
	//Método que inserta una nueva instrucción en el programa
	public boolean pushbc(ByteCode bc){
		//Si la instrucción es correcta la inserta
		if (bc.comprobarbc()){
			this.program[this.newinst] = bc;
			++this.newinst;
			return true;
		}
		else return false;
	}
	//Método que resetea, poniendo el número de elementos del vector a 0
	public void reset(){ this.newinst=0; }
	
	//Método que reemplaza la instrucción n-ésima del programa por otra dada
	public boolean replace(int n){
		if (n > 0 && n < this.newinst){
			System.out.print("Nueva instruccion: ");
			
			//pido la nueva instrucción
			Scanner entrada = new Scanner(System.in);
			String strbc=entrada.nextLine();
			
			//Parseo la instrucción dada por el usuario
			ByteCode bc = ByteCodeParser.parse(strbc);
			//Inserto la nueva instrucción si es correcta
			if (bc.comprobarbc()){
				this.program[n]=bc;
				return true;
			}
			else return false;
		}
		else return false;
	}
	//Método que devuelve la instrucción n-ésima del programa
	public ByteCode instn(int n){
		return this.program[n];
	}
	//Método que devuelve el número de instrucciones del programa
	public int getTam(){
		return this.newinst;
	}
}
