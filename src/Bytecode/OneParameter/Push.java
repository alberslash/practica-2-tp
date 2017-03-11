package Bytecode.OneParameter;

import Bytecode.ByteCode;
import CPU.CPU;
/**
 * Clase Push paquete bytecode oneParameter
 * @author User
 *
 */
public class Push extends ByteCodeOneParameter{
	/**
	 * Apila en memoria
	 */

	public Push() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Push(int p) {
		super(p);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("PUSH")) return new Push(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "PUSH ";
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.push(this.param);
	}
}
