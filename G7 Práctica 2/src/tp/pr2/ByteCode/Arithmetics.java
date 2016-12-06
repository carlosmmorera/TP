package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public abstract class Arithmetics extends ByteCode{
	final static int NUMARITH = 4;
	private final static Arithmetics[] arth = {
		new Add(), new Sub(), new Mul(), new Div()
	};
	public boolean execute(CPU cpu){
		
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
