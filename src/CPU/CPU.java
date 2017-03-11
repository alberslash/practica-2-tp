package CPU;
import Main.ByteCodeProgram;
/**
 * Paquete CPU, clase CPU.
 */
import Bytecode.ByteCode;
public class CPU {
	
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private boolean end = false;
	private int programCounter = 0;
	private ByteCodeProgram bcProgram = new ByteCodeProgram();
	
	public CPU(ByteCodeProgram program){this.bcProgram = program;}

	/**
	 * ejecuta las instrucciones hasta llegar la la ultima
	 * y muestra el estado de la maquina y de la pila
	 * tras la ejecucion de todas las instrucciones 
	 * 
	 */
	public boolean run(){
		ByteCode bc;
		boolean out= true;
		this.programCounter = 0;
		while(this.programCounter < this.bcProgram.getNumberOfByteCode() && out ){
			bc = this.bcProgram.getByteCode(this.programCounter);
			if(!bc.execute(this)) out = false; 
			else out = true;
			this.increaseProgramCounter();
		}
		 if (out) System.out.println(this.toString());
		
		 return out;
	}
	/**
	 * Apila en la pila los elemtos 
	 * 
	 */
	public boolean push(int i){return this.stack.push(i);}
	/**
	 * Desapila
	 * @return
	 */
	public int pop() {return this.stack.pop();}
	
	/**
	 * lee de memoria
	 * 
	 */
	public int read(int param){
		return memory.read(param);
	}
	
	/**
	 * 
	 * Escribe en memoria
	 */
	public boolean write (int param, int value){
		return memory.write(param, value);
	}
	/**
	 * Contador del programa 
	 * 
	 */
	public boolean comprobarSalto(int param){
		if(param < this.bcProgram.getNumberOfByteCode()) return true;
		else return false;
	}
	
	public void setProgramCounter(int jump){
		this.programCounter = jump - 1;
	}
	
	/**
	 * Para la maquina
	 * @return
	 */
	public boolean halt(){ return end = true;} //En las diapositivas pone que es void
	
	/**
	 * Muestra el estado de la cpu la memoria y la pila
	 */
	public String toString(){
		String s = System.getProperty("line.separator") + 
				"Estado de la CPU: " + System.getProperty("line.separator") +
				"	Memoria: " + memory.toString() + System.getProperty("line.separator") +
				"	Pila: " + stack.toString() + System.getProperty("line.separator");
		return s;
	}
	/**
	 * 
	 * @return Tamaño de ña pila
	 */
	public int getSizeStack() {return this.stack.getNumElems();}
	
	/**
	 * Incremmenta el contador del programa
	 */
	public void increaseProgramCounter() {this.programCounter++;}
	
	/**
	 * escribe el entero almacenado en la cima de la pila
	 * 
	 */
	public boolean out() {
		if(!stack.isEmpty()) {
			System.out.println(stack.getCima());
			pop();
			return true;
		}
		else return false;
	}
	
	public int getNumProg(){
		return bcProgram.getNumberOfByteCode();
	}
	
	public void inicializa(){
		this.memory.vaciarArray();
		this.stack.vaciarArray();
		//this.memory.setSize();
		this.stack.setOStack();
	}
}
