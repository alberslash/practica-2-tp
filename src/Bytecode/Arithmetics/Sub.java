package Bytecode.Arithmetics;

import Bytecode.ByteCode;
import CPU.CPU;
/**
 * Clase sub,  paquete bytecode y arithmetics
 * @author User
 *
 */
public class Sub extends Arithmetics{
	/**
	 * Clase que realiza las restas de las operaciones arithmeticas
	 */

	public Sub() {
		super();
	}
	
	@Override
	protected boolean execute(int n1, int n2, CPU cpu) {
		cpu.push((n2 - n1));
		return true;
	}

	@Override
	protected ByteCode parseAux(String words) {
		if(words.equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
	public String toString() {
		return "SUB";
	}







}
