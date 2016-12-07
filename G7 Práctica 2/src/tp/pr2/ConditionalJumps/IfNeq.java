package tp.pr2.ConditionalJumps;

import tp.pr2.Arithmetics.Add;
import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfNeq extends ConditionalJumps{
	private int pos;
	public IfNeq(int n){
		this.pos = n;
	}
	public IfNeq(){
		this.pos = 0;
	}
	public boolean execute(CPU cpu){
		int op1 = cpu.pilapop();
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("IFNEQ")) return new IfNeq(Integer.parseInt(s[1]));
		else return null;
	}
}
