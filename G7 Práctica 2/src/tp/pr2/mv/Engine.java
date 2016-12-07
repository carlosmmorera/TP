package tp.pr2.mv;

import java.util.Scanner;



import tp.pr2.ByteCode.*;
import tp.pr2.CPU.CPU;
import tp.pr2.Command.*;
/**
 * Clase que gestiona la ejecuci�n de la m�quina virtual
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 17/11/2016
 *
 */
public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	
	/**
	 * Constructor de la clase
	 */
	public Engine(){
		this.program = new ByteCodeProgram();
		this.end = false;
	}
	
	/**
	 * M�todo que dirige todo el programa
	 */
	public void start(){
		Scanner entrada = new Scanner(System.in);
		String line;
		
		Command com;
		
		//Hasta que el usuario no ejecute "quit" no finalizar� el pograma
		while(!this.end){	
			System.out.print("> ");
			//Se lee el comando
			line = entrada.nextLine();
			//Se parsea
			com = CommandParser.parse(line);
			
			//Si no ha habido un error escribiendo el comando se ejecuta
			if (com != null){
				System.out.println("Comienza la ejecucion de " + com.toString()
						+ '\n');
				//Muestro mensaje de error si hubo un error en la ejecuci�n
				if (!com.execute(this)) 
					System.out.println("Error: Ejecucion incorrecta del comando");
			}
			//Muestro mensaje de error si hubo un error en la escritura
			else System.out.println("Error: Comando incorrecto");
			//Si el programa tiene instrucciones a�adidas se saca muestra al usuario
			if (this.program.getTam() > 0) 
				System.out.println(this.program.toString());
		}
		System.out.println("Fin de la ejecucion...");
	}
	/**
	 * M�todo que implementa el comando QUIT
	 */
	public boolean quit(){ this.end = true; return true; }
	/**
	 * M�todo que implementa el comando RUN
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta
	 */
	public boolean run(){
		boolean error = false;
		//Inicializo una CPU
		CPU cpu = new CPU(this.program);
		error = !cpu.run();
		//Si no hubo errores muestro el estado actual de la m�quina
		if (!error) System.out.println("Estado de la CPU:\n" + cpu.toString());
		return !error;
	}
	/**
	 * M�todo que ejecuta el comando RESET
	 */
	public boolean resetProgram(){ this.program.reset(); return true; }
	/**
	 * M�todo que ejecuta el comando REPLACE
	 * @param rep
	 * @return un booleano dependiendo de 
	 * si @see {@link ByteCodeProgram#replace(int)}
	 */
	public boolean replace(int rep){ return this.program.replace(rep); }
	
	public boolean readByteCodeProgram(){
		Scanner entrada = new Scanner(System.in);
		ByteCode bc = null;
		boolean error = false;
		
		System.out.println("Introduce el bytecode. Una instruccion "
				+ "por l�nea:\n");
		
		String instruccion = entrada.nextLine();
		
		while (!error && !instruccion.equalsIgnoreCase("END")){
			bc = ByteCodeParser.parse(instruccion);
			while (bc == null){
				System.out.println("ERROR: ByteCode incorrecto");
				System.out.println("Introduzca de nuevo el ByteCode\n");
				instruccion = entrada.nextLine();
				
				bc = ByteCodeParser.parse(instruccion);
			}
			error = !this.program.pushbc(bc);
			instruccion = entrada.nextLine();
		}
		return !error;
	}
}
