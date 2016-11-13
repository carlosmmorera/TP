package TP.PR1.MV;

//Clase de las instrucciones bytecode
public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;
	
	//Tres constructores dependiendo de los parámetros
	public ByteCode(){
		this.name= null;
	}
	public ByteCode(ENUM_BYTECODE bc){
		this.name=bc;
		/*Si tan solo te dan el nombre de la instrucción y se trata de push,
		 * load o store (que requieren de parámetros) la inicialización es
		 * incorrecta y por tanto le asigno null*/
		if (bc == ENUM_BYTECODE.PUSH) this.name = null;
		else if (bc == ENUM_BYTECODE.LOAD) this.name = null;
		else if (bc == ENUM_BYTECODE.STORE) this.name = null;
	}
	public ByteCode(ENUM_BYTECODE bc, int par){
		this.name=bc;
		this.param=par;
	}
	//Método que transforma las instrucciones bytecode en String
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
	//Método que comprueba que la instrucción está bien definida
	public boolean comprobarbc(){
		return this.name != null;
	}
	//Método que devuelve el parámetro
	public int getParam(){
		return this.param;
	}
	//Método que devuelve la instrucción sin el parámetro
	public ENUM_BYTECODE getEnum(){
		return this.name;
	}
}
