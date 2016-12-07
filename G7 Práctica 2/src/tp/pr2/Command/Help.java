package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class Help extends Command {
	public boolean execute(Engine engine){
		CommandParser.showHelp();
		return true;
	}
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else return null;
	}
	public String textHelp(){
		return " HELP: Muestra esta ayuda " +
				System.getProperty("line.separator");
	}
	public String toString(){
		return "HELP";
	}
}
