package TP.PR1.MV;

//Clase que gestiona la ejecuci�n de las instrucciones bytecode
public class CPU {
	private Memory memoria;
	private OperandStack pila;
	private boolean end;
	
	//Constructor de la clase
	public CPU(){
		this.memoria=new Memory();
		this.pila=new OperandStack();
		this.end=false;
	}
	//M�todo que ejecuta la instrucci�n bytecode dada
	public boolean execute(ByteCode instr){
		ENUM_BYTECODE inst = instr.getEnum();
		int op2 = 0;
		
		//Dependiendo de la instrucci�n ejecuto un m�todo u otro
		switch (inst){
		//Para push introduzco en la cina de la pila el par�metro dado
		case PUSH: pila.pushop(instr.getParam()); return true;
		//Llamo al m�todo de esta clase
		case LOAD: return this.load(instr.getParam());
		//Si hay elementos en la pila los escribo en memoria en la posici�n dada
		case STORE: if (pila.haypop()) return this.memoria.write(instr.getParam(), pila.pop());
					else return false; 
		//Sumo los dos elementos superiores de la pila (si existen)
		case ADD: 	if (pila.haypop()) {
							op2=pila.pop();
							if (pila.haypop()) {pila.pushop(pila.pop() + op2); return true; }
							else return false;
					}
					else return false;
		//Resto los dos elementos superiores de la pila (si existen)
		case SUB: if (pila.haypop()) {
						op2=pila.pop();
						if (pila.haypop()) {pila.pushop(pila.pop() - op2); return true; }
						else return false;
					}
					else return false;
		//Multiplico los dos elementos superiores de la pila (si existen)
		case MUL: if (pila.haypop()) {
					op2=pila.pop();
					if (pila.haypop()) {pila.pushop(pila.pop() * op2); return true; }
					else return false;
				}
				else return false;
		/*Divido los dos elementos superiores de la pila (si existen y teniendo
		 * cuidado de que el divisor no sea 0)*/
		case DIV: if (pila.haypop()) {
					op2=pila.pop();
					if (pila.haypop() && op2 != 0) {pila.pushop(pila.pop()/op2); return true; }
					else return false;
				}
				else return false;
		//Saca por pantalla el elemento de la cima de la pila
		case OUT: if (pila.haypop()) {
					System.out.println(Integer.toString(pila.pop()));
					return true;
				}
				else return false;
		//Acaba la ejecuci�n de un programa
		case HALT: this.end = true; return true;
		default: return false;
		}
	}
	//M�todo que implementa la instrucci�n LOAD
	public boolean load(int pos){
		//Leo el elemento de memoria
		Integer elem = this.memoria.read(pos);
		//Si la posici�n no era vac�a, introduzco el elemento en la pila
		if (elem != null){
			this.pila.pushop(elem);
			return true;
		}
		else return false;
	}
	//M�todo que muestra el estado de la CPU, mostrando el de la pila y memoria
	public void mostrarCPU(){
		System.out.println("Estado de la CPU:");
		this.memoria.mostrar();
		this.pila.mostrar();
	}
	//Devuelve si se ha detenido la ejecuci�n de un programa por ejecutar HALT
	public boolean getEnd(){
		return this.end;
	}
}
