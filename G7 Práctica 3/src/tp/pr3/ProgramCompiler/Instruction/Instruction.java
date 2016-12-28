package tp.pr3.ProgramCompiler.Instruction;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(Compiler compiler) throws ArrayException;
}
