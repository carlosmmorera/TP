package TP.PR1.MV;

//Clase que gestiona la memoria
public class Memory {
	/*@param memory  es un array que usamos como memoria
	 * 
	 * @param tam nos indica el tamaño de la memoria
	 * 
	 * @param posiciones es un array que guarda las posiciones
	 * en que están guardados elementos de la memoria y así se evita
	 * tener que recorrer la memoria entera cada vez que queramos mostrarla
	 * 
	 * @param tampos nos indica el tamaño de posiciones
	 * 
	 * @param numelem nos indica cuántos elementos tenemos guardados en memoria*/
	private Integer[] memory;
	private int tam;
	private int[] posiciones;
	private int tampos;
	private int numelem;
	
	//Inicializo la memoria a 100 por defecto
 	public Memory(){
		this.memory = new Integer[100];
		this.posiciones = new int[100];
		this.tampos=100;
		this.tam=100;
		for (Integer x : memory) x = null;
		this.numelem=0;
	}
 	//Método que escribe en memoria
	public boolean write(int pos, int value){
		//compruebo que la posición sea correcta
		if (pos >= 0){
			/*Mientras la memoria no conste de suficiente espacio
			 * como para poder guardar los datos en la posición solicitada
			 * la aumento redimensionando el vector*/
			while (pos >= this.tam) this.resize();
			//Escribo el elemento en su posición
			this.memory[pos] = value;
			//Redimensiono el vector posiciones si hiciera falta
			if (numelem == tampos) this.resizepos();
			
			//Añado la posición del elemento recién guardado al vector posiciones
			posiciones[numelem] = pos;
			++this.numelem;
			return true;
		}
		else return false;
	}
	//Método que lee de memorira
	public int read(int pos){
		//Redimensiono la memoria tanto como haga falta
		while (pos >= this.tam) this.resize();
		return this.memory[pos];
	}
	//Método que redimensiona la memoria
	public void resize(){
		//Creo un vector del doble del tamaño actual
		Integer newmemory[]=new Integer[2*tam];
		//Copio todos los elementos en el nuevo vector
		for (int i=0; i<tam; ++i)
			newmemory[i] = this.memory[i];
		//inicializo el vector a todo null
		for (int i=tam; i<2*tam; ++i){
			newmemory[i] = null;
		}
		//Actualizo los atributos
		this.tam = 2*tam;
		this.memory = newmemory;
	}
	//Método que redimensiona el vector de posiciones
	public void resizepos(){
		//Creo un vector del doble de su tamaño actual
		int newposiciones[]=new int[2*tampos];
		//Copio los elementos del vector antiguo en el nuevo
		for (int i=0; i<tampos; ++i)
			newposiciones[i] = this.posiciones[i];
		//Actualizo los atributos
		this.tampos = 2*tampos;
		this.posiciones = newposiciones;
	}
	//Método que muestra el estado de la memoria
	public void mostrar(){
		System.out.print("Memoria: ");
		//Si la memoria no está vacía debo mostrar sus elementos
		if (this.numelem > 0){
			/*Recorro el vector posiciones para ir directamente a las 
			 * posiciones de la memoria en las que haya algún elemento*/
			for (int i = 0; i < numelem - 1; ++i){
				int pos = this.posiciones[i];
				System.out.print("[" + Integer.toString(pos) + 
						"]: " + Integer.toString(this.memory[pos]) + " ");
			}
			int pos = this.posiciones[numelem - 1];
			System.out.println("[" + Integer.toString(pos) + 
					"]: " + Integer.toString(this.memory[pos]));
		}
		//si está vacía lo indico
		else System.out.println("<vacia>");
	}
}
