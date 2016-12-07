package tp.pr2.Command;

/**
 * Clase que gestiona el parseo de comandos
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 17/11/2016
 *
 */
public class CommandParser {
	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() 
	};
	
	final static int NUMCOMANDOS = 6;
	/**
	 * 
	 * @param line string que se va a parsear
	 * @return el comando que se corresponde con la string
	 */
	public static Command parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas = line.split(" ");
		Command comando = null;
		int i=0;
		boolean encontrado = false;
		
		while (i < NUMCOMANDOS && !encontrado){
			comando = commands[i].parse(subcadenas);
			encontrado = comando != null;
			++i;
		}
		return comando;
	}
	
	public static void showHelp(){
		for (int i = 0; i < NUMCOMANDOS; ++i){
			System.out.print(commands[i].textHelp());
		}
	}
}
