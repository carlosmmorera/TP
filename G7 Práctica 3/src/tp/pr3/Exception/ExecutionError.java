package tp.pr3.Exception;
/**
 * Excepción que se produce cuando se origina un error en la ejecución de un programa.
 * @author Carlos Moreno
 * @author Manuel Suárez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class ExecutionError extends Exception{
	public ExecutionError(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
