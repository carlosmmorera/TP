package tp.pr3.exception;
/**
 * Excepci�n que se produce cuando se intenta acceder a una posici�n del
 * array inexistente.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class ArrayException extends Exception{
	private String ExceptionMessage;
	
	public ArrayException(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
