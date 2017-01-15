package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se intenta introducir una nueva variable y la tabla
 * de variables est� llena.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class VariableTableOverflow extends Exception{
	public VariableTableOverflow(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
