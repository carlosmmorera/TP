package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class Reset extends Command {
	public boolean execute(Engine engine) {
		return engine.resetProgram();
	}
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RESET"))
		return new Reset();
		else return null;
	}
	public String textHelp() {
		return " RESET: Vacia el programa actual " +
		System.getProperty("line.separator");
	}
}
