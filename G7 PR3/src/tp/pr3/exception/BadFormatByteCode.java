package tp.pr3.exception;
/**
 * Excepci�n que se produce cuando se introduce un ByteCode incorrecto.
 * @author Carlos Moreno
 * @author Manuel Su�rez
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
