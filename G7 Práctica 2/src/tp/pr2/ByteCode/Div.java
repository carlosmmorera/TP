package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Div extends Arithmetics{
	public boolean execute(CPU cpu){
		
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}
}
