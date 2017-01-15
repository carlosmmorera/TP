package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se introduce un comando incorrecto.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class BadFormatCommand extends Exception{
	public BadFormatCommand(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
