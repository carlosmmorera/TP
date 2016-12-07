package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class GoTo extends ByteCode{
	private int n;
	public GoTo(){
		this.n = 0;
	}
	public GoTo(int a){
		this.n = a;
	}
	public boolean execute(CPU cpu){
		return cpu.goTo(this.n);
	}
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("GOTO"))
			return new GoTo(Integer.parseInt(s[1]));
		else return null;
	}
}
