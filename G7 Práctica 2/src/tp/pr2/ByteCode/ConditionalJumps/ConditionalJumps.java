package tp.pr2.ByteCode.ConditionalJumps;

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
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMCONDJUMPS && !encontrado){
				encontrado = bc.getClass() == condj[i].getClass();
				if (!encontrado) ++i;
			}
			if (encontrado){
				int op2 = cpu.pilapop();
				ConditionalJumps cj = (ConditionalJumps)bc;
				return cj.ejec(cpu, cpu.pilapop(), op2);
			}
			else return false;
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 2){
			ByteCode bc = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMCONDJUMPS && !encontrado){
				String[] condjump = condj[i].toString().split(" ");
				encontrado = s[0].equalsIgnoreCase(condjump[0]);
				if (encontrado) bc = condj[i].create(Integer.parseInt(s[1]));
				++i;
			}
			return bc;
		}
		else return null;
	}
	abstract public ByteCode create(int n);
	abstract public boolean ejec(CPU cpu, int op1, int op2);
}
