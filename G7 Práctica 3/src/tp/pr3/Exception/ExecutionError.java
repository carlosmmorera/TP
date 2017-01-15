package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se origina un error en la ejecuci�n de un programa.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class ExecutionError extends Exception{
	public ExecutionError(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
