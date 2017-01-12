package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.DivisionByZero;
import tp.pr3.Exception.StackException;
import tp.pr3.Exception.StackTooSmall;
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
