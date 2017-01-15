package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se escribe una instrucci�n de manera incorrecta
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception{
	public LexicalAnalysisException(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
