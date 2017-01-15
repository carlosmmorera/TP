package tp.pr3.Exception;
/**
 * Excepción que se produce cuando se intenta introducir un elemento y la pila está llena.
 * @author Carlos Moreno
 * @author Manuel Suárez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class StackException extends ExecutionError{
	public StackException(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
