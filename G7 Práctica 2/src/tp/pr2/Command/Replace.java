package tp.pr2.Command;

import tp.pr2.mv.Engine;

public class Replace extends Command {
	private int pos;
	
	public Replace(){
		this.pos = 0;
	}
	public Replace(int p){
		this.pos = p;
	}
	
	public boolean execute(Engine engine){
		return engine.replace(this.pos);
	}
	public Command parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("REPLACE")){
			int p = Integer.parseInt(s[1]);
			Replace rep = new Replace(p);
			
			if (p >= 0) return rep;
			else return null;
		}
		else return null;
	}
	public String textHelp(){
		return " REPLACE N: Reemplaza la instruccion N por la solicitada"
				+ " al usuario " + System.getProperty("line.separator");
	}
	public String toString(){
		return "REPLACE " + this.pos;
	}
}
