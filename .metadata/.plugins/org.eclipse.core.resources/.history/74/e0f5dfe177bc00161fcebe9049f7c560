package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class Run extends Command {
	public boolean execute(Engine engine){
		return engine.run();
	}
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;
	}
	public String textHelp(){
		return " RUN: Ejecuta el programa " +
				System.getProperty("line.separator");
	}
}
