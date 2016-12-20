package tp.pr2.Command;

import tp.pr2.mv.Engine;
/**
 * Clase que gestiona el comando Replace
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/12/2016
 */
public class Replace extends Command {
	private int pos;
	
	public Replace(){
		this.pos = 0;
	}
	public Replace(int p){
		this.pos = p;
	}
	/**
	 * Método que ejecuta el comando Replace
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecución del comando tuvo
	 * éxito o no @see {@link Engine#replace(int)}
	  */
	public boolean execute(Engine engine){
		return engine.replace(this.pos);
	}
	/**
	 * Método que parsea el comando introducido por el usuario
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
	 * Método que devuele un string con información sobre el comando REPLACE
	 */
	public String textHelp(){
		return " REPLACE N: Reemplaza la instruccion N por la solicitada"
				+ " al usuario " + System.getProperty("line.separator");
	}
	/**
	 * Método que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "REPLACE " + this.pos;
	}
}
