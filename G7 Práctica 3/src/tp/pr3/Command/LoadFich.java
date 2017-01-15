package tp.pr3.Command;

import java.io.FileNotFoundException;

import tp.pr3.Exception.ArrayException;
import tp.pr3.mv.Engine;

/**
 * Clase que gestiona el comando Load.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class LoadFich implements Command{
	private String nombre;
	
	/**
	 * Constructores de la clase.
	 */
	public LoadFich(){
		this.nombre = "";
	}
	public LoadFich(String s){
		this.nombre = s;
	}
	/**
	 * M�todo que ejecuta el comando Load.
	 * @param engine: @see {@link Engine}.
	 * @throws ArrayException 
	 */
	public void execute(Engine engine) throws ArrayException, FileNotFoundException{
		engine.loadfich(this.nombre);
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Load o no.
	 */
	public Command parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new LoadFich(s[1]);
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando LOAD.
	 */
	public String textHelp(){
		return " LOAD FICH: Carga el fichero FICH como programa fuente " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "LOAD " + this.nombre;
	}
}
