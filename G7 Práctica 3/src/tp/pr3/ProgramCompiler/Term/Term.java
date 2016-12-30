package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler);
}
