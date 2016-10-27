package TP.PR1.MV;

public class CommandParser {
	public static Command parse(String line){
		String[] subcadenas=line.split(" ");
		
		switch(subcadenas[0]){
		case "help":
		case "quit":
			
		default: return null;	
		}
	}
}
