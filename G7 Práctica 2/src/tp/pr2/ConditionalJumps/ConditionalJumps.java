package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public abstract class ConditionalJumps extends ByteCode{
	final static int NUMCONDJUMPS = 4;
	final static int NUMOPERANDOS = 2;
	private final static ConditionalJumps[] condj = {
		new IfEq(), new IfNeq(), new IfLe(), new IfLeq()
	};
	protected int pos;
	public ConditionalJumps(int p){
		this.pos = p;
	}
	public ConditionalJumps(){
		this.pos = 0;
	}
	public boolean execute(CPU cpu){
		if (cpu.haynelempila(NUMOPERANDOS)){
			ByteCode bc = cpu.getInstr();
			return bc.execute(cpu);
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 2){
			ByteCode bc = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMCONDJUMPS && !encontrado){
				bc = condj[i].parse(s);
				encontrado = bc != null;
				++i;
			}
			return bc;
		}
		else return null;
	}
}
