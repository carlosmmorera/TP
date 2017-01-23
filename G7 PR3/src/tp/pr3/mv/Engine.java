package tp.pr3.mv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp.pr3.bytecode.*;
import tp.pr3.command.*;
import tp.pr3.cpu.CPU;
import tp.pr3.exception.*;
import tp.pr3.programcompiler.*;
/**
 * Clase que gestiona la ejecución de la máquina virtual.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 15/01/2017
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
	 * Método que dirige todo el programa.
	 */
	public void start(){
		String line = "";
		Command com = null;
		
		//Hasta que el usuario no ejecute "quit" no finalizará el pograma
		while(!this.end){
			System.out.print("> ");
			//Se lee el comando
			line = entrada.nextLine();
			com = CommandParser.parse(line);
			try{
				if (com == null) throw new BadFormatCommand("Error en la sintáxis "
						+ "del Comando introducido.\nEl Comando '" + line 
						+ "' no existe.");
				
				System.out.println("Comienza la ejecucion de " + 
				com.toString() + ".");
				com.execute(this);
				
				/*
				 * Solo se mostrará el programa almacenado si no se ejecutado
				 * el comando quit y si no se ha producido ningún error en la
				 * ejecución del comando (en cuyo caso se lanzaría una 
				 * excepción que es gestionada en el catch).
				 */
				if (!this.end){
					if (this.sProgram.getNumeroInstrucciones() > 0)
						System.out.println(this.sProgram.toString());
					/*
					 * Si el programa tiene instrucciones añadidas se 
					 * muestra al usuario
					 */
					if (this.bytecodeProgram.getTam() > 0) 
						System.out.println(this.bytecodeProgram.toString());
				}
			}
			catch (BadFormatByteCode | BadFormatCommand | NonexistentVariable | 
					ExecutionError | VariableTableOverflow | ArrayException |
					LexicalAnalysisException e){
				System.out.println(e.toString());
			}
			catch (FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			catch (NonexistentBCProgram e){
				System.out.println(e.toString());
				
				if (!this.end && this.sProgram.getNumeroInstrucciones() > 0)
					System.out.println(this.sProgram.toString());
			}
		}
		System.out.println("Fin de la ejecucion...");
	}
	/**
	 * Método que implementa el comando QUIT.
	 */
	public void quit(){ this.end = true; }
	/**
	 * Método que implementa el comando RUN.
	 * @throws ExecutionError
	 * @throws NonexistentBCProgram 
	 */
	public void run()throws ExecutionError, NonexistentBCProgram{
		//Inicializo una CPU
		if (this.bytecodeProgram.getTam() == 0) throw new NonexistentBCProgram("Error: "
				+ "No hay ningún programa ByteCode a ejecutar.");
		CPU cpu = new CPU(this.bytecodeProgram);
		cpu.run();
		System.out.println("El estado de la maquina tras ejecutar "
				+ "el programa es:");
		System.out.println(cpu.toString());
	}
	/**
	 * Método que ejecuta el comando REPLACE.
	 * @param rep instrucción a reemplazar
	 * @throws BadFormatByteCode
	 * @throws ArrayException
	 */
	public void replaceBC(int rep) throws BadFormatByteCode, ArrayException{ 
		this.bytecodeProgram.replace(rep);
	}
	/**
	 * Método que ejecuta el comando COMPILE.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws NonexistentVariable 
	 * @throws VariableTableOverflow
	 */
	public void compile() throws LexicalAnalysisException, ArrayException,
		VariableTableOverflow, NonexistentVariable{
		this.pProgram.reset();
		this.bytecodeProgram.reset();
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	/**
	 * Método encargado de realizar el análisis léxico y parsear el programa.
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException{
		LexicalParser lx = new LexicalParser(this.sProgram);
		lx.lexicalParser(this.pProgram, "END");
	}
	/**
	 * Método encargado de compilar el programa y generar el ByteCode correspondiente.
	 * @throws ArrayException
	 * @throws NonexistentVariable 
	 */
	private void generateByteCode() throws ArrayException, 
		VariableTableOverflow, NonexistentVariable{
		tp.pr3.programcompiler.Compiler compiler = 
				new tp.pr3.programcompiler.Compiler(this.bytecodeProgram);
		compiler.compile(this.pProgram);
	}
	/**
	 * Método que resetea el SourceProgram, ParsedProgram y ByteCodeProgram.
	 */
	private void resetProgram(){
		this.sProgram.reset();
		this.pProgram.reset();
		this.bytecodeProgram.reset();
	}
	/**
	 * Método que implementa el comando LOAD
	 * @param nombre: nombre del fichero a cargar
	 * @throws ArrayException 
	 * @throws FileNotFoundException
	 */
	public void loadfich(String nombre) throws ArrayException, FileNotFoundException{
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
			throw new FileNotFoundException("Excepcion: Fichero no Encontrado...");
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
