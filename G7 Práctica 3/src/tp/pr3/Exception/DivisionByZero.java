package tp.pr3.Exception;

public class DivisionByZero extends Exception{
	public DivisionByZero(){
		super("Error de ejecución al intentar dividir por cero");
	}
}
