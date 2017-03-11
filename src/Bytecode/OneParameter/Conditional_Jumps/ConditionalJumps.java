package Bytecode.OneParameter.Conditional_Jumps;

import Bytecode.OneParameter.ByteCodeOneParameter;
import CPU.CPU;
/**
 * Clase conditional jums paquete bytecode, oneparameter y conditional_jumps
 * @author User
 *
 */
abstract public class ConditionalJumps extends ByteCodeOneParameter {

	/**
	 * Clase abstracta de saltos condicionales
	 */
	public ConditionalJumps() {
		super();
	}

	public ConditionalJumps(int p) {
		super(p);
	}
	
	abstract protected boolean compare(int n1, int n2);
	 
	/**
	 * Ejecuta los saltos
	 */
	public boolean execute(CPU cpu) {
		 int n1 = 0;
		 int n2 = 0;
		 if (cpu.getSizeStack()>=2){
             n1 = cpu.pop();
             n2 = cpu.pop();
			 if (!compare(n2,n1)){
				 cpu.setProgramCounter(this.param);
				 return true;
			 } 
		 }
		 else return false;
		 return true;
	 }

}