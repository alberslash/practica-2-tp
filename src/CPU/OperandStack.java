package CPU;

/**
 * Paquete cpu, clase operandstack igual que practica 1
 * @author User
 *
 */
public class OperandStack {
	
	
	public static final int MAX_STACK = 100;
	private int [] stack; /*Creamos un array*/
	private int numElems;

	public OperandStack () { /*constructora */
		this.numElems = 0;
		this.stack = new int[OperandStack.MAX_STACK]; /*Creamos un nuevo objeto con la capacidad maxima*/
	}
	
	/**
	 * Comprueba si la pila esta vacia, devuelve un booleano 
	 */
	public boolean isEmpty() { /*Comprueba que est� vacio*/
		if (this.numElems >= 1) return false;
		else return true;
	}
	
	/**
	 * Realiza la operacion push del valor que le entra por parametro.
	 * Para ello comprobamos si hay espacio, en caso de que lo haya
	 * lo guardamos en la primera posicion libre y devolvemos true,
	 *  en caso contrario devolvemos false;
	 * 
	 */
	public boolean push(int value){
	
		if (this.numElems < OperandStack.MAX_STACK){ /*Comprobamos que hay espacio*/
			this.stack[this.numElems] = value;/*Guardamos en la primero pos libre el valor*/
			this.numElems++; 
			return true;
		}
		else return false; /*Si est� llena devuelve false */
	
	}
	/**
	 * Comprobamos que la pila no este vacia, una vez hagamos eso
	 * liberamos espacio de la pila y devolvemos la nueva capadidad del array.
	 * @return
	 */
	
	public int pop(){
	
		if (!isEmpty()){ /*Comprobamos si esta vacia*/
		this.numElems--; /*Liberamos un espacio */
		return this.stack[this.numElems]; /*Devolvemos la capacidad del array*/
		}
		else return 0; /*revisar*/
	
	}
	/**
	 * 
	 * Saca la cima de la pila
	 */

	public int getCima(){ 
		
		int value= this.stack[numElems - 1];
		
		return value;
			
	}
	
	public void setOStack(){
		this.numElems = 0;
	}
	public int getNumElems(){
		return this.numElems;
	}
	
	public boolean checkNumber(){
		if (getCima() == 0) return false;
		else return true;
	}
	public String toString(){
		String mensaje = "";
		if (this.numElems > 0){
			for (int i = 0; i < this.numElems; i++){
			mensaje += stack[i] + "  ";
			}
		}
		else mensaje = "<vacia>" + System.getProperty("line.separator");
		return mensaje;
	}
	
	public void vaciarArray(){
		for(int i = 0; i < this.numElems;i++){
			stack[i] = 0;
		}
		this.numElems = 0;
	}
	
}
