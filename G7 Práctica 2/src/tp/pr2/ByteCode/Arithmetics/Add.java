package tp.pr2.ByteCode.Arithmetics;

import tp.pr2.CPU.CPU;

public class Add extends Arithmetics{
	public boolean ejec(CPU cpu, int op1, int op2){
		return cpu.push(op2 + op1);
	}
	public String toString(){
		return "ADD";
	}
}