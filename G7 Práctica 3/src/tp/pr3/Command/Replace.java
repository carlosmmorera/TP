package tp.pr3.Command;

import tp.pr3.Exception.*;
import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Replace
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Replace implements Command {
	private int pos;
	
	public Replace(){
		this.pos = 0;
	}
	public Replace(int p){
		this.pos = p;
	}
	/**
	 * M�todo que ejecuta el comando Replace
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecuci�n del comando tuvo
	 * �xito o no @see {@link Engine#replace(int)}
	  */
	public void execute(Engine engine)throws BadFormatByteCode, ArrayException{
		engine.replace(this.pos);
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario
	 * @param s cadena de caracteres introducida por el usuario
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Quit o no
	 */
	public Command parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("REPLACE")){
			int p = Integer.parseInt(s[1]);
			
			if (p >= 0) return new Replace(p);
			else return null;
		}
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando REPLACE
	 */
	public String textHelp(){
		return " REPLACE N: Reemplaza la instruccion N por la solicitada"
				+ " al usuario " + System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "REPLACE " + this.pos;
	}
}
