package pruebas;


/**
 * Esta clase define las instrucciones bytecode
 * 
 * @author Carlos Moreno 
 * @author Manuel Su�rez
 * @version: 17/11/2016
 *
 */
public class ByteCode {
	//Campos de la clase
	private ENUM_BYTECODE name;
	private int param;
	
	/**
	 * Dise�o tres constructores en funci�n de los par�metros que recibe
	 */
	public ByteCode(){
		this.name= null;
	}

	public ByteCode(ENUM_BYTECODE bc){
		this.name=bc;
		/**Si tan solo te dan el nombre de la instrucci�n y se trata de push,
		 * load o store (que requieren de par�metros) la inicializaci�n es
		 * incorrecta y por tanto le asigno null
		 * */
		if (bc == ENUM_BYTECODE.PUSH) this.name = null;
		else if (bc == ENUM_BYTECODE.LOAD) this.name = null;
		else if (bc == ENUM_BYTECODE.STORE) this.name = null;
	}
	
	public ByteCode(ENUM_BYTECODE bc, int par){
		this.name=bc;
		this.param=par;
	}
	/**
	* M�todo que transforma las instrucciones bytecode en String
	* @return una string con el nombre del operando
	*/
	public String toString(){
		String cadena;
		String par=Integer.toString(this.param);
		
		if (this.name != null){
			switch(this.name){
			case PUSH: cadena= "PUSH " + par;break;
			case LOAD: cadena="LOAD " + par; break;
			case STORE: cadena= "STORE " + par; break;
			case ADD: cadena="ADD"; break;
			case SUB: cadena="SUB"; break;
			case MUL: cadena="MUL"; break;
			case DIV: cadena="DIV"; break;
			case OUT: cadena="OUT"; break;
			case HALT: cadena="HALT"; break;
			default: cadena="";
			}
		}
		else cadena = "";
		return cadena;
	}
	/**
	 * M�todo que comprueba que la instrucci�n est� bien definida
	 * @return un booleano que indica si el bytecode es correcto
	 */
	public boolean comprobarbc(){
		return this.name != null;
	}
	/**
	 * @return el par�metro del bytecode
	 */
	public int getParam(){
		return this.param;
	}
	/**
	 * @return la instrucci�n sin el par�metro
	 */
	public ENUM_BYTECODE getEnum(){
		return this.name;
	}
}
