package tp.pr3.mv;

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
 * @version 30/12/2016
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
			try{
				System.out.print("> ");
				//Se lee el comando
				line = entrada.nextLine();
				//Se parsea
				com = CommandParser.parse(line);
				
				System.out.println("Comienza la ejecucion de " + com.toString()
						+ '\n');
				com.execute(this);
			}
			catch (BadFormatByteCode e){
				System.out.println(e);
			}
			catch (ArrayException e){
				System.out.println(e);
			}
			catch (BadFormatCommand e){
				System.out.println(e);
			}
			catch(LexicalAnalysisException e){
				System.out.println(e);
			}
			finally{
				if (this.sProgram.getNumeroInstrucciones() > 0)
					System.out.println(this.sProgram.toString());
				//Si el programa tiene instrucciones a�adidas se muestra al usuario
				if (this.bytecodeProgram.getTam() > 0) 
					System.out.println(this.bytecodeProgram.toString());
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
	 */
	public void run(){
		try{
			//Inicializo una CPU
			CPU cpu = new CPU(this.bytecodeProgram);
			cpu.run();
			System.out.println("El estado de la maquina tras ejecutar "
					+ "el programa es:");
			System.out.println(cpu.toString());
		}
		catch (ArrayException e){
			System.out.println(e);
		}
		catch(DivisionByZero e){
			System.out.println(e);
		}
		catch(StackException e){
			System.out.println(e);
		}
		catch(StackTooSmall e){
			System.out.println(e);
		}
	}
	/**
	 * M�todo que ejecuta el comando REPLACE.
	 * @param rep instrucci�n a reemplazar
	 */
	public void replace(int rep) throws BadFormatByteCode, ArrayException{ 
		this.bytecodeProgram.replace(rep);
	}
	/**
	 * M�todo que ejecuta el comando COMPILE.
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public void compile() throws LexicalAnalysisException, ArrayException {
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	/**
	 * M�todo que carga una l�nea de c�digo.
	 * @param s: l�nea de c�digo a cargar.
	 * @throws ArrayException
	 */
	public void cargarInstrProg(String s)throws ArrayException{
		this.sProgram.cargarInst(s);
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
	private void generateByteCode() throws ArrayException{
		Compiler compiler = new Compiler(this.bytecodeProgram);
		compiler.compile(this.pProgram);
	}
}
