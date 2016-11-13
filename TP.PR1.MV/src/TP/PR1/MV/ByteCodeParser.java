package TP.PR1.MV;

//Clase que se encarga de parsear las instrucciones bytecode
public class ByteCodeParser {
	public static ByteCode parse(String s){
		//Divido la cadena dada en palabras separadas por espacios
		String[] subcadenas=s.split(" ");
		ByteCode bc;
		ENUM_BYTECODE ebc;
		
		//La instrucción debe coincidir con alguna de las dadas
		switch (subcadenas[0]){
		case "push": ebc=ENUM_BYTECODE.PUSH; break;
		case "load": ebc=ENUM_BYTECODE.LOAD; break;
		case "store": ebc=ENUM_BYTECODE.STORE; break;
		case "add": ebc=ENUM_BYTECODE.ADD; break;
		case "sub": ebc=ENUM_BYTECODE.SUB; break;
		case "mul": ebc=ENUM_BYTECODE.MUL; break;
		case "div": ebc=ENUM_BYTECODE.DIV; break;
		case "out": ebc=ENUM_BYTECODE.OUT; break;
		case "halt": ebc=ENUM_BYTECODE.HALT; break;
		default: return null;
		}
		//Dependiendo del número de palabras la incializo o añado algún parámetro
		if (subcadenas.length == 1) bc = new ByteCode(ebc);
		else if (subcadenas.length == 2){
			int par= Integer.parseInt(subcadenas[1]);
			bc=new ByteCode(ebc, par);
		}
		else return null;
		
		return bc;
	}
}
