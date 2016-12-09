package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Store extends ByteCode{
	private int n;
	public Store(){
		this.n = 0;
	}
	public Store(int a){
		this.n = a;
	}
	public boolean execute(CPU cpu){
		return cpu.store(this.n);
	}
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("STORE"))
			return new Store(Integer.parseInt(s[1]));
		else return null;
	}
	public String toString(){
		return "STORE " + this.n;
	}
}
