package tp.pr3.exception;
/**
 * Excepción que se produce cuando se introduce un ByteCode incorrecto.
 * @author Carlos Moreno
 * @author Manuel Suárez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class BadFormatByteCode extends Exception{
	private String ExceptionMessage;
	
	public BadFormatByteCode(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
