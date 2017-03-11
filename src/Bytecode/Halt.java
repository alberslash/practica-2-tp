package Bytecode;

import CPU.CPU;

/**
 * Clase Halt, paquete byteCode
 * @author User
 *
 */
public class Halt extends ByteCode {
	/**
	 * Para la maquina virtual
	 */

	public Halt() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.halt();
		return true;
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length != 1 || !words[0].equalsIgnoreCase("HALT")) return null;
		else return new Halt();
	}
	
	public String toString(){
		return "HALT";
	}

}
