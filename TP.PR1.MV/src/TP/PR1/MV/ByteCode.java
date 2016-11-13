package TP.PR1.MV;

//Clase de las instrucciones bytecode
public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;
	
	//Tres constructores dependiendo de los par�metros
	public ByteCode(){
		this.name= null;
	}
	public ByteCode(ENUM_BYTECODE bc){
		this.name=bc;
		/*Si tan solo te dan el nombre de la instrucci�n y se trata de push,
		 * load o store (que requieren de par�metros) la inicializaci�n es
		 * incorrecta y por tanto le asigno null*/
		if (bc == ENUM_BYTECODE.PUSH) this.name = null;
		else if (bc == ENUM_BYTECODE.LOAD) this.name = null;
		else if (bc == ENUM_BYTECODE.STORE) this.name = null;
	}
	public ByteCode(ENUM_BYTECODE bc, int par){
		this.name=bc;
		this.param=par;
	}
	//M�todo que transforma las instrucciones bytecode en String
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
	//M�todo que comprueba que la instrucci�n est� bien definida
	public boolean comprobarbc(){
		return this.name != null;
	}
	//M�todo que devuelve el par�metro
	public int getParam(){
		return this.param;
	}
	//M�todo que devuelve la instrucci�n sin el par�metro
	public ENUM_BYTECODE getEnum(){
		return this.name;
	}
}
