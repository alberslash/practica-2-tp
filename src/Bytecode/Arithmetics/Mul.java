package Bytecode.Arithmetics;

import Bytecode.ByteCode;
/**
 * Clase MUl,  paquete bytecode y arithmetics
 */
import CPU.CPU;

public class Mul extends Arithmetics {
	
	/**
	 * Realiza las multiplicaciones de las operaciones arithmeticas
	 */

/*----------- CONSTRUCTORA -------------*/
	
	public Mul() {
		super();
		// TODO Auto-generated constructor stub
	}

/*------------METODOS------------*/

	
	@Override
	protected boolean execute(int n1, int n2, CPU cpu) {
		cpu.push(n1*n2);
		return true;
	}

	@Override
	protected ByteCode parseAux(String words) {
		if(words.equalsIgnoreCase("MUL")) return new Mul();
		return null;
	}
	
	public String toString() {
		return "MUL ";
	}
}
