package pruebas;


/**
 * Clase que gestiona el parseo de comandos
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 17/11/2016
 *
 */
public class CommandParser {
	/**
	 * 
	 * @param line string que se va a parsear
	 * @return el comando que se corresponde con la string
	 */
	public static Command parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas=line.split(" ");
		Command comando;
		
		/*Si la longitud de la cadena es  de una palabra debe coincidir 
		 * con alguno de estos comandos*/
		if (subcadenas.length == 1){
			switch (subcadenas[0]){
			case "help": comando=new Command(ENUM_COMMAND.HELP); break;
			case "quit": comando=new Command(ENUM_COMMAND.QUIT); break;
			case "run": comando=new Command(ENUM_COMMAND.RUN); break;
			case "reset": comando=new Command(ENUM_COMMAND.RESET); break;
			//Si no coincidiera se produciría un error
			default: return null;
			}
		}
		//Si el comando es REPLACE debe tener longitud 2
		else if (subcadenas[0].equals("replace") && subcadenas.length == 2){
			int rep = Integer.parseInt(subcadenas[1]);
			comando=new Command(rep);
		}
		//Si el comando es newinst debe tener más de 1 palabra
		else if (subcadenas[0].equals("newinst") && subcadenas.length > 1) {
			//Creo un string con las restantes palabras del vector
			String s = subcadenas[1] + " ";
			for (int i=2; i<subcadenas.length - 1; ++i){
				s+=subcadenas[i] + " ";
			}
			if (subcadenas.length > 2 )s += subcadenas[subcadenas.length-1];
			//Parseo la instruccion bytecode que le sigue
			ByteCode bc = ByteCodeParser.parse(s);
			comando=new Command(bc);
		}
		//Si no coincide con ninguno de estos casos el comando no existe
		else return null;
		
		return comando;
	}
}
