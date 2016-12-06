package tp.pr2.Arithmetics;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public abstract class Arithmetics extends ByteCode{
	final static int NUMARITH = 4;
	final static int NUMOPERANDOS = 2;
	private final static Arithmetics[] arth = {
		new Add(), new Sub(), new Mul(), new Div()
	};
	public boolean execute(CPU cpu){
		if (cpu.haynelempila(NUMOPERANDOS)){
			ByteCode bc = cpu.getInstr();
			return bc.execute(cpu);
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 1){
			ByteCode bc = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMARITH && !encontrado){
				bc = arth[i].parse(s);
				encontrado = bc != null;
				++i;
			}
			return bc;
		}
		else return null;
	}
}
