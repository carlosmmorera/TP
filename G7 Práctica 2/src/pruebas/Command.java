package pruebas;


/**
 * Clase que gestiona los comandos
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 17/11/2016
 *
 */
public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	/**
	 * Creamos tres constuctores dependiendo de los par�mteros que recibo
	 * 
	 */
	public Command(ENUM_COMMAND com){
		this.command=com;
		this.instruction = new ByteCode();
	}
	public Command(ByteCode inst){
		this.command=ENUM_COMMAND.NEWINST;
		this.instruction=inst;
	}
	public Command(int rep){
		this.command=ENUM_COMMAND.REPLACE;
		this.replace=rep;
	}
	/**
	 * M�todo que ejecuta el comando
	 * @param engine
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta
	 */
	public boolean execute(Engine engine){
		System.out.println("Comienza la ejecucion de " + toString());
		
		switch (this.command){
		case QUIT: engine.quit(); return true;
		case HELP: engine.help(); return true;
		case RUN: return engine.run();
		case BYTECODE: return engine.readByteCodeProgram();
		case RESET: engine.reset(); return true;
		case REPLACE: return engine.replace(this.replace);
		default: return false;
		}
	}
	/**
	 * M�todo que transforma los comandos en cadenas de caracteres
	 * @return una string con el nombre del operando seleccionado
	 */
	public String toString(){
		String cadena;
		
		switch(this.command){
		case QUIT: cadena = "QUIT"; break;
		case HELP: cadena="HELP"; break;
		case RUN: cadena="RUN"; break;
		case NEWINST: cadena="NEWINST "; cadena+=this.instruction.toString(); break;
		case RESET: cadena="RESET"; break;
		case REPLACE: cadena="REPLACE"; break;
		default: cadena="";
		}
		return cadena;
	}
}
