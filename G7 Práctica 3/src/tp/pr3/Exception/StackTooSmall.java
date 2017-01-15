package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se intenta sacar un elemento de la pila y esta, est�
 * vac�a.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class StackTooSmall extends ExecutionError{
	public StackTooSmall(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
