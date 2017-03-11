package Main;
import Bytecode.ByteCode;
/**
 * Paquete MAIN, clase ByteCodeProgram
 *
 */
public class ByteCodeProgram {
	
	private static final int MAX_INSTR = 100;
	private ByteCode[] bcprogram;
	private int numBc = 0;
	/**
	 * Constructoras
	 */
	public ByteCodeProgram(){
		this.bcprogram = new ByteCode[MAX_INSTR];
	}
	/**
	 * Añade una instruccion al programa siempre que no haya llegado al maximo
	 * 
	 */
	public boolean addBCInstruction (ByteCode instr){ 
		if (this.numBc < MAX_INSTR){
			bcprogram[numBc] = instr;
			numBc++;
			return true;
		}
		return false;		
	}
	
	public int getNumberOfByteCode(){
		return this.numBc;
		
	}
	
	public ByteCode getByteCode (int i){
		return this.bcprogram[i];
	}
	
	/**
	 * Muestra una instruccion almacenada, se le llama con un for
	 */
	public String toString(){ 
		String mensaje = "";
		for(int i = 0; i < this.numBc; i++){
			mensaje += i + ": " + bcprogram[i].toString() + System.getProperty("line.separator");
		}
		return mensaje;
	}
	
	/**
	 * resetea el programa
	 */
	public void reset(){
		
		this.numBc = 0;
	}
	
	/**
	 * Cambio de las instrucciones bc por la que el usuario elige
	 * 
	 */
	public void replace (int replace, ByteCode bc) //Cambio de instrucciones
	{
		if (this.numBc < MAX_INSTR){
			bcprogram[replace] = bc;
		}

	}
}
