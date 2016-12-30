package tp.pr3.Exception;

public class ArrayException extends Exception{
	public ArrayException(){
		super("Error al intentar acceder a una posición inexistente de un array");
	}
}
