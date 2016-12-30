package tp.pr3.Command;

import tp.pr3.Exception.*;
import tp.pr3.mv.Engine;

public class Compile implements Command{
	@Override
	public void execute(Engine engine) {
		try{
			this.ejec(engine);
		}
		catch (Exception e){
			
		}
	}
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else return null;
	}
	public String textHelp(){
		return " COMPILE: Compila el programa introducido " +
				System.getProperty("line.separator");
	}
	public String toString(){
		return "COMPILE";
	}
	private void ejec(Engine engine)
			throws LexicalAnalysisException, ArrayException{
		engine.compile();
	}
}
