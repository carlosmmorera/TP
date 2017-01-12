package tp.pr3.mv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import tp.pr3.ByteCode.*;
import tp.pr3.CPU.CPU;
import tp.pr3.Command.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Compiler;
/**
 * Clase que gestiona la ejecuci�n de la m�quina virtual.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/01/2017
 */
public class Engine {
	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	private ByteCodeProgram bytecodeProgram;
	private boolean end;
	
	final static Scanner entrada = new Scanner(System.in);
	/**
	 * Constructor de la clase.
	 */
	public Engine(){
		this.bytecodeProgram = new ByteCodeProgram();
		this.end = false;
		this.sProgram = new SourceProgram();
		this.pProgram = new ParsedProgram();
	}
	
	/**
	 * M�todo que dirige todo el programa.
	 */
	public void start(){
		String line = "";
		Command com = null;
		
		//Hasta que el usuario no ejecute "quit" no finalizar� el pograma
		while(!this.end){
			System.out.print("> ");
			//Se lee el comando
			line = entrada.nextLine();
			try{
				com = CommandParser.parse(line);
				
				System.out.println("Comienza la ejecucion de " + 
				com.toString() + ".");
				com.execute(this);
				
				/*
				 * Solo se mostrar� el programa almacenado si no se ejecutado
				 * el comando quit y si no se ha producido ning�n error en la
				 * ejecuci�n del comando (en cuyo caso se lanzar�a una 
				 * excepci�n que es gestionada en el catch).
				 */
				if (!this.end){
					if (this.sProgram.getNumeroInstrucciones() > 0)
						System.out.println(this.sProgram.toString());
					/*
					 * Si el programa tiene instrucciones a�adidas se 
					 * muestra al usuario
					 */
					if (this.bytecodeProgram.getTam() > 0) 
						System.out.println(this.bytecodeProgram.toString());
				}
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		System.out.println("Fin de la ejecucion...");
	}
	/**
	 * M�todo que implementa el comando QUIT.
	 */
	public void quit(){ this.end = true; }
	/**
	 * M�todo que implementa el comando RUN.
	 * @throws ExecutionError
	 */
	public void run()throws ExecutionError{
		//Inicializo una CPU
		CPU cpu = new CPU(this.bytecodeProgram);
		cpu.run();
		System.out.println("El estado de la maquina tras ejecutar "
				+ "el programa es:");
		System.out.println(cpu.toString());
	}
	/**
	 * M�todo que ejecuta el comando REPLACE.
	 * @param rep instrucci�n a reemplazar
	 */
	public void replaceBC(int rep) throws BadFormatByteCode, ArrayException{ 
		this.bytecodeProgram.replace(rep);
	}
	/**
	 * M�todo que ejecuta el comando COMPILE.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public void compile() throws LexicalAnalysisException, ArrayException,
		VariableTableOverflow{
		this.pProgram.reset();
		this.bytecodeProgram.reset();
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	/**
	 * M�todo encargado de realizar el an�lisis l�xico y parsear el programa.
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException{
		LexicalParser lx = new LexicalParser(this.sProgram);
		lx.lexicalParser(this.pProgram, "END");
	}
	/**
	 * M�todo encargado de compilar el programa y generar el ByteCode correspondiente.
	 * @throws ArrayException
	 */
	private void generateByteCode() throws ArrayException, VariableTableOverflow{
		Compiler compiler = new Compiler(this.bytecodeProgram);
		compiler.compile(this.pProgram);
	}
	/**
	 * M�todo que resetea el SourceProgram, ParsedProgram y ByteCodeProgram.
	 */
	private void resetProgram(){
		this.sProgram.reset();
		this.pProgram.reset();
		this.bytecodeProgram.reset();
	}
	/**
	 * M�todo que implementa el comando LOAD
	 * @param nombre: nombre del fichero a cargar
	 * @throws ArrayException 
	 */
	public void loadfich(String nombre) throws ArrayException{
		resetProgram();
		BufferedReader fIn = null;
		try {
			fIn = new BufferedReader(new FileReader(nombre));
			String s;
			
			s = fIn.readLine();
			while(s != null){
				this.sProgram.cargarInst(s);
				s = fIn.readLine();
			}
			fIn.close();
		} 
		catch (FileNotFoundException e){
			System.out.println("Excepcion: Fichero no Encontrado...");
		}
		catch (IOException e){
			System.out.println("Error en la lectura del archivo");
			try {
				fIn.close();
			}
			catch (IOException e1) {
				
			}
		}
	}
}
