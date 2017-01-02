package tp.pr3.Command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tp.pr3.Exception.ArrayException;
import tp.pr3.mv.Engine;

/**
 * Clase que gestiona el comando Load.
 * @author Carlos Moreno
 * @author Manuel Suárez
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
	 * Método que ejecuta el comando Load.
	 * @param engine: @see {@link Engine}.
	 * @throws ArrayException 
	 */
	public void execute(Engine engine) throws ArrayException {
		BufferedReader fIn = null;
		try {
			fIn = new BufferedReader(new FileReader(this.nombre));
			String s;
			
			s = fIn.readLine();
			while(s != null){
				engine.cargarInstrProg(s);
				s = fIn.readLine();
			}
			fIn.close();
		} 
		catch (FileNotFoundException e){
			System.out.println("Excepcion: Fichero no Encontrado...");
		}
		catch (IOException e){
			System.out.println("Error en la lectura del archivo");
		}
	}
	/**
	 * Método que parsea el comando introducido por el usuario.
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
	 * Método que devuele un string con información sobre el comando LOAD.
	 */
	public String textHelp(){
		return " LOAD FICH: Carga el fichero FICH como programa fuente " +
				System.getProperty("line.separator");
	}
	/**
	 * Método que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "LOAD " + this.nombre;
	}
}
