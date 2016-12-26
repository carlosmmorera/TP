package tp.pr3.Command;

import tp.pr3.mv.Engine;
/**
 * Clase abstracta que gestiona los comandos de la que heredan AddByteCommand,
 *  Help, Quit, Replace, Reset y Run
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/11/2016
 *
 */
public interface Command {
	abstract public boolean execute(Engine engine);
	abstract public Command parse(String[] s);
	abstract public String textHelp();
}
