package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfEq extends ConditionalJumps{
	public IfEq(int n){
		super(n);
	}
	public IfEq(){
		super();
	}
	public boolean execute(CPU cpu){
		int op1 = cpu.pilapop();
		
		if (op1 == cpu.pilapop()) return true;
		else return cpu.goTo(this.pos);
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("IFEQ")) return new IfEq(Integer.parseInt(s[1]));
		else return null;
	}
	public String toString(){
		return "IFEQ " + this.pos;
	}
}
