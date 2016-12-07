package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class AddByteCodeProgram extends Command {
	public boolean execute(Engine engine){
		return engine.readByteCodeProgram();
	}
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("BYTECODE"))
			return new AddByteCodeProgram();
		else return null;
	}
	public String textHelp(){
		return " BYTECODE: Permite introducir todo un programa " +
				System.getProperty("line.separator");
	}
	public String toString(){
		return "BYTECODE";
	}
}
