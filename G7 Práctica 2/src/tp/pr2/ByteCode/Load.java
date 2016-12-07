package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Load extends ByteCode{
	private int n;
	public Load(){
		this.n = 0;
	}
	public Load(int a){
		this.n = a;
	}
	public boolean execute(CPU cpu){
		return cpu.load(this.n);
	}
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(s[1]));
		else return null;
	}
}
