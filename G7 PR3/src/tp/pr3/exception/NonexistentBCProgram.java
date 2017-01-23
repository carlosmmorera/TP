package tp.pr3.exception;
/**
 * Excepción que se produce cuando se intenta ejecutar un programa que no existe.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class NonexistentBCProgram extends Exception{
	private String ExceptionMessage;
	
	public NonexistentBCProgram(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
