package tp.pr2.Arithmetics;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class Mul extends Arithmetics{
	public boolean execute(CPU cpu){
		
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("MUL")) return new Mul();
		else return null;
	}
}
