package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Sub extends Arithmetics{
	public boolean execute(CPU cpu){
		
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
}
