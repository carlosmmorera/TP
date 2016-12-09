package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfLeq extends ConditionalJumps{
	public IfLeq(int n){
		super(n);
	}
	public IfLeq(){
		super();
	}
	public boolean ejec(CPU cpu, int op1, int op2){
		if (op1 <= op2) return true;
		else return cpu.goTo(this.pos);
	}
	public String toString(){
		return "IFLEQ " + this.pos;
	}
	public ByteCode create(int n){
		return new IfLeq(n);
	}
}
