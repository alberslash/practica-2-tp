package Bytecode.Arithmetics;

import Bytecode.ByteCode;

/**
 * Clase arithmetics paquete bytecode
 */
import CPU.CPU;

public abstract class Arithmetics extends ByteCode{
	
	/**
	 * Clase abstracta para las operaciones arithmeticas
	 * parsea cada una de ellas
	 */

	public Arithmetics() {
		super();
	}
	
	abstract protected boolean execute(int n1,int n2, CPU cpu);

	public boolean execute( CPU cpu){
		if(cpu.getSizeStack() >= 2){
			int n1 = cpu.pop();
			int n2 = cpu.pop();
		 
			return this.execute(n1, n2, cpu);
		}
		else return false;
	}
	
	public ByteCode parse(String[] words){
		if(words.length != 1) return null;
		else return this.parseAux(words[0]);
	}
	
	abstract protected ByteCode parseAux(String words);

}
