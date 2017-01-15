package tp.pr3.Exception;
/**
 * Excepción que se produce cuando se escribe una instrucción de manera incorrecta
 * @author Carlos Moreno
 * @author Manuel Suárez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception{
	public LexicalAnalysisException(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
