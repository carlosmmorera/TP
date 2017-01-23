package tp.pr3.bytecode;

import tp.pr3.cpu.CPU;
import tp.pr3.exception.ArrayException;
import tp.pr3.exception.DivisionByZero;
import tp.pr3.exception.StackException;
import tp.pr3.exception.StackTooSmall;
/**
 * Clase abstracta que gestiona todos los ByteCode.
 * 
 * De ella heredan: GoTo, Halt, Load, Out, Push, Store, Arithmetics 
 * y ConditionalJumps.
 * @author Carlos Moreno
 * @author Manuel Suárez
 * @version 12/01/2017
 *
 */
public interface ByteCode {
	public void execute(CPU cpu) throws DivisionByZero, ArrayException, 
		StackException, StackTooSmall;
	public ByteCode parse(String[] s);
}
