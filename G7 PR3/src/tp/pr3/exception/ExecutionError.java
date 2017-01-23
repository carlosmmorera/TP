package tp.pr3.exception;
/**
 * Excepci�n que se produce cuando se origina un error en la ejecuci�n de un programa.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class ExecutionError extends Exception{
	private String ExceptionMessage;

	public ExecutionError(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
