package tp.pr3.Exception;
/**
 * Excepción que se produce cuando se introduce un comando incorrecto.
 * @author Carlos Moreno
 * @author Manuel Suárez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class BadFormatCommand extends Exception{
	public BadFormatCommand(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
