package tp.pr3.Command;

import tp.pr3.mv.Engine;

public class LoadFich implements Command{
	private String nombre;
	public LoadFich(String s){
		this.nombre = s;
	}
	public boolean execute(Engine engine){
		
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
