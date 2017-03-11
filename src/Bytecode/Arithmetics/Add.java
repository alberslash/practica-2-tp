package Bytecode.Arithmetics;

import Bytecode.ByteCode;
import CPU.CPU;
/**
 * Clase Add paquete bytecode y arithmetics
 * @author User
 *
 */

public class Add extends Arithmetics {
	/**
	 * Realiza la suma de las operaciones arithmetics
	 */
	
	public Add() {
		super();
	}

	protected ByteCode parseAux(String line){
		if(line.equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}

	@Override
	protected boolean execute(int n1, int n2, CPU cpu){
		 cpu.push((n1 + n2));
		 return true;
	}
	public String toString(){
		return "ADD";
	}
}
	
