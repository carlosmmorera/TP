package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se intenta introducir un elemento y la pila est� llena.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class StackException extends ExecutionError{
	public StackException(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
