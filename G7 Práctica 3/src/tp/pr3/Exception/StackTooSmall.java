package tp.pr3.Exception;
/**
 * Excepción que se produce cuando se intenta sacar un elemento de la pila y esta, está
 * vacía.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class StackTooSmall extends ExecutionError{
	public StackTooSmall(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
