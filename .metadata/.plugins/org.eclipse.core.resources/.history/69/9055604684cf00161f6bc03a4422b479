package tp.pr3.Command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import tp.pr3.mv.Engine;

public class LoadFich implements Command{
	private String nombre;
	
	public LoadFich(){
		this.nombre = "";
	}
	public LoadFich(String s){
		this.nombre = s;
	}
	public void execute(Engine engine){
		try {
			this.ejec(engine);
		} 
		catch (FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}
		catch (IOException e){
			System.out.println("Error en la lectura del archivo");
		}
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
	public boolean ejec(Engine engine) throws IOException{
		String s;
		BufferedReader fIn = new BufferedReader(new FileReader(this.nombre));
		boolean error = false;
		
		s = fIn.readLine();
		while(s != null && !error){
			error = !engine.cargarInstrProg(s);
			s = fIn.readLine();
		}
		fIn.close();
		return !error;
	}
}
