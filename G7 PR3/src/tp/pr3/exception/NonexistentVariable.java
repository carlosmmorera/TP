package tp.pr3.exception;
/**
 * Excepción que se produce cuando se intenta acceder a una variable inexistente.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class NonexistentVariable extends Exception{
	private String ExceptionMessage;
	
	public NonexistentVariable(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
