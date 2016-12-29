package tp.pr3.ProgramCompiler.Term;

public class Number implements Term{
	private int value;
	
	public Number(){
		this.value = 0;
	}
	public Number(int n){
		this.value = n;
	}
	public Term parse(String term){
		try{
			return StringToInt(term);
		}
		catch(NumberFormatException e){
			return null;
		}
	}
	private Term StringToInt(String term) throws NumberFormatException{
		return new Number(Integer.parseInt(term));
	}
}
