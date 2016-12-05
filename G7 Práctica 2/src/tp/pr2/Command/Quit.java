package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class Quit extends Command {
	public boolean execute(Engine engine){
		return engine.quit();
	}
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;
	}
	public String textHelp(){
		return " QUIT: Cierra la aplicacion " +
				System.getProperty("line.separator");
	}
}
