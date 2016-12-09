package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfNeq extends ConditionalJumps{
	public IfNeq(int n){
		super(n);
	}
	public IfNeq(){
		super();
	}
	public boolean ejec(CPU cpu, int op1, int op2){
		if (op1 <= op2) return true;
		else return cpu.goTo(this.pos);
	}
	public String toString(){
		return "IFNEQ " + this.pos;
	}
	public ByteCode create(int n){
		return new IfNeq(n);
	}
}
