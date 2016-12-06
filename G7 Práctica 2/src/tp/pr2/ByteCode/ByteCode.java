package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public abstract class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] s);
}
