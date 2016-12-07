package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Halt extends ByteCode{
	public boolean execute(CPU cpu){
		return cpu.halt();
	}
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else return null;
	}
}
