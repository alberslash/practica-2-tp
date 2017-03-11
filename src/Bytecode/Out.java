package Bytecode;

import CPU.CPU;
/**
 * Clase out, paquete bytecode
 * @author User
 *
 */
public class Out extends ByteCode {
	/**
	 * Escribe el entero almacenado en la cima de la pila
	 */

	public Out() {
		super();
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.out();
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length != 1 || !words[0].equalsIgnoreCase("OUT")) return null;
		else return new Out();
	}
		
	public String toString(){
		return "OUT";
	}
}
