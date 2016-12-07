package tp.pr2.ByteCode;

import tp.pr2.Arithmetics.*;
import tp.pr2.ConditionalJumps.*;

public class ByteCodeParser {
	private final static ByteCode[] bytecodes = {
		new Add(), new Sub(), new Mul(), new Div(), new IfEq(), new IfLe(),
		new IfLeq(), new IfNeq(), new GoTo(), new Halt(), new Load(),
		new Out(), new Push(), new Store()
	};
	final static int NUMBC = 14;
	public static ByteCode parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
				String[] subcadenas = line.split(" ");
				ByteCode bc = null;
				int i=0;
				boolean encontrado = false;
				
				while (i < NUMBC && !encontrado){
					bc = bytecodes[i].parse(subcadenas);
					encontrado = bc != null;
					++i;
				}
				return bc;
	}
}
