package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfEq extends ConditionalJumps{
	private int pos;
	public IfEq(int n){
		this.pos = n;
	}
	public IfEq(){
		this.pos = 0;
	}
	public boolean execute(CPU cpu){
		int op1 = cpu.pilapop();
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("IFEQ")) return new IfEq(Integer.parseInt(s[1]));
		else return null;
	}
}
