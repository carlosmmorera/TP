package tp.pr3.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import tp.pr3.mv.Engine;

public class LoadFich implements Command{
	private String nombre;
	public LoadFich(String s){
		this.nombre = s;
	}
	public boolean execute(Engine engine){
		String linea;
		Scanner entrada = new Scanner(new BufferedReader(new FileReader(this.nombre)));
		boolean error = false;
		
		while(entrada.hasNextLine() && !error){
			linea = entrada.nextLine();
			error = !engine.cargarInstrProg(linea);
		}
		entrada.close(); //Ver si funciona
		return !error;
	}
	public Command parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new LoadFich(s[1]);
		else return null;
	}
	public String textHelp(){
		return " LOAD FICH: Carga el fichero FICH como programa fuente " +
				System.getProperty("line.separator");
	}
	public String toString(){
		return "LOAD " + this.nombre;
	}
}
